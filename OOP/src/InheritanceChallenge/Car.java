package InheritanceChallenge;

class Car extends Vehicle {
    private int wheels;
    private int doors;
    private int gears;

    private int currentGear;
    private boolean isManual;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);

        this.wheels = wheels;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
        this.doors = doors;
    }

    public void changeGear(int gear) {
        // if (gear <= this.gears && isManual)
            this.currentGear = gear;
        // else if(!isManual)
            
        // else
            // this.currentGear = this.gears;

        System.out.println("car.changeGear(): Gear changed to " + this.currentGear);
    }

    public void changeVelocity(int speed , int direction){
        System.out.println("Car.changeVelocity(): velocity "+speed+" ; direction "+direction);
        super.move(speed, direction);
    }

    // @Override
    // public void stop(){
    //     super.stop();
    //     currentGear = 0 ;
    // }
}