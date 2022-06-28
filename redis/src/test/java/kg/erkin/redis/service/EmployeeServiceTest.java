package kg.erkin.redis.service;

import kg.erkin.redis.AbstractTest;
import kg.erkin.redis.entity.Employee;
import kg.erkin.redis.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class EmployeeServiceTest extends AbstractTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void getById() {
        Employee employee1 = employeeService.save(new Employee("Mister1", 25));
        Employee employee2 = employeeService.save(new Employee("Mister2", 25));

        getAndPrint(employee1.getId());
        getAndPrint(employee2.getId());
        getAndPrint(employee1.getId());
        getAndPrint(employee2.getId());
    }

    private void getAndPrint(Long id){
        log.info("employee found: {}", employeeService.getById(id));
    }

    @Test
    void save() {
        Employee employee1 = employeeService.save(new Employee("Mister1", 25));
        log.info("created employee1 : {}", employee1);

        Employee employee2 = employeeService.save(new Employee(employee1.getId(), "Mister1", 30));
        log.info("created employee1 : {}", employee2);
    }

    @Test
    void getAll() {
        boolean test = Pattern.compile("test.").matcher("testt").find();
        System.out.println(test);
    }

    @Test
    void deleteById() {
        Employee employee1 = employeeService.save(new Employee("Mister1", 25));
        log.info("employee : {}", employeeService.getById(employee1.getId()));

        Employee employee2 = employeeService.save(new Employee("Mister2", 25));
        log.info("employee : {}", employeeService.getById(employee2.getId()));

        employeeRepository.deleteById(employee1.getId());
        employeeService.deleteById(employee2.getId());

        log.info("employee : {}", employeeService.getById(employee1.getId()));

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            log.info("employee : {}", employeeService.getById(employee2.getId()));
        });

        String expectedMessage = "Employee not found by id";
        String actualMessage = exception.getMessage();

        log.info("employee : {}", actualMessage);

        assertTrue(Pattern.compile(expectedMessage + ".").matcher(actualMessage).find());
    }
}