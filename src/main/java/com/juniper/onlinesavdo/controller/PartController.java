package com.juniper.onlinesavdo.controller;

import com.juniper.onlinesavdo.payload.request.PartsReqDto;
import com.juniper.onlinesavdo.payload.responce.PartResDto;
import com.juniper.onlinesavdo.service.PartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PartController {

    @Autowired
    private PartService partService;

    @ApiOperation("Bo'limlarni saqlash uchun")
    @PostMapping("admin/parts/save")
    public ResponseEntity savingPart(@RequestBody PartsReqDto partsReqDto)
    {
        return ResponseEntity.ok(partService.savePart(partsReqDto));
    }

    @GetMapping("/user/parts/getAllParts")
    public ResponseEntity gettingAll()
    {
        return ResponseEntity.ok(partService.getAllParts());
    }

    @PutMapping("/admin/parts/updatePart")
    public ResponseEntity updatingParts(@RequestBody PartResDto partResDto)
    {
        return ResponseEntity.ok(partService.updatePart(partResDto));
    }
}
