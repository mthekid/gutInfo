package com.starlab.msa.gutInfo.dto;

import com.starlab.msa.gutInfo.domain.BacteriaInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
public class MicrobiomeDataDTO {

    private Long id;
    private Long userId;
    private Date createDate;
    private List<List<BacteriaInfo>> bacteriaInfos = new ArrayList<>();
}
