package com.student.portal.controller;

import com.student.portal.model.Address;
import com.student.portal.model.Student;
import com.student.portal.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

   // C //addAddress
    @PostMapping()
    public String addAddress(@RequestBody Address address){

        return addressService.addAddressData(address);
    }

    // R // allAddress
    @GetMapping()
    public List<Address> allAddress(){
        return addressService.allAddressData();
    }

    // U // UpdateStudentById
    @PutMapping("{addressId}")
    public String updateAddressIdById(@PathVariable Long addressId , @RequestBody Address address){
        return addressService.updateAddressDataById(addressId , address);
    }

    // D // deleteAddressById
    @DeleteMapping("{addressId}")
    public String deleteAddressById(@PathVariable Long addressId){
        return addressService.deleteAddressDataBYId(addressId);
    }

}
