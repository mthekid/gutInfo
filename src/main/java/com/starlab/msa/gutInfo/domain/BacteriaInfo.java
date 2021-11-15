package com.starlab.msa.gutInfo.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "bacteria_info")
@ApiModel(value = "각 장내 세균에 대한 정보", description = "해당 Entity의 식별번호, 회사 고유 코드, 박테리아 타입, 박테리아 이름, 외래키")
public class BacteriaInfo implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    @ApiModelProperty(value = "박테리아 데이터 식별번호", example = "1", required = true)
    private Long id;

    @Column(name = "companyType", nullable = false)
    @ApiModelProperty(value = "NCS 검사 회사", example = "CODE1", required = true)
    private String companyType;

    @Column(name = "type", nullable = false)
    @ApiModelProperty(value = "박테리아 타입", example = "BAD", required = true)
    private BacteriaType bacteriaType;

    @Column(name = "bacteriaNum", nullable = false)
    @ApiModelProperty(value = "박테리아 균 수", example = "18846518", required = true)
    private BigInteger bacteriaNum;

    @Column(name = "bacteriaName", nullable = false)
    @ApiModelProperty(value = "박테리아 학명", example = "Lacto", required = true)
    private String bacteiaName;

    public BacteriaInfo() {}

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "microbiome_id", nullable = false)
    private MicrobiomeData microbiomeData;
}
