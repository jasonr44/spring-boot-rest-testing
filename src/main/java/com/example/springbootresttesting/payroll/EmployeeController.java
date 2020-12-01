package com.example.springbootresttesting.payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class EmployeeController {
    private final EmployeeRepository repository;
    public static final String EMPLOYEES_ROUTE = "/employees";
    public static final String ID_PARAMETER = "{id}";
    public static final String EMPLOYEES_ID_PARAMETER_ROUTE = EMPLOYEES_ROUTE + "/" + ID_PARAMETER;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(EMPLOYEES_ROUTE)
    List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping(EMPLOYEES_ROUTE)
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @GetMapping(EMPLOYEES_ID_PARAMETER_ROUTE)
    Employee one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping(EMPLOYEES_ID_PARAMETER_ROUTE)
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping(EMPLOYEES_ID_PARAMETER_ROUTE)
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
