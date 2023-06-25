package com.renfo.product.productPriceIncrement.product.dao.mapper;

import com.renfo.product.productPriceIncrement.product.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDto productDto = new ProductDto();

        productDto.setProductId(rs.getInt("PRODUCT_ID"));
        productDto.setProductName(rs.getString("PRODUCT_NAME"));
        productDto.setProductPrice(rs.getInt("PRODUCT_PRICE"));
        productDto.setCreationDate(rs.getDate("CREATION_DATE"));

        return productDto;
    }
}
