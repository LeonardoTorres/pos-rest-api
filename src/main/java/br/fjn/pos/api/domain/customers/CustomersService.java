/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.domain.customers;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author leonardo
 */
@RequestScoped
public class CustomersService {

    @Inject
    private CustomersRepository customersRepository;

    public void create(Customer customer) throws Exception {
        this.isValidCPF(customer.getCpf());
        this.customersRepository.create(customer);
    }

    public void delete(String id) {
        Customer customer = this.customersRepository.findById(id);
        if (customer == null) {
            throw new NotFoundException("Entity not found");
        }
        this.customersRepository.delete(id);
    }

    public Customer findById(String id) {
        Customer customer = this.customersRepository.findById(id);
        if (customer == null) {
            throw new NotFoundException("Entity not found");
        }
        return customer;
    }

    public List<Customer> list() {
        return this.customersRepository.list();
    }

    public Customer update(Customer customer) {
        return this.customersRepository.update(customer);
    }

    private void isValidCPF(String cpf) throws Exception {
        if (cpf.length() != 11) {
            throw new Exception("Invalid CPF");
        }
    }

}
