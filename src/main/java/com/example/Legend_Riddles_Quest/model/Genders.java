package com.example.Legend_Riddles_Quest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "genders")
public class Genders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gender_name", unique = true)
    private String genderName;

    public Genders(String s) {
        this.genderName = s;
    }
}
