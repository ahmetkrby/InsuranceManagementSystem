import java.util.List;

public class Enterprise extends Account{
    public Enterprise(User user, Boolean authenticationStatus, List<Insurance> insurances, int type, AuthenticationStatus status) {
        super(user, authenticationStatus, insurances, type, status);
    }

    @Override
    public void addAddress(Address address) {
        this.getUser().getAddressList().add(address);

    }

    @Override
    public void removeAddress(Address address) {
     this.getUser().getAddressList().remove(address);
    }

    @Override
    public void addInsurance(Insurance insurance) {

        this.getUser().getInsurances().add(insurance);
    }

    @Override
    public int compareTo(Account o) {
        return 0;
    }
}
