package IPlayer;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int health;
    private int hitPoints;

    public Monster(String name, int health, int hitPoints) {
        this.name = name;
        this.health = health;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", hitPoints=" + hitPoints +
                '}';
    }

    @Override
    public List<String> write() {

        List<String> values = new ArrayList<>();
        values.add(this.name);
        values.add("" + this.hitPoints);
        values.add("" + this.health);

        return values;

    }

    @Override
    public void read(List<String> saveValues) {
        if( saveValues != null && saveValues.size() > 0){
            this.name = saveValues.get(0) ;
            this.hitPoints = Integer.parseInt(saveValues.get(1)) ;
            this.health = Integer.parseInt(saveValues.get(2)) ;
        }
    }
}
