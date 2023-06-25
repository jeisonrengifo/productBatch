package com.renfo.product.productPriceIncrement.job.productpriceincrement.reader;

import com.renfo.product.productPriceIncrement.product.ProductDto;
import com.renfo.product.productPriceIncrement.product.dao.mapper.ProductRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@StepScope
@Slf4j
public class ProductReader extends JdbcCursorItemReader<ProductDto> {

    private static final String PRODUCT_QUERY = "SELECT * FROM PRODUCT";

    private ExecutionContext stepExecutionContext;

    public ProductReader(DataSource dataSource) {
        setDataSource(dataSource);
        setName("ProductReader");
        setRowMapper(new ProductRowMapper());
        setSql(PRODUCT_QUERY);
    }

    @Override
    public ProductDto read() throws Exception {
        return super.read();
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        this.stepExecutionContext = stepExecution.getExecutionContext();
    }


}
