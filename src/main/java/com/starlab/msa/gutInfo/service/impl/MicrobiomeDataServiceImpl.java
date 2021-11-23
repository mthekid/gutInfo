package com.starlab.msa.gutInfo.service.impl;

import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import com.starlab.msa.gutInfo.domain.dto.MicrobiomeDataDTO;
import com.starlab.msa.gutInfo.repo.MicrobiomeDataRepository;
import com.starlab.msa.gutInfo.service.MicrobiomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 사용자의 마이크로바이옴 데이터를 가져옵니다.
 */

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
        return microbiomeDataRepository.findAllByUserId(userId);
    }
}
