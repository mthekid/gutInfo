package com.starlab.msa.gutInfo.service;

import com.starlab.msa.gutInfo.domain.MicrobiomeData;

import java.util.List;

public interface MicrobiomeDataService {

    MicrobiomeData getRecentScanData(Long userId);
    List<MicrobiomeData> getAllMicrobiomeData(Long userId);
}
