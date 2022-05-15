package com.example.couriermobile.feign;

import com.example.couriermobile.entity.Human;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "human",url = "http://localhost:8089/")
public interface HumanFegin {

    @GetMapping("human/{id}")
    Human getOne(@PathVariable Long id);

    @GetMapping
    List<Human> getAll();

}
