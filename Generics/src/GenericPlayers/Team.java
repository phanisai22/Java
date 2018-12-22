package GenericPlayers;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {

    private String name;
    private int won;
    private int lost;
    private int played;
    private int tied;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team " + this.name);
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " is is picked for this team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;

        if (ourScore > theirScore) {
            message = " beat ";
            won++;
        } else if (ourScore == theirScore) {
            message = " drew with ";
            tied++;
        } else {
            message = " lost to ";
            lost++;
        }
        played++;

        if (opponent != null) {
            System.out.println(this.name +message+opponent.getName());
            matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(team.ranking() > this.ranking()) {
            return 1;
        } else if (team.ranking() < this.ranking()) {
            return -1;
        } else {
            return 0;
        }
    }
}
