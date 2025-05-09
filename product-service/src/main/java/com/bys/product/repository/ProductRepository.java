package com.bys.product.repository;

import com.bys.product.dto.request.ProductStockRequest;
import com.bys.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByTitleContaining(String title);

    List<Product> findByCategoryContaining(String category);

    @Query(value = "{'_id' :  ?0}", fields = "{'stock' :  1}")
    ProductStockRequest findProductStockById(String _id);
}
