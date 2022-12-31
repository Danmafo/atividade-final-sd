package br.com.atividade.consumer.component;

import br.com.atividade.model.Veiculo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumidor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumidor.class);

    @JmsListener(destination = "fila_veiculos_rest")
    public void messageListener(Veiculo systemMessage) {
        LOGGER.info("Message received! {}", systemMessage);
    }
}
