package com.ecommerce.loginService.service.impl;

import com.ecommerce.loginService.entity.Address;
import com.ecommerce.loginService.repository.AddressRepository;
import com.ecommerce.loginService.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address get(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
