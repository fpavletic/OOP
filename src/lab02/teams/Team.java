package lab02.teams;

import lab02.*;
import lab02.matches.IMatchInspectableTeam;
import lab02.people.FootballPlayer;
import lab02.people.playerCollection.FootballPlayerCollection;
import lab02.people.playerCollection.IFootballPlayersCollection;

import java.util.Arrays;

public abstract class Team implements IManageableTeam {

    private String name = "TeamX";
    private Formation formation = Formation.F442;
    private IFootballPlayersCollection registeredPlayers;
    private IFootballPlayersCollection startingEleven = new FootballPlayerCollection(11);
    private int budget;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    protected Team(int maxRegisteredPlayerCount){
        registeredPlayers = new FootballPlayerCollection(maxRegisteredPlayerCount);
    }

    protected Team(String name, Formation formation, int maxRegisteredPlayerCount) {
        setName(name);
        setFormation(formation);
        registeredPlayers = new FootballPlayerCollection(maxRegisteredPlayerCount);
    }


    @Override
    public boolean addPlayerToStartingEleven(FootballPlayer player) {
        if ( !registeredPlayers.contains(player) ){
            return false;
        }
        return startingEleven.add(player);
    }
    @Override
    public void clearStartingEleven() {
        startingEleven.clear();
    }

    @Override
    public IFootballPlayersCollection getStartingEleven() {
        return startingEleven;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player){
        return registeredPlayers.add(player);
    }

    @Override
    public boolean isPlayerRegistered(FootballPlayer player) {
        return registeredPlayers.contains(player);
    }

    public boolean transfer(FootballPlayer player, Team futureTeam, int transferValue ){

        if ( futureTeam.getBudget() < transferValue ){
            System.err.println("Future team can't afford this transfer!");
            return false;
        }

        if ( futureTeam.getRegisteredPlayers().getMaxSize() == futureTeam.getRegisteredPlayers().size() ){
            System.err.println("Future team can't register any more players!");
            return false;
        }

        if ( !registeredPlayers.remove(player) ){
            System.err.println("Player is not registered with this team!");
            return false;
        }

        if ( !futureTeam.registeredPlayers.add(player) ){
            System.err.println("Unable to register player with future team!");
            registeredPlayers.add(player);
        }

        budget += transferValue;
        futureTeam.budget -= transferValue;

        return true;
    }

    @Override
    public IFootballPlayersCollection getRegisteredPlayers() {
        return registeredPlayers;
    }

    @Override
    public final void setFormation(Formation formation) {
        if ( formation == null ) {
            System.err.println("Formation must not be null, using default!");
            return;
        }
        this.formation = formation;
    }

    @Override
    public Formation getFormation() {
        return formation;
    }

    @Override
    public abstract double calculateRating();


    private final void setName(String name) {
        if ( name == null ){
            System.err.println("Name must not be null, using default!");
            return;
        }
        this.name = name;
    }

    public static void main(String[] args) {

        Team currentTeam = new ClubTeam("UEFAlona", Formation.F541, 0);
        Team futureTeam = new ClubTeam("Qatar Saint Germain", Formation.F541, 0);
        FootballPlayer notNeymar = new FootballPlayer("Meymar da Silva Santos", "Brazil", 0, 90, PlayingPosition.FW);
        currentTeam.transfer(notNeymar, futureTeam, 222000000); //player not registered with current team
        futureTeam.setBudget(300000000);
        currentTeam.transfer(notNeymar, futureTeam, 222000000); //future team doesnt have a large enough budget
        currentTeam.registerPlayer(notNeymar);
        for ( int i = 0; i < 25; i++ ){
            futureTeam.registerPlayer(new FootballPlayer(i + "", "France", 50, i, PlayingPosition.FW));
        }
        currentTeam.transfer(notNeymar, futureTeam, 222000000); //future team cant register any more players
        futureTeam.getRegisteredPlayers().clear();
        currentTeam.transfer(notNeymar, futureTeam, 222000000); //successful transfer

        for ( FootballPlayer player : futureTeam.getRegisteredPlayers().getPlayers()) { // proof
            if (player != null) {
                System.out.println(player);
            }
        }
    }

}
