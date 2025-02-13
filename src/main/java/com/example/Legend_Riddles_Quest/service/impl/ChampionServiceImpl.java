package com.example.Legend_Riddles_Quest.service.impl;

import com.example.Legend_Riddles_Quest.model.Champions;
import com.example.Legend_Riddles_Quest.payload.Champions.ChampionGetByIdResponse;
import com.example.Legend_Riddles_Quest.payload.Champions.ChampionNameResponse;
import com.example.Legend_Riddles_Quest.payload.DataResponse;
import com.example.Legend_Riddles_Quest.repository.ChampionsRepository;
import com.example.Legend_Riddles_Quest.service.ChampionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChampionServiceImpl implements ChampionsService {

    @Autowired
    private ChampionsRepository championsRepository;
    @Override
    public ResponseEntity<Object> getAll() {
        List<Champions> championsList = championsRepository.findAll();
        if(championsList.size() > 0){
            return ResponseEntity.ok().body(DataResponse.builder().data(championsList).result("Get data success").build());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> getAllNameChampion() {
        List<Champions> championsList = championsRepository.findAll();
        if(championsList.size() > 0){
            List<ChampionNameResponse> nameChampionList = championsList.stream()
                    .map(champion -> new ChampionNameResponse(champion.getId().toString(),champion.getName()))
                    .collect(Collectors.toList());
            return ResponseEntity.ok()
                    .body(DataResponse.builder()
                            .data(nameChampionList)
                            .result("Get data success")
                            .build());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> getChampionById(Long id) throws IOException {
        Optional<Champions> championsOpt = championsRepository.findById(id);
        System.out.println(championsOpt);
        if(championsOpt.isPresent()){
            String URL = getUrlImgChampions(championsOpt.get().getName());
            return ResponseEntity.ok().body(ChampionGetByIdResponse.builder().data(championsOpt).URL(URL).build());
        }
        return ResponseEntity.notFound().build();
    }

    private String getUrlImgChampions(String name){
        String URL = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/";
        return URL.concat(name + ".jpg");
    }
}
