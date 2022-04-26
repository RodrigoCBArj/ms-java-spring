package com.rodrigocbarj.hrworker.repositories;

import com.rodrigocbarj.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
