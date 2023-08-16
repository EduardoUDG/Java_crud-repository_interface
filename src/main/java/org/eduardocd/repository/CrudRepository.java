package org.eduardocd.repository;

import org.eduardocd.model.Customer;

import java.util.List;

public interface CrudRepository {

    List<Customer> getCustomers();
    Customer getCustomerById(Integer id);
    Customer save(Customer customer);
    Customer update(Customer customer);
    void deleteById(Integer id);

}
