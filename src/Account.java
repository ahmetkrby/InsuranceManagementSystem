import java.util.List;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {
    private User user;
    private Boolean authenticationStatus;
    private List<Insurance> insurances;
    private int type;
    private AuthenticationStatus status;


    public Account(User user, Boolean authenticationStatus, List<Insurance> insurances, int type, AuthenticationStatus status) {
        this.user = user;
        this.authenticationStatus = authenticationStatus;
        this.insurances = insurances;
        this.type = type;
        this.status = status;
    }

    final void showUserInfo () {
            System.out.println("HESAP BILGILERI : \nName : "+user.getName()+"\nSurname : "+user.getLastName()+"\nE-mail : "+user.getEmail()+"\nJob : "+user.getJob()+"\nAge : " + user.getAge()+"\nLast Activate Date : "+user.getLastLoginDate());

        }

        public void login(String email, String password) throws InvalidAuthenticationException {
            if (!email.equals(user.getEmail()) || !password.equals(user.getPassword())) {
               status = AuthenticationStatus.FAIL;
               throw new InvalidAuthenticationException("Password or email invalid");
            } else{
                status = AuthenticationStatus.SUCCESS;
                user.setLastLogin();

            }
        }

        public abstract void addAddress(Address address);
        public abstract void removeAddress(Address address);
        public abstract void addInsurance(Insurance insurance);
        public boolean isLogin() {
            return status == AuthenticationStatus.SUCCESS;
        }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(Boolean authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    @Override
    public int compareTo(Account o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public int hashCode(){
        return Objects.hash(user);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass() ) return false;
        Account account = (Account) obj;
        return Objects.equals(user, account.user);
    }
}
