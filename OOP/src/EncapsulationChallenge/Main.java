package EncapsulationChallenge ;

class Main{
    public static void main(String[] args) {
        Printer printer = new Printer(50, true) ;
        System.out.println("Intial page count is "+printer.getPagesPrinted());

        int pagesPrinted = printer.printPages(10) ;
        System.out.println("new pages printed was "+pagesPrinted+" and total pages printed are "+printer.getPagesPrinted());
        pagesPrinted = printer.printPages(50) ;
        System.out.println("new pages printed was "+pagesPrinted+" and total pages printed are "+printer.getPagesPrinted());

    }
}