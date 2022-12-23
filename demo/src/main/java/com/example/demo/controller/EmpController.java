package com.example.demo.controller;


import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.service.EmpService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping(value="save")
    public String saveDataToDB(@RequestBody TestDTO testDTO){
        empService.saveDataIntoDB(testDTO);
        return "Successfully added data into databases";

    }

    @PostMapping(value = "getById")
    public Object getById(@RequestBody TestDTO testDTO){
        return empService.getById(testDTO);
    }


    @PostMapping("getByName")
    public Object getByName(@RequestBody TestDTO testDTO){
        return empService.getByName(testDTO);
    }


    @PostMapping("getByAddress")
    public Object getByAddress(@RequestBody TestDTO testDTO){
        return empService.getByAddress(testDTO);
    }

    @PostMapping("getByIdAndName")
    public Object getByIdAndName(@RequestBody TestDTO testDTO){
        return empService.getByIdAndName(testDTO);
    }

    @PostMapping("getByIdAndAddress")
    public Object getByIdAndAddress(@RequestBody TestDTO testDTO){
        return empService.getByIdAndAddress(testDTO);
    }

    @PostMapping("getByNameAndAddress")
    public Object getByNameAndAddress(@RequestBody TestDTO testDTO){
        return empService.getByNameAndAddress(testDTO);
    }

    @PostMapping("getByAgeGraterThan")
    public List<EmpDTO> getByAgeGreaterThan(@RequestBody EmpDTO empDTO){
        return empService.getByAgeGreaterThan(empDTO);
    }

    @PostMapping("distinctByName")
    public List<EmpDTO> getDistinct(@RequestBody String name){
        return empService.getDistinctName(name);
    }

}
