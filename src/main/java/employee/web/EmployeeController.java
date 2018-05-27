package employee.web;

import employee.data.EmployeeRepository;
import employee.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository spittleRepository) {
        this.employeeRepository = spittleRepository;
    }


    @RequestMapping(method=RequestMethod.GET)
    public List<Employee> spittles(
            @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
            @RequestParam(value="count", defaultValue="20") int count) {
        return employeeRepository.findEmployees(max,count);
    }


    @RequestMapping(method=RequestMethod.POST)
    public String saveSpittle(EmployeeForm form, Model model) throws Exception {
        employeeRepository.save(new Employee(form.getId(), form.getName(),
                form.getAge(), form.getGender()));
        return "redirect:/employees";
    }


}
