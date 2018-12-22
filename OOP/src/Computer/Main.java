package Computer ;

class Main{
    public static void main(String[] args) {
        
        Dimensions dimensions = new Dimensions(20 , 20 , 5) ;
        MotherBoard motherBoard = new MotherBoard("BJ-200", "Asus", 4, 6, "2.0v") ;
        Monitor monitor = new Monitor("27InchBeast","Acer", 27,  new Resolution(1200, 1440)) ;
        Case theCase = new Case("220B", "Dell", "240v", dimensions) ;

        PC myPc = new PC(theCase, monitor, motherBoard) ;
        myPc.getTheCase().pressPowerButton();
        myPc.getMotherBoard().loadProgram("vsCode");
        myPc.getMonitor().drawPixelAt(1500, 1200, "red");

    }
}