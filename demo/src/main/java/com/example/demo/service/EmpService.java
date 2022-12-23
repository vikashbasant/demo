package com.example.demo.service;

import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.TestDTO;

import java.util.List;

public interface EmpService {

    void saveDataIntoDB(TestDTO testDTO);

    Object getById(TestDTO testDTO);

    Object getByName(TestDTO testDTO);

    Object getByAddress(TestDTO testDTO);

    Object getByIdAndAddress(TestDTO testDTO);

    Object getByIdAndName(TestDTO testDTO);

    Object getByNameAndAddress(TestDTO testDTO);

    List<EmpDTO> getByAgeGreaterThan(EmpDTO empDTO);

    List<EmpDTO> getDistinctName(String name);
}
