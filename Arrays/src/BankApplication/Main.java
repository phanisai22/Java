package BankApplication;

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("State bank of hyderabad");
        bank.addBranch("Ghatkesar");
        bank.addCustomer("Ghatkesar", "phani sai", 22);
        bank.addCustomer("Ghatkesar", "pSquare", 23);
        bank.addCustomer("Ghatkesar", "sree hari ", 45);

        bank.addBranch("Guntur");
        bank.addCustomer("Guntur", "sivaranjani", 99.99);

        bank.addCustomerTransaction("Ghatkesar", "phani sai", -1);
        bank.addCustomerTransaction("Ghatkesar", "phani sai", 123);
        bank.addCustomerTransaction("Ghatkesar", "phani sai", 67);
        bank.addCustomerTransaction("Ghatkesar", "pallavi", 5667.65);

        bank.listCustomer("Ghatkesar", true);
    }
}