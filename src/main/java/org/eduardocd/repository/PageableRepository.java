package org.eduardocd.repository;

import org.eduardocd.model.Customer;

import java.util.List;

public interface PageableRepository {

    List<Customer> paginate(int start, int end);

}
