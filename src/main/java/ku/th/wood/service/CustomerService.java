package ku.th.wood.service;
import ku.th.wood.data.CustomerRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ku.th.wood.model.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository repository;
    public Customer logined;
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }


    public void createCustomer(Customer customer) {
        repository.saveCustomer(customer);
    }
    public Customer findCustomer(String username) {
        try {
            return repository.findByUsername(username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public Customer getLogined () {
        try {
            System.out.println("try to get logined");
            return repository.isLogined();
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public void getLogout(String username){
        System.out.println("try to logout2");
        repository.getOffline(username);
    }
    public void Finan(String username,Double update){
        repository.buyCalculator(username, update);
    }
    public Customer checkPin(Customer inputCustomer){
        Customer storedCustomer = findCustomer(inputCustomer.getUsername());
        if(storedCustomer != null){
            String hashPin = storedCustomer.getPass();
            if(inputCustomer.getPass().equals(hashPin)){
                return storedCustomer;
            }
        }
        return null;
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }
}
