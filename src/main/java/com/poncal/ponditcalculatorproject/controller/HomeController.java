package com.poncal.ponditcalculatorproject.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Calculator";
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam(name = "num1") Double num1, @RequestParam(name = "num2") Double num2) {
        Response response = new Response(String.valueOf(num1), String.valueOf(num2), "Addition", String.valueOf(num1+num2));
        return new ResponseEntity<>(response, OK);
    }
    @PostMapping("/sub")
    public ResponseEntity<?> sub(@RequestParam(name = "num1") Double num1, @RequestParam(name = "num2") Double num2) {
        Response response = new Response(String.valueOf(num1), String.valueOf(num2), "Subtraction", String.valueOf(num1-num2));
        return new ResponseEntity<>(response, OK);
    }
    @PostMapping("/mul")
    public ResponseEntity<?> mul(@RequestParam(name = "num1") Double num1, @RequestParam(name = "num2") Double num2) {
        Response response = new Response(String.valueOf(num1), String.valueOf(num2), "Multiplication", String.valueOf(num1*num2));
        return new ResponseEntity<>(response, OK);
    }
    @PostMapping("/div")
    public ResponseEntity<?> div(@RequestParam(name = "num1") Double num1, @RequestParam(name = "num2") Double num2) {
        Response response = new Response(String.valueOf(num1), String.valueOf(num2), "Division", String.valueOf(num1/num2));
        return new ResponseEntity<>(response, OK);
    }
}


@Data
@AllArgsConstructor
class Response {
    public String number1;
    public String number2;
    public String operation;
    public String result;
}