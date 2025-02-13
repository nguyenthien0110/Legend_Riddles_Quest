package com.example.Legend_Riddles_Quest.payload.Champions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionGetByIdResponse<T> {
    private String URL;
    private T data;
}
