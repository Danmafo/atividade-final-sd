package br.com.atividade.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "veiculos")
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;

    private String marcaModeloVeiculo;

    private Integer anoModelo;

    private Double valorVenda;

    @CreationTimestamp
    private Date dataPublicacao;

    public Veiculo() {}

    public Veiculo(String nomeCliente, String marcaModeloVeiculo, Integer anoModelo, Double valorVenda) {
        this.nomeCliente = nomeCliente;
        this.marcaModeloVeiculo = marcaModeloVeiculo;
        this.anoModelo = anoModelo;
        this.valorVenda = valorVenda;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMarcaModeloVeiculo() {
        return marcaModeloVeiculo;
    }

    public void setMarcaModeloVeiculo(String marcaModeloVeiculo) {
        this.marcaModeloVeiculo = marcaModeloVeiculo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Veiculo {\n" +
                "Nome do Cliente = " + nomeCliente + '\n' +
                "Marca e Modelo = " + marcaModeloVeiculo + '\n' +
                "Ano = " + anoModelo + '\n' +
                "Valor de Venda = " + valorVenda + '\n' +
                "Data da Publição = " + dataPublicacao + '\n' +
                '}';
    }
}
