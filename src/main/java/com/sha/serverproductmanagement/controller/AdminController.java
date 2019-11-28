package com.sha.serverproductmanagement.controller;

import com.sha.serverproductmanagement.model.Employee;
import com.sha.serverproductmanagement.model.StringResponse;
import com.sha.serverproductmanagement.model.User;
import com.sha.serverproductmanagement.service.EmployeeService;
import com.sha.serverproductmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;


    @PutMapping("/api/admin/user-update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User existUser = userService.findByUsername(user.getUsername());
        if (existUser != null && !existUser.getId().equals(user.getId())) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
    }

    //This can be also @DeleteMapping.
    @PostMapping("/api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-all")
    public ResponseEntity<?> findAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/user-number")
    public ResponseEntity<?> numberOfUsers(){
        Long number = userService.numberOfUsers();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        //to return it, we will use String Response because long is not a suitable response for rest api
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //create employee
    @PostMapping("/api/admin/employee-create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //update employee
    @PutMapping("/api/admin/employee-update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.CREATED);
    }

    //delete employee
    @PostMapping("/api/admin/employee-delete")
    public ResponseEntity<?> deleteEmployee(@RequestBody Employee employee){
        employeeService.deleteEmployee(employee.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //employee all
    @GetMapping("/api/admin/employee-all")
    public ResponseEntity<?> findAllEmployees(){
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    //get total employee
    @GetMapping("/api/admin/employee-number")
    public ResponseEntity<?> numberOfEmployees(){
        Long number = employeeService.numberOfEmployees();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
