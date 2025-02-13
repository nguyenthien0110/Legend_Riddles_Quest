package com.example.Legend_Riddles_Quest.repository;

import com.example.Legend_Riddles_Quest.model.Champions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionsRepository extends JpaRepository<Champions, Long> {

}
