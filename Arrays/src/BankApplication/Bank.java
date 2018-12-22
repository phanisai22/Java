package BankApplication;

import java.util.ArrayList; 

class Bank{

    private String name ;
    private ArrayList<Branch> branches ;


    public Bank(String name ) {
        this.name = name ;
        this.branches = new ArrayList<Branch>() ;
    }

    public boolean addBranch(String branchName ) {
        if(findBranch(branchName) == null) {
            this.branches.add( new Branch(branchName)) ;
            return true ;
        }

        return false ;
    }

    private Branch findBranch(String branchName){
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i) ;
            if(checkedBranch.getName().equals(branchName)){
                return checkedBranch ;
            }
        }
        return null ;
    }

    public boolean addCustomer(String branchName , String name , double intialAmount) {
        Branch branch =  findBranch(branchName) ;
        if (branch != null) {
            return branch.addCustomer(name, intialAmount) ;
        }

        return false ;
    }

    public boolean addCustomerTransaction(String branchName , String name , double amount){
        Branch branch = findBranch(branchName) ;
        if ( branch != null){
            return branch.addCustomerTransaction(name, amount) ;
        }

        return false ;
    }

    public boolean listCustomer(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName) ;
        if ( branch != null ) {
            System.out.println("Customer details for branch "+branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers() ;

            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer customer = branchCustomers.get(i) ;
                System.out.println("Customer : "+customer.getName()+" [ "+(i+1)+ " ]");
                if(showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions() ;
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[ "+(j+1)+" ] "+transactions.get(j));
                    }
                }
            }
            return true ;
        }

        return false ;
    }
}