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
@Table(name = "Champions")
public class Champions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Genders genders;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne
    @JoinColumn(name = "races_id")
    private RangeType rangeType;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "release_season_id")
    private ReleaseSeason releaseSeason;
}
