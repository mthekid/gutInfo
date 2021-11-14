package com.starlab.msa.gutInfo.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum BacteriaType {
    HEALTH("HEALTH"),
    INTER("INTER"),
    HARMFUL("HARMFUL"),
    UNKNOWN("unknown");

    private String type;
    BacteriaType(String type) {this.type = type;}

    public static BacteriaType getByType(String type) {
        return Arrays.stream(BacteriaType.values())
                .filter(bacteriaType -> bacteriaType.getType().equals(type))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
