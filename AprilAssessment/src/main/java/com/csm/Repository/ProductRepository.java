package com.csm.Repository;

import com.csm.Entity.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductMaster, Integer> {
}
