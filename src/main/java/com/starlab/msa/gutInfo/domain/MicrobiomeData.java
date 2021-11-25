package com.starlab.msa.gutInfo.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "microbiome")
@ApiModel(value = "마이크로바이옴 검사 정보", description = "사용자 식별번호, 검사 날짜, 마이크로바이옴 데이터 정보")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class MicrobiomeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MICROBIOMDATA_ID")
    @ApiModelProperty(value = "마이크로바이옴 데이터 식별번호", example = "1", required = true)
    private Long id;

    // 사용자 마이크로서비스에서 받아와야 한다.
    @Column(name = "USERID", nullable = false)
    @ApiModelProperty(value = "사용자의 식별번호", example = "1", required = true)
    private Long userId;

    @Column(name = "CREATE_DATE", nullable = false)
    @ApiModelProperty(value = "마이크로바이옴 검사 날짜", required = true)
    private LocalDate createDate;

    @Column(name = "COMPANYCODE", nullable = false)
    @ApiModelProperty(value = "NCS 검사 회사", example = "CB", required = true)
    private String companyCode;

    @Column(name = "COMPANYNAME", nullable = false)
    @ApiModelProperty(value = "NCS 검사 회사", example = "CellBiotech", required = true)
    private String companyName;

    @Column(nullable = false)
    @JsonManagedReference
    @OneToMany(mappedBy = "microbiomeData", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<BacteriaInfo> bacteriaInfos;

    public MicrobiomeData() {}

}
