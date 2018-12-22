package OOPSChallenge;

class Main {
    public static void main(String[] args) {

        Humburger hamburger = new Humburger("basic", "sausage", 3.56, "white");
        double price = hamburger.itemisedHamberger();

        hamburger.addHamburgerAddition1("tomato", 0.27);
        hamburger.addHamburgerAddition2("lettuce", 0.22);
        hamburger.addHamburgerAddition3("cheese", 0.45);
        System.out.println("the total price is "+hamburger.itemisedHamberger());

        System.out.println();
        HealthyBurgur healthyBurgur = new HealthyBurgur("bacon", 5.23) ;
        healthyBurgur.addHamburgerAddition1("egg", 0.22);
        healthyBurgur.addHealthyAddition1("lentils", 2.9);
        System.out.println("total healthy burger price is "+healthyBurgur.itemisedHamberger()) ;

        System.out.println();
        DeluxBurger deluxBurger = new DeluxBurger() ;
        deluxBurger.itemisedHamberger() ;
    }
}