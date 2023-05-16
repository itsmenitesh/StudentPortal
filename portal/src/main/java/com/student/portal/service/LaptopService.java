package com.student.portal.service;

import com.student.portal.model.Laptop;
import com.student.portal.model.Student;
import com.student.portal.repository.ILaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepository iLaptopRepository;
    // C // addLaptop

    public String addLaptopData(Laptop laptop) {
        if(laptop !=null){
            iLaptopRepository.save(laptop);
            return "Laptop added";
        }else {
            return "wrong data";
        }
    }

    // R // allLaptop
    public List<Laptop> allLaptopData() {
        return iLaptopRepository.findAll();
    }


    // U // UpdateLaptopById

    public String updateLaptopDataById(Long laptopID, Laptop laptop) {
        Optional<Laptop> laptopList = iLaptopRepository.findById(laptopID);
        if(laptopList.isEmpty()){
            return "No Laptop is exists with this Id please check again";
        }else {
            laptop.setLaptopID(laptopID);
            iLaptopRepository.save(laptop);
            return "data Updated";
        }
    }


    // D // deleteLaptopById
    public String deleteLaptopDataBYId(Long laptopID) {
        Optional<Laptop> laptopList = iLaptopRepository.findById(laptopID);
        if(laptopList.isEmpty()){
            return "No Laptop is exists with this Id please check again";
        }else {

            iLaptopRepository.deleteById(laptopID);
            return "data Deleted";
        }
    }
}
