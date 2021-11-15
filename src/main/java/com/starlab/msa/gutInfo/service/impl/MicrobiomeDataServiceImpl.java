package com.starlab.msa.gutInfo.service.impl;

import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import com.starlab.msa.gutInfo.repo.MicrobiomeDataRepository;
import com.starlab.msa.gutInfo.service.MicrobiomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicrobiomeDataServiceImpl implements MicrobiomeDataService {

    private final MicrobiomeDataRepository microbiomeDataRepository;
//    private final BacteriaInfoRepository bacteriaInfoRepository;

//    @Autowired
//    public MicrobiomeDataServiceImpl(MicrobiomeDataRepository microbiomeDataRepository, BacteriaInfoRepository bacteriaInfoRepository) {
//        this.microbiomeDataRepository = microbiomeDataRepository;
//        this.bacteriaInfoRepository = bacteriaInfoRepository;
//    }
    @Autowired
    public MicrobiomeDataServiceImpl(MicrobiomeDataRepository microbiomeDataRepository) {
        this.microbiomeDataRepository = microbiomeDataRepository;
    }
//
//    @Override
//    public List<BacteriaInfo> getRecentScanData(Long userId) {
//        List<MicrobiomeData> microbiomeDataList = microbiomeDataRepository.findAllByUserId(userId);
//
//        microbiomeDataList.sort( (m1, m2) -> {
//            return m2.getCreateDate().compareTo(m1.getCreateDate());
//        });
//
//        Long mid = microbiomeDataList.get(0).getId();
//        System.out.println("mid " + mid);
//
//        List<BacteriaInfo> bacteriaInfos = bacteriaInfoRepository.findAllBymicrobiomeDataOwnerId(mid);
//        return bacteriaInfos;
//    }
//
//    @Override
//    public List<List<BacteriaInfo>> getAllBacteriaInfoData(Long userId) {
//        List<MicrobiomeData> microbiomeDataList = microbiomeDataRepository.findAllByUserId(userId);
//
//        List<Long> mids = new ArrayList<>();
//
//        for(MicrobiomeData microbiomData : microbiomeDataList) {
//            mids.add(microbiomData.getId());
//            System.out.println("all " + microbiomData.getId());
//        }
//
//        List<List<BacteriaInfo>> allBacteriaInfos = new ArrayList<>();
//
//        for(int i = 0; i < mids.size(); i++) {
//            List<BacteriaInfo> bacteriaInfos = bacteriaInfoRepository.findAllBymicrobiomeDataOwnerId(mids.get(i));
//            System.out.println(bacteriaInfos);
//            allBacteriaInfos.add(bacteriaInfos);
//        }
//        return allBacteriaInfos;
//    }

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

        return microbiomeDataList;
    }
}
