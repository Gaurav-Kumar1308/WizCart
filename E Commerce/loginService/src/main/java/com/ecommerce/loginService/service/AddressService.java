package com.ecommerce.loginService.service;

import com.ecommerce.loginService.entity.Address;

public interface AddressService{
    public Address get(Long id);
    public Address save(Address address);
    public Address update(Address address);
    public void delete(Long id);

}
