package com.chiragbohet.RESTfulwebservices2.Entities;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@JsonFilter("UserBasicFilter")
@ApiModel(description = "A simple POJO used in exercise for various demonstrations.")
@Getter
@Setter
@AllArgsConstructor
public class User {

    private Integer id;

    @ApiModelProperty(notes = "Name should have atleast 2 characters.")
    @Size(min = 2, message = "Name should have atleast 2 characters.")
    private String name;

    @ApiModelProperty(notes = "Age of user should be >= 18")
    @Min(value = 18, message = "Age of user should be >= 18")
    private Integer age;

    //@JsonIgnore
    @Size(min = 6)
    private String password;

    //@JsonIgnore
    public String getPassword() {
        return password;
    }

    //@JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
