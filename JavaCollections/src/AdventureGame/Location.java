package AdventureGame;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationId;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationId, String description) {
        this.locationId = locationId;
        this.description = description;
        this.exits = new HashMap<>();
        this.exits.put("QUIT", 0);
    }

    public int getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
//        This returns a new HashMap so that the outside class cannot
//        change the values. If did changes, they will be applied to the
//        local Map and will not effect the main "exits" Map.
    }

    public boolean addExit(String direction, int location) {
        exits.put(direction, location);
        return true;
    }

}
