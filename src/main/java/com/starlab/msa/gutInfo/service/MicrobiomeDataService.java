package com.starlab.msa.gutInfo.service;

import com.starlab.msa.gutInfo.domain.BacteriaInfo;
import com.starlab.msa.gutInfo.domain.MicrobiomeData;

import java.util.List;

public interface MicrobiomeDataService {

    MicrobiomeData getRecentMicrobiomeData(Long userId);
    List<MicrobiomeData> getAllMicrobiomeData(Long userId);
}
