package com.renfo.product.productPriceIncrement.job.productpriceincrement.procesor;

import com.renfo.product.productPriceIncrement.product.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductProcessor implements ItemProcessor {
    @Override
    public Object process(Object item) throws Exception {
        ProductDto productDto = (ProductDto) item;
        if (productDto.getProductPrice() < 100) {
            log.info("Product Id :"+productDto.getProductId().toString());
            productDto.setProductPrice(productDto.getProductPrice() + 12);
        }

        return productDto;
    }
}
