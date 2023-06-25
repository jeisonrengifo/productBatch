package com.renfo.product.productPriceIncrement.job.productpriceincrement.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductListener implements JobExecutionListener {
    public void afterJob(JobExecution jobExecution) {
        log.info("Called after Job");
    }
}
