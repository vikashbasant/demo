package com.example.demo.service;

import com.example.demo.domain.Emp;
import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.TestDTO;
import com.example.demo.repository.EmpRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class EmpServiceImp implements EmpService{

    @Autowired
    private EmpRepository empRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void saveDataIntoDB(TestDTO testDTO) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TestDTO>  entity = new HttpEntity<>(testDTO, headers);

        restTemplate.exchange("http://localhost:9011/test/save", HttpMethod.POST, entity, Object.class);

    }

    @Override
    public Object getById(TestDTO testDTO) {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestDTO> entity = new HttpEntity<>(testDTO, headers);
        ResponseEntity<Object> exchange1 = restTemplate.exchange("http://localhost:9011/test/getById", HttpMethod.POST, entity, Object.class);
        return exchange1;

    }

    @Override
    public Object getByName(TestDTO responseDTO) {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TestDTO>  entity = new HttpEntity<>(responseDTO, headers);

        ResponseEntity<Object> exchange1 = restTemplate.exchange("http://localhost:9011/test/getByName", HttpMethod.POST, entity, Object.class);
        return exchange1;
    }

    @Override
    public Object getByAddress(TestDTO testDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestDTO> entity = new HttpEntity<>(testDTO, headers);
        ResponseEntity<Object> exchange1 = restTemplate.exchange("http://localhost:9011/test/getByAddress", HttpMethod.POST, entity, Object.class);
        return exchange1;
    }

    @Override
    public Object getByIdAndAddress(TestDTO testDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestDTO> entity = new HttpEntity<>(testDTO, headers);
        ResponseEntity<Object> exchange1 = restTemplate.exchange("http://localhost:9011/test/getByIdAndAddress", HttpMethod.POST, entity, Object.class);
        return exchange1;
    }

    @Override
    public Object getByIdAndName(TestDTO testDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestDTO> entity = new HttpEntity<>(testDTO, headers);
        ResponseEntity<Object> exchange1 = restTemplate.exchange("http://localhost:9011/test/getByIdAndName", HttpMethod.POST, entity, Object.class);
        return exchange1;
    }

    @Override
    public Object getByNameAndAddress(TestDTO testDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestDTO> entity = new HttpEntity<>(testDTO, headers);
        ResponseEntity<Object> exchange1 = restTemplate.exchange("http://localhost:9011/test/getByNameAndAddress", HttpMethod.POST, entity, Object.class);
        return exchange1;
    }

    @Override
    public List<EmpDTO> getByAgeGreaterThan(EmpDTO empDTO) {
        List<Emp> lResult = empRepository.findByAgeGreaterThan(empDTO.getAge());
        List<EmpDTO> fResult= new ArrayList<>();
        lResult.forEach(emp -> {
            EmpDTO tResult = new EmpDTO();
            tResult.setId(emp.getId());
            tResult.setName(emp.getName());
            tResult.setAge(emp.getAge());
            tResult.setAddress(emp.getAddress());
            fResult.add(tResult);
        });
        return fResult;
    }

    @Override
    public List<EmpDTO> getDistinctName(String name) {
        List<Emp> tResult = empRepository.findDistinctByName(name);
        List<EmpDTO> fResult = new ArrayList<>();
        tResult.forEach(emp ->{
            EmpDTO iResult = new EmpDTO();
            iResult.setName(emp.getName());
            fResult.add(iResult);
        });
        return fResult;
    }


}
