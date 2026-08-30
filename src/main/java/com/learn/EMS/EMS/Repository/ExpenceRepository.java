package com.learn.EMS.EMS.Repository;

import com.learn.EMS.EMS.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ExpenceRepository extends JpaRepository<ExpenseEntity, Long> {
}
