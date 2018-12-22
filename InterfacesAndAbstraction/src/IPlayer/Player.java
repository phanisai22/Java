package IPlayer;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int hitPoints;
    private int health;
    private String weapon;

    public Player(String name, int hitPoints, int health) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.health = health;
        this.weapon = "sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", health=" + health +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {

        List<String> values = new ArrayList<>();
        values.add(this.name);
        values.add("" + this.hitPoints);
        values.add("" + this.health);
        values.add(this.weapon);

        return values;

    }

    @Override
    public void read(List<String> saveValues) {
        if( saveValues != null && saveValues.size() > 0){
            this.name = saveValues.get(0) ;
            this.hitPoints = Integer.parseInt(saveValues.get(1)) ;
            this.health = Integer.parseInt(saveValues.get(2)) ;
            this.weapon = saveValues.get(3) ;
        }
    }
}
