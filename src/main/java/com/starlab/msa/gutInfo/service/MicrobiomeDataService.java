package com.starlab.msa.gutInfo.service;

import com.starlab.msa.gutInfo.domain.BacteriaInfo;
import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import com.starlab.msa.gutInfo.domain.dto.MicrobiomeDataDTO;

import java.util.List;

public interface MicrobiomeDataService {

    /**
     * 사용자의 최근 MicroBiomeData 정보를 반환합니다.
     * @param userId 검사자의 식별번호
     * @return {@link MicrobiomeData}
     */
    MicrobiomeData getRecentMicrobiomeData(Long userId);

    /**
     * 사용자의 모든 MicroBiomeData 정보들을 반환합니다.
     * @param userId
     * @return {@link MicrobiomeData}
     */
    List<MicrobiomeData> getAllMicrobiomeData(Long userId);
}
