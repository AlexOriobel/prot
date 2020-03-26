package com.example.demo.controller;

import com.example.demo.dao.AddressRepository;
import com.example.demo.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddresRestController {

    private final AddressRepository addressRepository;


    public AddresRestController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @GetMapping
    public ResponseEntity<Iterable<Address>> getAddressList() {
        return new ResponseEntity <>(addressRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> getAddress(@PathVariable String id) {
        return new ResponseEntity <>(addressRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        Address saveAddress = addressRepository.save(address);
        return new ResponseEntity<>(saveAddress, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Address> getByFullAddress(@RequestParam(value = "country") String country,
                                            @RequestParam(value = "city") String city,
                                            @RequestParam(value = "street") String street) {
        if (addressRepository.findAddressByFullName(country, city, street) != null) {
            addressRepository.delete(addressRepository.findAddressByFullName(country, city, street));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
