package com.bridgingcode.springbootactivemqdemo.publisher.controller;

import com.bridgingcode.springbootactivemqdemo.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VeiculoController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/enviarVeiculo")
    public ResponseEntity<String> enviarVeiculo(@RequestBody Veiculo systemMessage) {
        try {
            jmsTemplate.convertAndSend("fila_veiculos_rest", systemMessage);

            return new ResponseEntity<>("Sent.", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
