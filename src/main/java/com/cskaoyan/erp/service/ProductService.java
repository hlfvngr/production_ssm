package com.cskaoyan.erp.service;

import com.cskaoyan.erp.bean.Product;
import com.cskaoyan.erp.utils.page.PageModel;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    List<Product> findAllProduct(Product product,PageModel pageModel);

    boolean insertProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(String[] ids);

    boolean updateProductNote(Product product);

    Product findProductById(String productId);

    Product findProductByName(String searchValue);
}
