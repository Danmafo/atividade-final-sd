package br.com.atividade.consumer.component;

import br.com.atividade.model.Veiculo;
import br.com.atividade.repository.VeiculoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumidor {

    @Autowired
    VeiculoRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumidor.class);

    @JmsListener(destination = "fila_veiculos_rest")
    public void messageListener(Veiculo veiculo) {
        repository.save(veiculo);
        LOGGER.info("Message received! {}", veiculo);
    }
}
