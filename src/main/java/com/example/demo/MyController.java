package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Writer;

@Controller
public class MyController {

    @Autowired
    PizzaRepository repository;

    // два метода
    @GetMapping("/add")
    public @ResponseBody String add(
            @RequestParam String name,
            @RequestParam Integer size) {
        Pizza pizza = new Pizza(name, size);
        repository.save(pizza);
        return "Saved!";
    }

    @GetMapping("/list")
    public @ResponseBody Iterable<Pizza> getAll() {
        return repository.findAll();
    }


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public void handleException(final Exception e, final HttpServletRequest request,
                                Writer writer) throws IOException {
        writer.write(String.format(
                "{\"error\":{\"java.class\":\"%s\", \"message\":\"%s\"}}",
                e.getClass(), e.getMessage()));
    }
}
