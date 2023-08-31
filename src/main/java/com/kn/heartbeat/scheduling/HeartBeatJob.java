package com.kn.heartbeat.scheduling;

import com.kn.heartbeat.integration.SoapClient;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log4j2
public class HeartBeatJob implements Job {

    private SoapClient soapClient;

//    @Scheduled(cron = "0/5 * * * * ?")
    public void execute() {
        log.info("Executing heartbeat job.....");
        String status = soapClient.soapHealthCheck();
        if (!status.equals("UP")) {
            log.warn("server down!!!!!");
        } else {
            log.info("server is online with status UP");
        }
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("Executing heartbeat job.....");
        String status = soapClient.soapHealthCheck();
        if (!status.equals("UP")) {
            log.warn("server down!!!!!");
        } else {
            log.info("server is online with status UP");
        }
    }
}
