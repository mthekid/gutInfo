package com.starlab.msa.gutInfo.domain.dto;

import com.starlab.msa.gutInfo.domain.BacteriaType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class BacteriaInfoDTO {

    private Long id;
    private String companyType;
    private BacteriaType bacteriaType;
    private BigInteger bacteriaNum;
    private String bacteiaName;

    public BacteriaInfoDTO(Long id, String companyType, BacteriaType bacteriaType, BigInteger bacteriaNum, String bacteiaName) {
        this.id = id;
        this.companyType = companyType;
        this.bacteriaType = bacteriaType;
        this.bacteriaNum = bacteriaNum;
        this.bacteiaName = bacteiaName;
    }

}
