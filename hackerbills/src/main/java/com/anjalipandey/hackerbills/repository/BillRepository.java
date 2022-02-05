package com.anjalipandey.hackerbills.repository;

import com.anjalipandey.hackerbills.entity.BillDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Repository
 */
@Repository
public interface BillRepository extends JpaRepository<BillDetailsEntity, Integer> {
    BillDetailsEntity findByBilledDate(String dueDate);
}
