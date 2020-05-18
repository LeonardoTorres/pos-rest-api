/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.domain.customers;

import java.util.List;

/**
 *
 * @author leonardo
 */
public interface CustomersRepository {
    void create(Customer customer);

    void delete(String id);

    Customer findById(String id);

    List<Customer> list();

    Customer update(Customer customer);
}
