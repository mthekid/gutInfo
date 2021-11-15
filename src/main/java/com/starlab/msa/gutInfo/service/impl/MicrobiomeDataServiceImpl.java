package com.starlab.msa.gutInfo.service.impl;

import com.starlab.msa.gutInfo.domain.BacteriaInfo;
import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import com.starlab.msa.gutInfo.dto.MicrobiomeDataDTO;
//import com.starlab.msa.gutInfo.repo.BacteriaInfoRepository;
import com.starlab.msa.gutInfo.repo.MicrobiomeDataRepository;
//import com.starlab.msa.gutInfo.service.BacteriaInfoService;
import com.starlab.msa.gutInfo.service.MicrobiomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.List;
import java.util.Set;

@Service
public class MicrobiomeDataServiceImpl implements MicrobiomeDataService {

    private final MicrobiomeDataRepository microbiomeDataRepository;

    @Autowired
    public MicrobiomeDataServiceImpl(MicrobiomeDataRepository microbiomeDataRepository) {
        this.microbiomeDataRepository = microbiomeDataRepository;
    }

    @Override
    public MicrobiomeData getRecentMicrobiomeData(Long userId) {
        List<MicrobiomeData> microbiomeDataList = microbiomeDataRepository.findAllByUserId(userId);

        microbiomeDataList.sort( (m1, m2) -> {
            return m2.getCreateDate().compareTo(m1.getCreateDate());
        });

        return microbiomeDataList.get(0);
    }

    @Override
    public List<MicrobiomeData> getAllMicrobiomeData(Long userId) {
        List<MicrobiomeData> microbiomeDataList = microbiomeDataRepository.findAllByUserId(userId);

//        for(MicrobiomeData m : microbiomeDataList) {
//            System.out.println(m.getBacteriaInfos());
//        }

        return microbiomeDataList;
    }
}
