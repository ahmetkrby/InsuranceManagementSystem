import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> accounts;
    User currentUser;
    Account account;
    AccountManager(){
        accounts = new TreeSet<>();
        run();
    }

    public void run(){
        Scanner scn = new Scanner(System.in);
        String choice = "GO";
        while(!choice.equals("3")){
            System.out.println("1-) Create an Account");
            System.out.println("2-) Login to Account");
            System.out.println("3-) Quit");
            System.out.println("4-) Admin Login");
            System.out.print("Choice : ");
            choice = scn.nextLine();

            if(choice.equals("1"))
                createAccount();

            else if(choice.equals("2")){
                System.out.print("Enter email : ");
                String email = scn.nextLine();
                System.out.print("Enter password : ");
                String password = scn.nextLine();

                login(email, password);
            }
            else if(choice.equals("4")){
                System.out.println("Printing all accounts and passwords in the system ...");
                for(Account a : getAccounts())
                    System.out.println("Email : "+ a.getUser().getEmail() + " Password : " + a.getUser().getPassword());

                System.out.println("Printing all InsuranceList in the system ...");
                for(Insurance a : currentUser.getInsurances())
                    System.out.println("Customer name : "+a.getInsuranceName()+" Insurance Name : "+a.getInsuranceName() + " Total Price : " + a.getInsurancePrice()+"\n");

            }
        }

    }

    public void createAccount(){
        Scanner scn = new Scanner(System.in);

        String name, surname, email, password, job, age;
        System.out.print("Enter name : "); name = scn.nextLine();
        System.out.print("Enter surname : "); surname = scn.nextLine();
        System.out.print("Enter email : "); email = scn.nextLine();
        System.out.print("Enter password : "); password = scn.nextLine();
        System.out.print("Enter job : "); job = scn.nextLine();
        System.out.print("Enter age : "); age = scn.nextLine();
        User user = new User(name, surname, email, password, job, age);

        System.out.println("Are you individual (1 for yes 0 for no) : ");
        name = scn.nextLine();
        Account prop;
        if(name.equals("1")){
            prop = new Individual(user, account.isLogin(), null, 1,account.getStatus());
        }
        else{
            prop = new Enterprise(user, account.isLogin(), null,0,account.getStatus());
        }
        accounts.add(prop);
    }

    public void login(String email, String password){
        for (Account account : accounts){
            try {
                account.login(email, password);
                if (account.isLogin()){
                    currentUser = account.getUser();
                    this.account = account;
                    // 1 => enterprise 0 => individual
                    if (account.getType() == 1)
                        individualUserProcess();
                    else
                        individualUserProcess();// what is difference ? enterpriseUserProcess();

                    break;
                }
            } catch (InvalidAuthenticationException e) {
                //System.out.println(e);
            }
        }

    }

    public void individualUserProcess(){
        System.out.println("Welcome Mr. " + currentUser.getName());
        String choice = "1";
        while(!choice.equals("q")){
            Scanner scn = new Scanner(System.in);

            System.out.println("\n1-) Show my infos");
            System.out.println("2-) Get Insurance");
            System.out.println("3-) Show Insurance List");
            System.out.println("4-) Add Address");
            System.out.println("5-) Show All Address");
            choice = scn.nextLine();



            }
        }

    public void enterpriseUserProcess(){

    }
    public TreeSet<Account> getAccounts(){
        return accounts;
    }
}
