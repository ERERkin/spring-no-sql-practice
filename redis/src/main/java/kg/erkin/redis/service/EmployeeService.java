package kg.erkin.redis.service;

import kg.erkin.redis.entity.Employee;
import kg.erkin.redis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable(value = "employees", key = "#id")
    public Employee getById(Long id) {
        System.out.println("Employee fetching from database:: " + id);
        return employeeRepository.findById(id).get();
    }

    @CachePut(value = "employees")
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @CacheEvict(value="employees",key = "#id")
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
