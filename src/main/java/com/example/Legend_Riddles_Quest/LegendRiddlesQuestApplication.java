package com.example.Legend_Riddles_Quest;

import com.example.Legend_Riddles_Quest.util.DataInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LegendRiddlesQuestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegendRiddlesQuestApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataInitializerRunner(DataInitializer dataInitializer) {
        return args -> {
            if (!dataInitializer.isDataInitialized()) {
                dataInitializer.initializeGenders();
                dataInitializer.initializeRegions();
                dataInitializer.initializeSpecies();
                dataInitializer.initializePosition();
                dataInitializer.initializeResource();
                dataInitializer.initializeRangeType();
                dataInitializer.initializeReleaseSeason();
            }
        };
    }
}
