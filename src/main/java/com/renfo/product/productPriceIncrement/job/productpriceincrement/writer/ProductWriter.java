package com.renfo.product.productPriceIncrement.job.productpriceincrement.writer;

import com.renfo.product.productPriceIncrement.product.ProductDto;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Slf4j
public class ProductWriter extends NamedParameterJdbcDaoSupport implements ItemWriter<ProductDto> {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        setDataSource(dataSource);
    }

    @Override
    public void write(Chunk<? extends ProductDto> chunk) throws Exception {
        for (ProductDto product : chunk) {
            log.info("price: " + product.getProductPrice());
        }
    }
}
