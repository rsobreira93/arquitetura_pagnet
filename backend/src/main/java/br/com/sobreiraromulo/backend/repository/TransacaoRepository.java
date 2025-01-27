package br.com.sobreiraromulo.backend.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sobreiraromulo.backend.entity.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

    @Query("SELECT * FROM transacao ORDER BY NOME_LOJA ASC, id DESC")
    List<Transacao> findAllByOrderNomeDaLojaAscIdDesc();
}
