package com.rabbitmq.demo.application.in.simple.impl;

import com.rabbitmq.demo.application.in.simple.api.SimpleUseCaseApi;
import com.rabbitmq.demo.application.out.MessageSender;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SimpleUseCaseImpl implements SimpleUseCaseApi {

    private final MessageSender messageSender;

    @Override
    public void send(String message) {
        try {
            messageSender.sendSimpleTask(message);
        } catch (Exception e) {
            log.error("{} error: {}", MessageSender.class.getSimpleName(), e.getMessage());
        }
    }

}
