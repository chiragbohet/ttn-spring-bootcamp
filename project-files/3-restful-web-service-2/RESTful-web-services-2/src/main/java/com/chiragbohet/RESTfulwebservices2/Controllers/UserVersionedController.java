package com.chiragbohet.RESTfulwebservices2.Controllers;

import com.chiragbohet.RESTfulwebservices2.DAOs.UserDaoService;
import com.chiragbohet.RESTfulwebservices2.Entities.User;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Demonstration of Various versioning strategies")
@RestController
public class UserVersionedController {

    @Autowired
    UserDaoService userDaoService;


    public MappingJacksonValue getUsersBasicUtility()
    {
        List<User> users = userDaoService.retrieveAllUsers();

        // Basic Filter
        SimpleBeanPropertyFilter basicFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
        FilterProvider basicFilterProvider = new SimpleFilterProvider().addFilter("UserBasicFilter", basicFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(basicFilterProvider);
        return mapping;
    }

    public MappingJacksonValue getUsersEnhancedUtility()
    {   List<User> users = userDaoService.retrieveAllUsers();

        // Enhanced Filter
        SimpleBeanPropertyFilter enhancedFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "age", "password");
        FilterProvider enhancedFilterProvider = new SimpleFilterProvider().addFilter("UserBasicFilter", enhancedFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(enhancedFilterProvider);
        return mapping;
    }

    // URI versioning

    @GetMapping("/basic/users")
    public MappingJacksonValue getAllUsersBasicUri() {
        return getUsersBasicUtility();
    }

    @GetMapping("/enhanced/users")
    public MappingJacksonValue getAllUsersEnhancedUri() {
        return getUsersEnhancedUtility();
    }


    // Request Parameter versioning

    @GetMapping(value = "/users/param", params = "version=1")
    public MappingJacksonValue getAllUsersBasicRequestParameter() {
        return getUsersBasicUtility();
    }

    @GetMapping(value = "/users/param", params = "version=2")
    public MappingJacksonValue getAllUsersEnhancedRequestParameter() {
        return getUsersEnhancedUtility();
    }


    // Custom Header Versioning

    @GetMapping(value = "/users/header", headers = "X-MYAPI-VERSION=1")
    public MappingJacksonValue getAllUsersBasicCustomHeader() {
        return getUsersBasicUtility();
    }

    @GetMapping(value = "/users/header", headers = "X-MYAPI-VERSION=2")
    public MappingJacksonValue getAllUsersEnhancedCustomHeader() {
        return getUsersEnhancedUtility();
    }



    // MIME type Versioning

    @GetMapping(value = "/users/produces", produces = "application/vnd.company.app-v1+json")
    public MappingJacksonValue getAllUsersBasicMimeType() {
        return getUsersBasicUtility();
    }

    @GetMapping(value = "/users/produces", produces = "application/vnd.company.app-v2+json")
    public MappingJacksonValue getAllUsersEnhancedMimeType() {
        return getUsersEnhancedUtility();
    }


}
