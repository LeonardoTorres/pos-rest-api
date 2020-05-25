/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.domain.customers.impl;

import br.fjn.pos.api.domain.customers.Customer;
import java.util.List;
import br.fjn.pos.api.domain.customers.CustomersRepository;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author leonardo
 */
@ApplicationScoped
public class CustomersRepositoryDatabaseAsList implements CustomersRepository {

    private final List<Customer> customersDB = new ArrayList<>();

    @Override
    public void create(Customer customer) {
        this.customersDB.add(customer);
    }

    @Override
    public Customer findById(String id) {
        return customersDB.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Customer> list() {
        return this.customersDB;
    }

    @Override
    public Customer update(Customer customer) {
        for (int i = 0; i < customersDB.size(); i++) {
           if (customersDB.get(i).getId().equals(customer.getId())){
               customersDB.set(i, customer);
           } 
        }
        return customer;
    }

    @Override
    public void delete(String id) {
        customersDB.removeIf(customer -> customer.getId().equals(id));
    }
}
