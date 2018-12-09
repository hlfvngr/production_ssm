package com.cskaoyan.erp.service.impl;

import com.cskaoyan.erp.bean.Product;
import com.cskaoyan.erp.mapper.ProductMapper;
import com.cskaoyan.erp.service.ProductService;
import com.cskaoyan.erp.utils.page.PageModel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    public List<Product> findAllProduct() {
        return productMapper.selectAllProduct();
    }


    public List<Product> findAllProduct(Product product,PageModel pageModel) {
       Map<String,Object> map = new HashMap<String,Object>();
        map.put("productId",product.getProductId());
        map.put("productName",product.getProductName());
        map.put("productType",product.getProductType());
         int count = productMapper.count(map);
        if(count == 0){
            return null;
        }
        pageModel.setRecordCount(count);
        int offset = pageModel.getFirstLimitParam();
        int limit = pageModel.getRows();
        map.put("limit",limit);
        map.put("offset",offset);
       /* PageHelper.startPage(pageModel.getPage(),pageModel.getRows());*/
        return productMapper.selectByPage(map);
    }


    public boolean insertProduct(Product product) {
        return productMapper.insert(product) != 0;
    }

    public boolean updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product) != 0;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public boolean deleteProduct(String[] ids) {
        for (int i = 0; i < ids.length; i++) {
            int ret = productMapper.deleteByPrimaryKey(ids[i]);
            if(ret == 0){
                return false;
            }
        }
        return true;
    }

    public boolean updateProductNote(Product product) {
        return productMapper.updateByPrimaryKey(product) != 0;
    }

    public Product findProductById(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    public Product findProductByName(String productName) {
        return productMapper.selectProductByName(productName);
    }
}
