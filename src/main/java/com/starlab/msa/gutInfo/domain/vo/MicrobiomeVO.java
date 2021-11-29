package com.starlab.msa.gutInfo.domain.vo;

import com.starlab.msa.gutInfo.domain.BacteriaInfo;

import java.time.LocalDate;
import java.util.List;

public class MicrobiomeVO {
    private LocalDate localDate;
    private Long userId;
    private String companyName;

    private List<BacteriaInfo> bacteriaInfos;
}
