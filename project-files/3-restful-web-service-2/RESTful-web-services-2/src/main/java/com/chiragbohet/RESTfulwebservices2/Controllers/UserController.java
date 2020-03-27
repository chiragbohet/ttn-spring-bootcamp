package com.chiragbohet.RESTfulwebservices2.Controllers;

import com.chiragbohet.RESTfulwebservices2.DAOs.UserDaoService;
import com.chiragbohet.RESTfulwebservices2.Entities.User;
import com.chiragbohet.RESTfulwebservices2.Exceptions.UserNotFoundException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;


@Api(value = "/users",description = "Allows different operations related to user")
@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;

    @ApiOperation(value = "Retrieves list of all users.")
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDaoService.retrieveAllUsers();
    }

    @ApiOperation(value = "Retrieves a user with the given id.")
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        User requestedUser = userDaoService.retrieveUserById(id);

        if(requestedUser != null)
            return requestedUser;
        else
            throw new UserNotFoundException("No user found with id : " + id);

    }

    @ApiOperation(value = "Creates a new user")
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        userDaoService.addUser(user);

        // filtering response object
        SimpleBeanPropertyFilter passwordFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","age");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserBasicFilter", passwordFilter);
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        // for adding location header in the response
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.put("location", Arrays.asList(location.toString()));


        //Sending the 201 Response code, created object and location header
        return new ResponseEntity<MappingJacksonValue>(mapping, headers, HttpStatus.CREATED);

    }

    @ApiOperation(value = "Deletes user with the given id.")
    @DeleteMapping("/users/{id}")
    public User deleteUserById(@PathVariable int id){
        User deletedUser = userDaoService.deleteUserById(id);
        if(deletedUser != null)
            {
                return deletedUser;
            }
        else
            throw new UserNotFoundException("No user found with id : " + id);
    }
}
