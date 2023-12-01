package br.inatel.labs.labsrest.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Hello")
public class HelloController {

    @GetMapping
    public MyMessage processasarGetHello(){
        MyMessage msg = new MyMessage();
        msg.setInfo("Ola Mundo REST");
        return msg;
    }
}
