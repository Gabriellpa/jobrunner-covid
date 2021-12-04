package br.com.gabriellpa.joborchestrator.v1.grpc.service;

import gr.CasesEnum;
import gr.CasesServiceGrpc;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.scheduling.cron.Cron;
import org.jobrunr.spring.annotations.Recurring;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class ExtractionServiceGrpc {

    @GrpcClient("local-grpc-server")
    private CasesServiceGrpc.CasesServiceFutureStub casesServiceBlockingStub;

    @Job(name = "Deacease cases job")
    @Recurring(id = "deacease-recurring-job", cron = "* * * * *")
    public void extractDeaceaseData() throws InterruptedException {
        this.extract("DEATHS");
//        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.minutely(), () -> extract("DEATHS"));
    }

    @Job(name = "Recovered cases job")
    @Recurring(id = "recovered-recurring-job", cron = "* * * * *")
    public void extractRecoveredData() throws InterruptedException {
        this.extract("RECOVERED");
//        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.minutely(), () -> extract("RECOVERED"));
    }

    @Job(name = "Confirmed cases job")
    @Recurring(id = "confirmed-recurring-job", cron = "* * * * *")
    public void extractConfirmedData() throws InterruptedException {
        this.extract("CONFIRMED");
//        jobScheduler.scheduleRecurrently(UUID.randomUUID().toString(), Cron.minutely(), () -> extract("CONFIRMED"));
    }

    public void extract(String name) {
        log.info("Runnninng job {}", name);
        var type = CasesEnum.valueOf(name);
        var request = gr.request.newBuilder().setCasesType(type).build();
        // TODO: avaliar retornar status para algum tipo de controle?
        casesServiceBlockingStub.collectCasesData(request);

    }
}