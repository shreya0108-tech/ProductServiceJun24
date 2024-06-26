package com.scaler.productservicejune24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // this makes sure that the class will be hosting HTTP APIs
@RequestMapping("say")      //sets an address for the class
public class SampleController {

    @GetMapping("/hello/{name}/{times}")        //sets an address for a method / API where
    // data is read for multiple inputs, here we need to specify in the signature which input will go where.
    public String sayHello(@PathVariable("name") String name, @PathVariable("times") int times)
    {
        String out = "";
        for(int i=0;i<times;i++) {
            out += name +" \n";
        }
        return out;
    }

    @GetMapping("/bye/{age}")   //sets an address for a method / API where data is read for 1 input
    public String sayBye(@PathVariable int age)
    {
        return "Bye"+" "+age;
    }

}

//http://localhost:4667/say/hello
