package com.starlab.msa.gutInfo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.starlab.msa.gutInfo.domain.converter.BacteriaConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigInteger;


/**
 * 박테리아에 대한 정보를 보관합니다.
 * 식별번호, 박테리아 타입, 박테리아 양, 박테리아 학명, 박테리아 학명코드을 가집니다.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "bacteria_info")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@ApiModel(value = "각 장내 세균에 대한 정보", description = "해당 Entity의 식별번호, 회사 고유 코드, 박테리아 타입, 박테리아 이름, 외래키")
public class BacteriaInfo {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @ApiModelProperty(value = "박테리아 데이터 식별번호", example = "1", required = true)
    private Long id;

    @Column(name = "TYPE", nullable = false)
    @ApiModelProperty(value = "박테리아 타입", example = "INTER", required = true)
    @Convert(converter = BacteriaConverter.class)
    private BacteriaType type;

    @Column(name = "AMOUNT", nullable = false)
    @ApiModelProperty(value = "박테리아 균 수(천만단위)", example = "18846518", required = true)
    private int amounts;

    @Column(name = "NAME", nullable = false)
    @ApiModelProperty(value = "박테리아 학명", example = "Lacto-BASILAS", required = true)
    private String name;

    @Column(name = "CODE", nullable = false)
    @ApiModelProperty(value = "박테리아학명 코드", example = "LC1", required = true)
    private String code;

    public BacteriaInfo() {}

    public BacteriaInfo(Long id, BacteriaType type, int amounts, String name, String code) {
        this.id = id;
        this.type = type;
        this.amounts = amounts;
        this.name = name;
        this.code = code;
    }

    @ManyToOne(targetEntity = MicrobiomeData.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "microbiome_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private MicrobiomeData microbiomeData;
}
