package com.practiceProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiceProj.entity.EntityClass;

@Repository
public interface ProjRepo extends JpaRepository<EntityClass, Integer> {

}
