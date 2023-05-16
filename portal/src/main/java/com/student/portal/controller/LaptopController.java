package com.student.portal.controller;

import com.student.portal.model.Address;
import com.student.portal.model.Laptop;
import com.student.portal.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    LaptopService laptopService;


    // C // addLaptop
    @PostMapping()
    public String addLaptop(@RequestBody Laptop laptop){

        return laptopService.addLaptopData(laptop);
    }

    // R // allLaptop
    @GetMapping()
    public List<Laptop> allLaptop(){
        return laptopService.allLaptopData();
    }


    // U // UpdateLaptopById
    @PutMapping("{laptopID}")
    public String UpdateLaptopById(@PathVariable Long laptopID , @RequestBody Laptop laptop){
        return laptopService.updateLaptopDataById(laptopID , laptop);
    }


    // D // deleteLaptopById
    @DeleteMapping("{laptopID}")
    public String deleteLaptopById(@PathVariable Long laptopID){
        return laptopService.deleteLaptopDataBYId(laptopID);
    }
}
