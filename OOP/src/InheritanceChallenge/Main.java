package InheritanceChallenge ;

class Main{
    public static void main(String[] args) {
        OutLander car = new OutLander(22) ;
        car.steer(22);
        car.accelarate(30);
        car.accelarate(20);
        car.accelarate(-42);
    }
}