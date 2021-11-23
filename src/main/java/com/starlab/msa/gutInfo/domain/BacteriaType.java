package com.starlab.msa.gutInfo.domain;

import lombok.Getter;

import java.util.Arrays;

/**
 * 박테리아의 타입을 정의합니다.
 * 유해균(HARMFUL)
 * 유익균(HEALTH)
 * 중간균(INTER)
 * 로 나뉩니다.
 */
@Getter
public enum BacteriaType {
    HEALTH("HEALTH"),
    INTER("INTER"),
    HARMFUL("HARMFUL"),
    UNKNOWN("UNKNOWN");

    private String type;
    BacteriaType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
