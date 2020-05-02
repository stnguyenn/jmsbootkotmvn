package com.example.demobootmvnkot

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import javax.jms.Message

@Component
class MqListener {

    @JmsListener(destination = "\${queue.input}")
    fun receiveMessage(message: Message) {
        val body = message.getBody(ByteArray::class.java)
        println("receiveMessage: ${body.toString(Charsets.UTF_8)}")
    }

}
