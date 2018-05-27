package employee.data;

import employee.domain.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findEmployees(long max, int count);

    Employee findOne(Integer id);

    void save(Employee employee);
}
