//package br.com.gabriellpa.joborchestrator.v1.service;
//
//import br.com.gabriellpa.joborchestrator.v1.client.CasesApiClient;
//import org.jobrunr.jobs.annotations.Job;
//import org.jobrunr.scheduling.JobScheduler;
//import org.jobrunr.scheduling.cron.Cron;
//import org.springframework.stereotype.Service;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.UUID;
//
//// TODO: Deixar chamadas para outras apis agnostica (custom headers, payload e outros parametros)
//
//@Service
//@Slf4j
//@Deprecated
//public class ExtractionService {
//
//    private final CasesApiClient client;
//    private final JobScheduler jobScheduler;
//
//    public ExtractionService(CasesApiClient client, JobScheduler jobScheduler ) {
//        this.client = client;
//        this.jobScheduler = jobScheduler;
//    }
//
//    @Job(name = "DEATHS")
//    public void extractDeaceaseData() {
//        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.minutely(), () -> client.getData("DEATHS"));
//    }
//
//    @Job(name = "RECOVERED")
//    public void extractRecoveredData() {
//        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.minutely(), () -> client.getData("RECOVERED"));
//    }
//
//    @Job(name = "CONFIRMED")
//    public void extractConfirmedData() {
//        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.minutely(), () -> client.getData("CONFIRMED"));
//    }
//}
