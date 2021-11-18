package com.augusto.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augusto.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker,Long>{

}
