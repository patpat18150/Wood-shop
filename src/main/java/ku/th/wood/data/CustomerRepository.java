package ku.th.wood.data;

import ku.th.wood.model.Customer;
import ku.th.wood.model.Wood;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepository {
    private JdbcTemplate jdbcTemplate;
    public CustomerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
            String query = "SELECT * FROM customer";
            List<Customer> customers =  jdbcTemplate.query(query, new CustomerRowMapper());
            return  customers;
    }
    public void buyCalculator(String username, Double update){
        System.out.println("try to calculator");
        String query = "UPDATE customer SET balance = " + update + " WHERE username = '" + username + "'";
        jdbcTemplate.update(query);
        System.out.println("update balance success");
    }

    public Customer findByUsername( String username) {
        System.out.println(username);
        String query = "SELECT * FROM customer WHERE username = '" + username +"'";
        String update = "update customer set stat = 'online' where username = '" +username + "'";
        jdbcTemplate.update(update);
        Customer customer = jdbcTemplate.queryForObject(query, new CustomerRowMapper());
        return customer;
    }

    public void saveCustomer(Customer customer) {
        String query  = "INSERT INTO customer (username,pass,balance,fname,lname,address,phone,stat) VALUES (?,?,?,?,?,?,?,?)";
        Object[] data = {customer.getUsername(),customer.getPass(),0.0,customer.getFname(),customer.getLname(),customer.getAddress(),customer.getPhone(),"offline"};
        jdbcTemplate.update(query,data);
    }


    public void deleteByUsername(String type, String username) {
        String query  = "DELETE FROM customer WHERE username = " + username;
        jdbcTemplate.update(query);
    }
    public Customer isLogined(){
        String query ="SELECT * FROM customer WHERE stat = 'online'";
        Customer customer = jdbcTemplate.queryForObject(query,new CustomerRowMapper());
        return customer;
    }
    public void getOffline(String username){
        String query ="UPDATE customer SET stat ='offline' WHERE username ='" + username + "'";
        jdbcTemplate.update(query);
        System.out.println("logout success");
    }

    class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet resultSet, int i)
                throws SQLException {

            String username = resultSet.getString("username");
            String fname = resultSet.getString("fname");
            String pass = resultSet.getString("pass");
            String lname = resultSet.getString("lname");
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone");
            String stat = resultSet.getString("stat");
            Double balance = resultSet.getDouble("balance");
            Customer customer = new Customer(username,pass, fname,lname,address,phone,stat);
//            Customer customer = new Customer(username,pass, fname,lname,address,phone,stat,balance);
            customer.setBalance(balance);
            return customer;

        }
    }
}