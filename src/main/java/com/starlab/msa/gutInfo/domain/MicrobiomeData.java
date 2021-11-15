package com.starlab.msa.gutInfo.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "microbiome")
@ApiModel(value = "마이크로바이옴 검사 정보", description = "사용자 식별번호, 검사 날짜, 마이크로바이옴 데이터 정보")
public class MicrobiomeData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "마이크로바이옴 데이터 식별번호", example = "1", required = true)
    private Long id;

    // 사용자 마이크로서비스에서 받아와야 한다.
    @Column(name = "userId", nullable = false)
    @ApiModelProperty(value = "사용자의 식별번호", example = "1", required = true)
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = "마이크로바이옴 검사 날짜", required = true)
    private Date createDate;

    // 해당 자료들은 microBiome 데이터들로 처리되어야 한다.
    @Column(nullable = false)
    @ApiModelProperty(value = "", required = true)
    @OneToMany(mappedBy = "microbiomeData", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BacteriaInfo> bacteriaInfos;

    public MicrobiomeData() {}
}
