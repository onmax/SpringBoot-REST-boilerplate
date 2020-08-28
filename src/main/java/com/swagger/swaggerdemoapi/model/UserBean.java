package com.swagger.swaggerdemoapi.model;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;


public class UserBean {
    @Id
    private Integer id;

    @NotBlank
    @ApiModelProperty(example = "Max")
    private String name;

    @NotEmpty
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @ApiModelProperty(example = "20")
    @Min(value = 13, message = "Age should not be less than 13")
    @Max(value = 65, message = "Age should not be greater than 65")
    private int age;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
