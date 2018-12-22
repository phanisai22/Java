package OOPSChallenge;

class Humburger {

    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1price;

    private String addition2Name;
    private double addition2price;

    private String addition3Name;
    private double addition3price;

    private String addition4Name;
    private double addition4price;

    public Humburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String name, double price) {
        this.addition1Name = name;
        this.addition1price = price;
    }

    public void addHamburgerAddition2(String name, double price) {
        this.addition2Name = name;
        this.addition2price = price;
    }

    public void addHamburgerAddition3(String name, double price) {
        this.addition3Name = name;
        this.addition3price = price;
    }

    public void addHamburgerAddition4(String name, double price) {
        this.addition4Name = name;
        this.addition4price = price;
    }

    public double itemisedHamberger() {
        double hambergurPrice = this.price;
        System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll with "+this.meat+" is " + this.price+" $");

        if (this.addition1Name != null) {
            hambergurPrice += this.addition1price;
            System.out.println("Added " + this.addition1Name + " for an extra " + this.addition1price);
        }

        if (this.addition2Name != null) {
            hambergurPrice += this.addition2price;
            System.out.println("Added " + this.addition2Name + " for an extra " + this.addition2price);
        }

        if (this.addition3Name != null) {
            hambergurPrice += this.addition3price;
            System.out.println("Added " + this.addition3Name + " for an extra " + this.addition3price);
        }

        if (this.addition4Name != null) {
            hambergurPrice += this.addition4price;
            System.out.println("Added " + this.addition4Name + " for an extra " + this.addition4price);
        }

        return hambergurPrice;
    }
}