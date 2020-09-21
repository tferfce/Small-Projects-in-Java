public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");
        bank.addBranch("Adelaide");
        bank.addCustomer("Adelaide","Thomas",50.05);
        bank.addCustomer("Adelaide","Mike",175.34);
        bank.addCustomer("Adelaide","Giorgi",200.20);
        System.out.println("================");
        bank.listCustomers("Adelaide",true);
        bank.addBranch("Sydney");
        bank.addCustomer("Sydney","Bob",150.04);
        bank.addCustomer("Sydney","Tomoglou",50.23);
        System.out.println("================");
        bank.listCustomers("Sydney",true);

    }
}
