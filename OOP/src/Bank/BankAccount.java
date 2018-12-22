package Bank;

class BankAccount{
    private int balance = 0 ;
    private String name ;
    private String phoneNumber ;
    // private String email ;
    // private int accontNumber ;

    public void setbalance(int balance){
        this.balance = balance ;
    }

    public int getbalance(){
        return this.balance ;
    }

    public void setname(String name){
        this.name = name ;
    }

    public String getname(){
        return this.name ;
    }

    public void setphoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber ;
    }

    public String getphoneNumber(){
        return this.phoneNumber ;
    }

    public void deposite(int amount ){
        this.balance+= amount ;
        System.out.println("amount deposited");
    }

    public void withDraw(int amount){
        if(this.balance - amount < 0)
            System.out.println("withdrawl unsuccessful. Less amount .");
        else{
            System.out.println("withdrawl successful .");
            this.balance -= amount ;
        }

    }
}