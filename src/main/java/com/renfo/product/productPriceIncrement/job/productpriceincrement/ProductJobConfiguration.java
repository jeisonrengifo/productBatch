package com.renfo.product.productPriceIncrement.job.productpriceincrement;

import com.renfo.product.productPriceIncrement.job.productpriceincrement.listener.ProductListener;
import com.renfo.product.productPriceIncrement.job.productpriceincrement.procesor.ProductProcessor;
import com.renfo.product.productPriceIncrement.job.productpriceincrement.reader.ProductReader;
import com.renfo.product.productPriceIncrement.job.productpriceincrement.writer.ProductWriter;
import com.renfo.product.productPriceIncrement.product.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Slf4j
public class ProductJobConfiguration {

    @Autowired
    protected JobRepository jobRepository;

    @Autowired
    private ProductReader productReader;

    @Autowired
    private ProductProcessor productProcessor;

    @Autowired
    ProductWriter productWriter;

    @Autowired
    private ProductListener productListener;


    @Bean
    public Job ProductJob(JobRepository jobRepository, JobExecutionListener jobExecutionListener, Step AddPriceProductStep) {
        return new JobBuilder("ProductJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(productListener)
                .flow(AddPriceProductStep)
                .end()
                .build();
    }

    @Bean
    public Step AddPriceProductStep(JobRepository jobRepository, PlatformTransactionManager transactionManager, ProductWriter productWriter) {
        return new StepBuilder("ProductStep", jobRepository)
                .<ProductDto, ProductDto>chunk(10, transactionManager)
                .reader(productReader)
                .processor(productProcessor)
                .writer(productWriter)
                .build();
    }


}
