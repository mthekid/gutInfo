package com.starlab.msa.gutInfo.controller;


import com.starlab.msa.gutInfo.domain.BacteriaInfo;
import com.starlab.msa.gutInfo.domain.MicrobiomeData;
import com.starlab.msa.gutInfo.domain.dto.MicrobiomeDataDTO;
import com.starlab.msa.gutInfo.service.MicrobiomeDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "특정 사용자의 최근 마이크로바이옴 검사 식별 정보를 반환합니다.")
    @GetMapping("/microbiome-data/{user-id}")
    public MicrobiomeData getRecentMicrobiomeData(
            @ApiParam(value = "사용자 식별자", type = "Long", example = "1", required = true)
            @PathVariable("user-id") Long id)
    {
        return microbiomeDataService.getRecentMicrobiomeData(id);
    }

    @ApiOperation(value = "특정 사용자의 모든 마이크로바이옴 검사 식별 정보를 반환합니다.")
    @GetMapping("/microbiome-datas/{user-id}")
    public List<MicrobiomeData> getAllMicrobiomeData(
            @ApiParam(value = "사용자 식별자", type = "Long", example = "1", required = true)
            @PathVariable("user-id") Long id)
    {
        return microbiomeDataService.getAllMicrobiomeData(id);
    }

    @ApiOperation(value = "특정 사용자의 마이크로바이옴 검사 정보를 입력받습니다.")
    @PostMapping("/insert")
    public void insertMicrobiome(@RequestBody MicrobiomeDataDTO microbiomeData) {
        System.out.println(microbiomeData);
    }
}
