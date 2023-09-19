package com.example.springdata.demo.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.Random;

public class MyAuditorAware implements AuditorAware<Integer> {

    /**
     * 需要实现 AuditorAware 接⼝，返回当前的⽤户 ID
     */
    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.of(new Random().nextInt());
    }
}
