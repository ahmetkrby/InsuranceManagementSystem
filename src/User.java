import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String lastName;
    String email;
    String password;
    String job;
    String age;
    ArrayList<Address> adresses;
    ArrayList<Insurance> insurances;
    LocalDate lastLoginDate;

    public User(String name, String lastName, String email, String password, String job, String age) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
        this.adresses = adresses;
        this.lastLoginDate = lastLoginDate;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String  getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Address> getAdresses() {
        return adresses;
    }

    public void setAdresses(ArrayList<Address> adresses) {
        this.adresses = adresses;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setLastLogin() {
        lastLoginDate = LocalDate.now();
    }

    public ArrayList<Address> getAddressList() {
        return adresses;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

}
