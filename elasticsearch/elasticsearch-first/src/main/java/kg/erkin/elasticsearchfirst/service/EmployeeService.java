package kg.erkin.elasticsearchfirst.service;

import kg.erkin.elasticsearchfirst.dto.Employee;
import kg.erkin.elasticsearchfirst.exception.NoSuchItemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1L, "Test1", 20));
        employees.add(new Employee(2L, "Test2", 25));
        employees.add(new Employee(3L, "Test3", 30));
    }

    public Employee getById(Long id) {
        log.info("Try to found employee with id {}", id);
        Employee employee = employees.stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoSuchItemException(id));
        log.info("Found employee {}", employee);
        return employee;
    }
}
