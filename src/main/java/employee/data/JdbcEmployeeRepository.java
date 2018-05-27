package employee.data;

import employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcEmployeeRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public List<Employee> findEmployees(long max, int count) {
        return jdbc.query(
                "select id, name, age, gender" +
                        " from Employee" +
                        " where id < ?",
                new EmployeeRowMapper(), max);
    }

    @Override
    public Employee findOne(Integer id) {
        return jdbc.queryForObject(
                "select id, name, age, gender" +
                        " from Employee" +
                        " where id = ?",
                new EmployeeRowMapper(), id);
    }

    @Override
    public void save(Employee employee) {


        jdbc.update(
                "insert into Employee (id,name,age,gender)" +
                        " values (?, ?, ?, ?)",
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getGender());

    }


    private static class EmployeeRowMapper implements RowMapper<Employee> {
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"));

        }
    }
}
