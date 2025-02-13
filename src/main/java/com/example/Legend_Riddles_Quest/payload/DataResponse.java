package com.example.Legend_Riddles_Quest.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataResponse<T> {
    private String result;
    private T data;
}