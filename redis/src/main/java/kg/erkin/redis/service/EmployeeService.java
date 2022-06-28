package kg.erkin.redis.service;

import kg.erkin.redis.entity.Employee;
import kg.erkin.redis.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable(value = "employees")
    public Employee getById(Long id) {
        log.info("getting employee by id: {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found by id " + id));
    }

    @Cacheable(value = "employees")
    public Employee save(Employee employee) {
        log.info("updating employee: {}", employee);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @CacheEvict(value="employees",key = "#id")
    public void deleteById(Long id) {
        log.info("deleting employee by id: {}", id);
        employeeRepository.deleteById(id);
    }
}
