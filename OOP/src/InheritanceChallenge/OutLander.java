package InheritanceChallenge;

class OutLander extends Car {
    private int roadServiceMonths;

    public OutLander(int roadServiceMonths) {
        super("outlanger", "4WD", 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelarate(int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity <= 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        }else if(newVelocity <= 20){
            changeGear(2);
        }else if(newVelocity <= 30){
            changeGear(3);
        }else{
            changeGear(4);
        }
        
        if(newVelocity > 0){
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
    
}