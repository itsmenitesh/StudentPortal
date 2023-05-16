package com.student.portal.service;

import com.student.portal.model.Address;
import com.student.portal.model.Student;
import com.student.portal.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepository iAddressRepository;

    // C //addAddress
    public String addAddressData(Address address) {
        if(address !=null){
            iAddressRepository.save(address);
            return "address of student added";
        }else {
            return "address data wrong ";
        }
    }

    //R // AllAddress
    public List<Address> allAddressData() {
        return iAddressRepository.findAll();
    }


    // U // UpdateAddressById
    public String updateAddressDataById(Long addressId, Address address) {
        Optional<Address> addressList = iAddressRepository.findById(addressId);
        if(addressList.isEmpty()){
            return "No Address is exists with this Id please check again";
        }else {
            address.setAddressId(addressId);
            iAddressRepository.save(address);
            return "data Updated";
        }
    }


    // D // deleteAddressById
    public String deleteAddressDataBYId(Long addressId) {
        Optional<Address> addressList = iAddressRepository.findById(addressId);
        if(addressList.isEmpty()){
            return "No Address is exists with this Id please check again";
        }else {

            iAddressRepository.deleteById(addressId);
            return "data deleted";
        }
    }
}
