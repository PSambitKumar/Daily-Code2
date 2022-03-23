package com.csm.Repository;

import com.csm.Entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderMaster, Integer> {
}
