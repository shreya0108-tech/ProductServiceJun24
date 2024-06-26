package com.scaler.productservicejune24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("say")
public class SampleController {

    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("times") int times)
    {
        String out = "";
        for(int i=0;i<times;i++) {
            out += name +" \n";
        }
        return out;
    }

    @GetMapping("/bye/{age}")
    public String sayBye(@PathVariable int age)
    {
        return "Bye"+" "+age;
    }

}

//http://localhost:4667/say/hello
