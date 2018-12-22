package GenericPlayers;

public class Main {

    public static void main(String[] args) {

//        League<Team> footballLeague = new League<>("IPL");
//        This is a raw type which even allows base ball team to football league .

        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
        Team<FootballPlayer> adeliteCrows = new Team<>("Adelite crows");
        Team<FootballPlayer> melbrone = new Team<>("Melbrone");
        Team<FootballPlayer> howthorn = new Team<>("Howthorn");
        Team<FootballPlayer> fermantle = new Team<>("Fermantle");
//        Team<BaseballPlayer> baseballTeam = new Team<>("Base Ball FUCKERS");

        footballLeague.addTeam(adeliteCrows);
        footballLeague.addTeam(adeliteCrows);
        footballLeague.addTeam(melbrone);
        footballLeague.addTeam(howthorn);
        footballLeague.addTeam(fermantle);
//        footballLeague.addTeam(baseballTeam);

        adeliteCrows.matchResult(melbrone, 3, 1);
        footballLeague.showLeagueTable();


    }
}
