package com.starlab.msa.gutInfo.service.impl;

import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import com.starlab.msa.gutInfo.repo.MicrobiomeDataRepository;
import com.starlab.msa.gutInfo.service.MicrobiomeDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 사용자의 마이크로바이옴 데이터를 가져옵니다.
 */

@Slf4j
@Service
public class MicrobiomeDataServiceImpl implements MicrobiomeDataService {

    private final MicrobiomeDataRepository microbiomeDataRepository;

    @Autowired
    public MicrobiomeDataServiceImpl(MicrobiomeDataRepository microbiomeDataRepository) {
        this.microbiomeDataRepository = microbiomeDataRepository;
    }


    /**
     *
     * @param userId 검사자의 식별번호
     * @return 사용자의 최근 마이크로 검사 데이터를 반환한다. 불필요한 정보를 제거한 DTO로 반환한다.
     */
    @Override
    public MicrobiomeData getRecentMicrobiomeData(Long userId) {
        log.info("사용자의 최신 마이크로바이옴 데이터를 가져옵니다.");
        List<MicrobiomeData> microbiomeDataList = microbiomeDataRepository.findAllByUserId(userId);

        microbiomeDataList.sort( (m1, m2) -> {
            return m2.getCreateDate().compareTo(m1.getCreateDate());
        });

        return microbiomeDataList.get(0);
    }

    @Override
    public List<MicrobiomeData> getAllMicrobiomeData(Long userId) {
        log.info("사용자의 모든 마이크로바이옴 데이터를 가져옵니다.");
        return microbiomeDataRepository.findAllByUserId(userId);
    }
}
