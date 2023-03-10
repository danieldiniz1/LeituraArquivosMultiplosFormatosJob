package br.com.training.arquivoMultiplosFormatosJob.model;

import lombok.Data;

@Data
public class Transacao {

    private String id, descricao;
    private Double valor;
}
