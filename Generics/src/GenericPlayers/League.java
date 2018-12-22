package GenericPlayers;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    public String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T team) {
        if (league.contains(team)) {
            System.out.println("League is already registered with "+team.getName()+" team .");
            return false;
        }

        this.league.add(team);
        return true;
    }

    public void showLeagueTable(){
        // Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getName() +" : "+ t.ranking());
        }
    }
}
