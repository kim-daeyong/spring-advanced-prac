package com.example.spring.advanced.app.v1;

import com.example.spring.advanced.trace.TraceStatus;
import com.example.spring.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV2 trace;

    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");
            trace.end(status);
            if (itemId.equals("ex")) {
                throw new IllegalArgumentException("exception");
            }
            sleep(1000);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int miliis) {
        try {
            Thread.sleep(miliis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
