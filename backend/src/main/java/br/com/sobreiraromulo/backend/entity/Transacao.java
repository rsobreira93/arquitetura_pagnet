package br.com.sobreiraromulo.backend.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public record Transacao(
        @Id Long id,
        Integer tipo,
        Date data,
        BigDecimal valor,
        Long cpf,
        String cartao,
        Time hora,
        @Column("DONO_LOJA") String donoDaLoja,
        @Column("NOME_LOJA") String nomeDaLoja) {

    public Transacao withValor(BigDecimal valor) {
        return new Transacao(
                id, tipo, data,
                valor,
                cpf, cartao, hora,
                donoDaLoja, nomeDaLoja);
    }

    public Transacao withData(String data) throws ParseException {
        var dataFormat = new SimpleDateFormat("yyyyMMdd");
        var date = dataFormat.parse(data);

        return new Transacao(
                id, tipo, new Date(date.getTime()),
                valor, cpf,
                cartao, hora,
                donoDaLoja, nomeDaLoja);
    }

    public Transacao withHora(String hora) throws ParseException {
        var dataFormat = new SimpleDateFormat("HHmmss");
        var date = dataFormat.parse(hora);

        return new Transacao(
                id, tipo, data,
                valor, cpf,
                cartao, new Time(date.getTime()),
                donoDaLoja, nomeDaLoja);
    }
}