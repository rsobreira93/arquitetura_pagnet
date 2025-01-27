package br.com.sobreiraromulo.backend.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sobreiraromulo.backend.entity.TransacaoReport;
import br.com.sobreiraromulo.backend.service.TransacaoService;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    List<TransacaoReport> listAll() {
        return transacaoService.listTotaisTransacoesPorNomeDaLoja();
    }

}
