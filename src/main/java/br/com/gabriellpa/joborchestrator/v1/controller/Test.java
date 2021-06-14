package br.com.gabriellpa.joborchestrator.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabriellpa.joborchestrator.v1.entity.RawEntity;
import br.com.gabriellpa.joborchestrator.v1.service.ExtractionService;

/**
 * Controller de teste para verificar o resultado da coleta.
 * Validar controller para alguma informação a mais ? 
 */
@RestController
public class Test {

    @Autowired
    private ExtractionService extractionService;

    @GetMapping
    public List<RawEntity> getRaws() {
        return extractionService.getRaws();
    }
    
}
