package employee.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeForm {

    @NotNull
    @Size(min=1, max=100)
    private Integer id;

    @NotNull
    @Size(min=1, max=140)
    private String name;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @NotNull
    @Size(min=1, max=4)
    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
