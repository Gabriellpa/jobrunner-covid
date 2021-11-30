//package br.com.gabriellpa.joborchestrator.v1.controller;
//
//import br.com.gabriellpa.joborchestrator.v1.grpc.service.ExtractionServiceGrpc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.gabriellpa.joborchestrator.v1.service.ExtractionService;
//
//@RestController
//@RequestMapping("/job")
//@Deprecated(since = "GRPC implementation")
//public class JobController {
//
//    @Autowired
//    private ExtractionService extractionService;
//
//    @Autowired
//    private ExtractionServiceGrpc extractionServiceGrpc;
//
//
//    @GetMapping("/cases/confirmed")
//    public ResponseEntity<Void> extractConfirmedData() {
//        extractionService.extractConfirmedData();
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/cases/deacease")
//    public ResponseEntity<Void> extractDeaceaseData() {
//        extractionService.extractDeaceaseData();
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/cases/recovered")
//    public ResponseEntity<Void> extractRecoveredData() {
//        extractionService.extractRecoveredData();
//        return ResponseEntity.noContent().build();
//    }
//
//}
