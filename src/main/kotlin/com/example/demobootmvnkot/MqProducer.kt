package com.example.demobootmvnkot

import org.springframework.beans.factory.annotation.Value
import org.springframework.jms.core.JmsTemplate
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@EnableScheduling
class MqProducer(
        val jmsTemplate: JmsTemplate,
        @Value("\${queue.input}")
        val queueInput: String )
{
    @Scheduled(fixedDelayString = "1000")
    fun sendBytes() {
        jmsTemplate.convertAndSend(
                queueInput,
                "BytesMessage".toByteArray(Charsets.UTF_8)
        )
    }
}