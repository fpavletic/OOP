package lab02.teams;

import lab02.Formation;
import lab02.matches.IMatchInspectableTeam;
import lab02.people.playerCollection.IFootballPlayersCollection;
import lab02.people.FootballPlayer;

public interface IManageableTeam extends IMatchInspectableTeam{

    boolean addPlayerToStartingEleven(FootballPlayer player);

    void clearStartingEleven();

    IFootballPlayersCollection getStartingEleven();

    boolean registerPlayer(FootballPlayer player);

    boolean isPlayerRegistered(FootballPlayer player);

    IFootballPlayersCollection getRegisteredPlayers();

    void setFormation(Formation formation);

    Formation getFormation();

}
