package org.eduardocd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {

    private Integer id;
    private String name;
    private String lastName;
    private static int lastId;

    public Customer() {
        this.id = ++lastId;
    }
    public Customer(String name, String lastName) {
        this();
        this.name = name;
        this.lastName = lastName;
    }

}
