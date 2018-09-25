package lab02.people.playerCollection;

import lab02.people.FootballPlayer;

public interface IFootballPlayersCollection {

    boolean add(FootballPlayer player);

    int calculateEmotionSum();

    int calculateSkillSum();

    void clear();

    boolean contains(FootballPlayer player);

    int getMaxSize();

    FootballPlayer[] getPlayers();

    int size();

    boolean remove(FootballPlayer player);


}
