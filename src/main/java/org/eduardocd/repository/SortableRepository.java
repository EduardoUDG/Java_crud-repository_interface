package org.eduardocd.repository;

import org.eduardocd.model.Customer;

import java.util.List;

public interface SortableRepository {

    List<Customer> sort(String attribute, Direction  direction);

}
