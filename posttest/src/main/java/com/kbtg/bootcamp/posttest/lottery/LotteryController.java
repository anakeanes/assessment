package com.kbtg.bootcamp.posttest.lottery;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lottery")
public class LotteryController {
    private LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public List<Lottery> getLotteryList() {
        return lotteryService.getLotteryList();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LotteryResponseDto> createLottery(
            @Validated
            @RequestBody LotteryRequestDto requestDto) throws Exception {
        LotteryResponseDto createdLottery = lotteryService.createLottery(requestDto);
        return ResponseEntity.status(201).body(createdLottery);
    }
}