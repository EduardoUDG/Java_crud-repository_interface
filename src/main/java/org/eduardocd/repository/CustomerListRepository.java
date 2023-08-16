package org.eduardocd.repository;

import org.eduardocd.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerListRepository implements SortablePageableCrudRepository {

    private List<Customer> dataSource;

    public CustomerListRepository() {
        this.dataSource = new ArrayList<>();
    }
    @Override
    public List<Customer> getCustomers() {
        return this.dataSource;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer c = null;
        for (Customer customer : this.dataSource) {
            if (customer.getId() != null && customer.getId().equals(id)) {
                c = customer;
                break; // Nos salimos del for
            }
        }
        return c;
    }

    @Override
    public Customer save(Customer customer) {
        this.dataSource.add(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Customer c = this.getCustomerById(customer.getId());
        c.setName(customer.getName());
        c.setLastName(customer.getLastName());
        return c;
    }

    @Override
    public void deleteById(Integer id) {
        Customer c = this.getCustomerById(id);
        this.dataSource.remove(c);
    }

    @Override
    public List<Customer> sort(String attribute, Direction direction) {
        List<Customer> listOrdered = new ArrayList<>(this.dataSource);
        listOrdered.sort((a, b) -> {
            int result = 0;
            if (direction == Direction.ASC) {
                result = reorder(attribute, a, b);
            } else if (direction == Direction.DES) {
                result = reorder(attribute, b, a);
            }
            return result;
        });
        return listOrdered;
    }

    @Override
    public List<Customer> paginate(int start, int end) {
        return this.dataSource.subList(start, end);
    }

    public static int reorder(String attribute, Customer a, Customer b) {
        int result = 0;
        switch (attribute) {
            case "id" : result = a.getId().compareTo(b.getId()); break;
            case "name" : result = a.getName().compareTo(b.getName()); break;
            case "lastName" : result = a.getLastName().compareTo(b.getLastName()); break;
        }
        return result;
    }
}
