package kg.erkin.elasticsearchfirst.controller;

import kg.erkin.elasticsearchfirst.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    ResponseEntity<?> getById(@RequestParam Long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }
}
