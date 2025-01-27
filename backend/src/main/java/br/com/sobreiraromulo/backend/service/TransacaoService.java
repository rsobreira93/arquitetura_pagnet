package br.com.sobreiraromulo.backend.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sobreiraromulo.backend.entity.TipoTransacao;
import br.com.sobreiraromulo.backend.entity.TransacaoReport;
import br.com.sobreiraromulo.backend.repository.TransacaoRepository;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public List<TransacaoReport> listTotaisTransacoesPorNomeDaLoja() {
        var transacoes = transacaoRepository.findAllByOrderNomeDaLojaAscIdDesc();

        var reportMap = new LinkedHashMap<String, TransacaoReport>();

        transacoes.forEach(trasacao -> {
            String nomeDaLoja = trasacao.nomeDaLoja();
            var valor = trasacao.valor();

            reportMap.compute(nomeDaLoja, (key, existingReport) -> {
                var report = (existingReport != null) ? existingReport
                        : new TransacaoReport(key, BigDecimal.ZERO, new ArrayList<>());

                return report.addTotal(valor).addTransacao(trasacao);

            });
        });

        return new ArrayList<>(reportMap.values());
    }
}
