package InheritanceChallenge;

class Vehicle {
    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size){
        this.name = name ;
        this.size = size ;
        this.currentDirection = 0 ;
        this.currentVelocity = 0 ;
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("vehicle.steer() : Steering at " + this.currentDirection + " degrees.");
    }

    public void move(int velocity, int direction) {
        this.currentVelocity = velocity;
        this.currentDirection = direction;
        System.out.println("vehicle.move() : vechile is moving in " + this.currentDirection + " degrees at "
                + this.currentVelocity+" KMPH");

    }

    public String getName() {
        return this.name;
    }

    public String getSize() {
        return this.size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void stop(){
        this.currentVelocity = 0 ;
    }
}
