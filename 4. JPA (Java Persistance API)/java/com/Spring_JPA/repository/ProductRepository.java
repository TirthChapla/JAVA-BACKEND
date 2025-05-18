package com.Spring_JPA.repository;

import com.Spring_JPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
                                                    //✅ entity , datatype of Primary key
public interface ProductRepository extends JpaRepository<Product,Integer>
{


}
