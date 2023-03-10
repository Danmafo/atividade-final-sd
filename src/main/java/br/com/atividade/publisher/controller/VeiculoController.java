package br.com.atividade.publisher.controller;

import br.com.atividade.model.Veiculo;
import br.com.atividade.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/enviarVeiculo")
    public ResponseEntity<String> enviarVeiculo(@RequestBody Veiculo veiculo) {
        try {
            jmsTemplate.convertAndSend("fila_veiculos_rest", veiculo);
            return new ResponseEntity<>("Sent.", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos() {
        return ResponseEntity.ok(repository.findAll());
    }

}
