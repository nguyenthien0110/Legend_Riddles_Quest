package com.example.Legend_Riddles_Quest.controller;

import com.example.Legend_Riddles_Quest.service.ChampionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/champions")
public class ChampionsController {
    @Autowired
    private ChampionsService championsService;

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAll() {
        return championsService.getAll();
    }

    @GetMapping("/get-all-name-champions")
    public ResponseEntity<Object> getAllNameChampion() {
        return championsService.getAllNameChampion();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Object> getChampionById(@PathVariable Long id) throws IOException {
        return championsService.getChampionById(id);
    }
}
