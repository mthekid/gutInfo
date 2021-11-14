package com.starlab.msa.gutInfo.domain;


import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "bacteria_info")
public class BactriaInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "companyType", nullable = false)
    private String companyType;

    @Column(name = "type", nullable = false)
    private BacteriaType bacteriaType;

    private BigInteger bacteriaNum;

    public BactriaInfo() {}

    @ManyToOne
    private MicrobiomeData microbiomeDataOwner;
}
