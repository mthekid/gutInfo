package com.starlab.msa.gutInfo.domain.dto;

import com.starlab.msa.gutInfo.domain.BacteriaInfo;
import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import lombok.*;

import java.util.*;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class MicrobiomeDataDTO {
    private Date createDate;
    private String companyName;
    private Set<BacteriaInfo> bacteriaInfos = new HashSet<>();


}
