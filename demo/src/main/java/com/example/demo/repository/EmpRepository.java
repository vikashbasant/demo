package com.example.demo.repository;

import com.example.demo.domain.Emp;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface EmpRepository extends JpaRepository<Emp, Integer> {


    List<Emp> findByAgeGreaterThan(Integer age);

    List<Emp> findDistinctByName(String name);
}
