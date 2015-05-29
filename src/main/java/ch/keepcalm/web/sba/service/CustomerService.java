package ch.keepcalm.web.sba.service;

import ch.keepcalm.web.sba.domain.Customer;
import ch.keepcalm.web.sba.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by marcelwidmer on 24/05/15.
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Transactional
    public void add(String name) {
        final Customer customer = new Customer();
        customer.setName(name);
        this.customerRepository.saveAndFlush(customer);
    }

    @Transactional
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Transactional
    public Customer findOne(Long id) {
        return customerRepository.getOne(id);
    }
}
