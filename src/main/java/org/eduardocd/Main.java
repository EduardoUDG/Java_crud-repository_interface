package org.eduardocd;

import org.eduardocd.model.Customer;
import org.eduardocd.repository.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SortablePageableCrudRepository customerRepository = new CustomerListRepository();

        System.out.println("=============  List  ================");
        customerRepository.save( new Customer("Jano", "Perez") );
        customerRepository.save( new Customer("Bea", "Gonzales") );
        customerRepository.save( new Customer("Luci", "Martinez") );
        customerRepository.save( new Customer("Andres", "Guzman") );
        List<Customer> customers = customerRepository.getCustomers();
        customers.forEach(System.out::println);

        System.out.println();
        System.out.println("=============  Paginate  ================");


        List<Customer> pageable = customerRepository.paginate(1,3);
        pageable.forEach(System.out::println);


        System.out.println();
        System.out.println("=============  ASC SORT BY NAME  ================");
        List<Customer> ascSort = customerRepository.sort("name", Direction.ASC);
        ascSort.forEach(System.out::println);


        System.out.println();
        System.out.println("=============  EDIT CUSTOMER & SORT BY LASTNAME  ================");
        Customer beaUpdated = new Customer("Bea", "Mena");
        beaUpdated.setId(2);
        customerRepository.update(beaUpdated);
        Customer bea = customerRepository.getCustomerById(2);
        System.out.println("bea = " + bea);
        System.out.println("==========================================================");
        customerRepository
                .sort("lastName", Direction.ASC)
                .forEach(System.out::println);


        System.out.println();
        System.out.println("=============  DELETE A CUSTOMER  ================");
        customerRepository.deleteById(2);
        customerRepository.getCustomers().forEach(System.out::println);

    }
}