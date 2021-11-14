package com.starlab.msa.gutInfo.repo;

import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MicrobiomeDataRepository extends JpaRepository<MicrobiomeData, Long> {
    List<MicrobiomeData> findAllByUserId(Long userId);
}
