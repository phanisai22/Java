package OOPSChallenge ;

class DeluxBurger extends Humburger{

    public DeluxBurger() {
        super("Delux", "sausage & bacon", 14.23, "white") ;
        super.addHamburgerAddition1("chips", 2.02);
        super.addHamburgerAddition2("drinks", 3.22);
    }


}