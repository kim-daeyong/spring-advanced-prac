package com.example.spring.advanced.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    public void excute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        //비즈니스로직 실행
        log.info("비즈니스 로직 실행");
        strategy.call();
        //비즈니스로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}