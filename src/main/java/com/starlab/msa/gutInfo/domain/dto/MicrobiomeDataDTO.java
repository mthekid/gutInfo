package com.starlab.msa.gutInfo.domain.dto;

import com.starlab.msa.gutInfo.domain.BacteriaInfo;
import lombok.*;

import java.util.*;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class MicrobiomeDataDTO {
    private Date createDate;
    private String companyName;
    private Long userId;
}
