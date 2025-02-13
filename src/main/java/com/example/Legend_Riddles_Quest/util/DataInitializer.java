package com.example.Legend_Riddles_Quest.util;

import com.example.Legend_Riddles_Quest.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class DataInitializer {

    private final EntityManager entityManager;

    @Autowired
    public DataInitializer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void initializeGenders() {
        String[] gendersValues = {"Male", "Female", "Other"};
        initializeData(gendersValues, Genders::new, entityManager::persist);
    }

    @Transactional
    public void initializeRegions() {
        String[] regionsValues = {"Runeterra", "Targon", "Shurima", "Shurima", "Void", "Piltover", "Ionia", "Bandle City", "Shadow Isles", "Noxus"};
        initializeData(regionsValues, Region::new, entityManager::persist);
    }

    @Transactional
    public void initializePosition() {
        String[] positionValues = {"Jungle", "Middle", "Bottom", "Top", "Support"};
        initializeData(positionValues, Position::new, entityManager::persist);
    }

    @Transactional
    public void initializeSpecies() {
        String[] positionValues = {"Undead", "Yordle", "Vastayan", "Darkin", "Dog", "Human", "Spiritualist", "Celestial", "Dragon", "Void-Being", "Spirit", "Magicborn", "Magically Altered", "Chemically Altered", "Aspect"};
        initializeData(positionValues, Species::new, entityManager::persist);
    }

    @Transactional
    public void initializeReleaseSeason() {
        List<String> releaseSeasonValues = generateReleaseSeasonValues(2009, 2030);
        initializeData(releaseSeasonValues.toArray(new String[0]), ReleaseSeason::new, entityManager::persist);
    }

    @Transactional
    public void initializeResource() {
        String[] resourceValues = {"Mana", "Health costs", "Energy", "Manaless", "Flow", "Heat", "Bloodthirst", "Rage", "Fury"};
        initializeData(resourceValues, Resource::new, entityManager::persist);
    }

    @Transactional
    public void initializeRangeType() {
        String[] rangeTypeValues = {"Melee", "Ranged"};
        initializeData(rangeTypeValues, RangeType::new, entityManager::persist);
    }

    private List<String> generateReleaseSeasonValues(int startYear, int endYear) {
        List<String> releaseSeasonValues = new ArrayList<>();
        for (int year = startYear; year <= endYear; year++) {
            releaseSeasonValues.add(String.valueOf(year));
        }
        return releaseSeasonValues;
    }

    public <T> void initializeData(String[] values, Function<String, T> builderFunction, Consumer<T> persistFunction) {
        Arrays.stream(values)
                .map(builderFunction)
                .forEach(entity -> {
                    persistFunction.accept(entity);
                });
        entityManager.flush();
    }

    //Check exist data table Genders
    @Transactional
    public boolean isDataInitialized() {
        Query query = entityManager.createNativeQuery("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'loldb' AND table_rows > 0");
        long count = ((Number) query.getSingleResult()).longValue();
        return count > 0;
    }
}