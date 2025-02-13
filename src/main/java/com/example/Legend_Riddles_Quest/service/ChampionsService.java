package com.example.Legend_Riddles_Quest.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ChampionsService {

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> getAllNameChampion();

    ResponseEntity<Object> getChampionById(Long id) throws IOException;
}
