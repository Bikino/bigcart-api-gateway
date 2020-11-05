//package com.bigcart.apigateway.proxy;
//
//
//import com.bigcart.apigateway.dto.EmployeeDTO;
//import com.bigcart.apigateway.model.Employee;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//
//@FeignClient(name = "UserManagement-Service", url = "http://localhost:9988" )
//public interface LoginProxy {
//    @GetMapping(value = "/login2")
//    public Employee loginEmployee(@PathVariable String userName);
//}
