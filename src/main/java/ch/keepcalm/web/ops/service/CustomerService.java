package ch.keepcalm.web.ops.service;

import ch.keepcalm.web.ops.domain.Customer;
import ch.keepcalm.web.ops.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marcelwidmer on 24/05/15.
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){
       return customerRepository.findAll();
    }

}
