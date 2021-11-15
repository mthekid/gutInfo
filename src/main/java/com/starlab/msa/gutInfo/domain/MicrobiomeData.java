package com.starlab.msa.gutInfo.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "microbiome")
@ApiModel(value = "마이크로바이옴 검사 정보", description = "사용자 식별번호, 검사 날짜, 마이크로바이옴 데이터 정보")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class MicrobiomeData {

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

    @Column(nullable = false)
    @ApiModelProperty(value = "", required = true)
    @JsonManagedReference
    @OneToMany(mappedBy = "microbiomeData", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<BacteriaInfo> bacteriaInfos = new HashSet<>();

    public MicrobiomeData() {}
}
