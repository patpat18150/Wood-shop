package ku.th.wood.model;
public class Customer {
    private String username;
    private String pass;
    private double balance;
    private String address;
    private String phone; // email or phone number
    private String fname;
    private String lname;
    private String stat;


    public Customer(String username, String pass,String fname, String lname, String address, String phone,String stat) {
        this.username = username;
        this.pass =pass;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.stat = stat;
    }
    public  String getStat(){
        return this.stat;
    }
    public void setStat(String stat){
        this.stat = stat;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setTell(String tell) {
        this.phone = phone;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
