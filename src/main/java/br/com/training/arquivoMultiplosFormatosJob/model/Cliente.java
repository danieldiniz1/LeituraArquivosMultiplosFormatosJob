package br.com.training.arquivoMultiplosFormatosJob.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {

    private String nome, sobrenome, idade, email;
    private List<Transacao> transacoes = new ArrayList<>();
}
