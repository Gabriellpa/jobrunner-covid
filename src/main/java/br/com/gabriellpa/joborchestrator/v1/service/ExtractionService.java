package br.com.gabriellpa.joborchestrator.v1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabriellpa.joborchestrator.v1.client.CoronaVirusGitHubCSSEGIClient;
import br.com.gabriellpa.joborchestrator.v1.converter.CsvConverter;
import br.com.gabriellpa.joborchestrator.v1.converter.RawConverter;
import br.com.gabriellpa.joborchestrator.v1.entity.RawEntity;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExtractionService {

    @Autowired
    private CoronaVirusGitHubCSSEGIClient client;
    @Autowired
    private CsvConverter csvConverter;
    @Autowired
    private RawConverter rawConverter;

    // TODO: Adicionar como backgroundjob com o JonbRunr
    public List<RawEntity> getRaws() {
        try {
            return rawConverter.toRawEntity(csvConverter.stringToObject(client.getConfirmed()));
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }

    }
    
}
