package com.starlab.msa.gutInfo.controller;


import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import com.starlab.msa.gutInfo.service.MicrobiomeDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = {"사용자의 마이크로바이옴 데이터를 제공하는 Controller API입니다."})
@RestController
@RequestMapping("/ncs-kit")
public class MicrobiomeDataController {

    private MicrobiomeDataService microbiomeDataService;

    @Autowired
    public MicrobiomeDataController(MicrobiomeDataService microbiomeDataService) {
        this.microbiomeDataService = microbiomeDataService;
    }

    @ApiOperation(value = "특정 사용자의 최근 마이크로바이옴 검사 정보를 반환합니다.")
    @GetMapping("/recent-scan/{user-id}")
    public MicrobiomeData getMicrobiomeData(
        @ApiParam(value = "사용자 식별자", type = "Long", example = "1", required = true)
        @PathVariable("user-id") Long id
    ) {
        return microbiomeDataService.getRecentScanData(id);
    }

    @ApiOperation(value = "특정 사용자의 모든 마이크로바이옴 검사 정보를 반환합니다.")
    @GetMapping("/alltest/{user-id}")
    public List<MicrobiomeData> getAllMicrobiomeData(
            @ApiParam(value = "사용자 식별자", type = "Long", example = "1", required = true)
            @PathVariable("user-id") Long id
    ) {
        return microbiomeDataService.getAllMicrobiomeData(id);
    }
}
