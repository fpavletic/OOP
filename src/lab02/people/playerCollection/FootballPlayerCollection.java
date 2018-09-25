package lab02.people.playerCollection;

import lab02.people.FootballPlayer;

import java.util.Arrays;

public class FootballPlayerCollection implements IFootballPlayersCollection {

    private FootballPlayer[] players;
    private int size;

    public FootballPlayerCollection(int maxSize) {
        players = new FootballPlayer[maxSize];
    }

    @Override
    public boolean add(FootballPlayer player) {
        if ( players.length <= size ){
            return false;
        }

        if ( getIndex(player) != -1 ){
            return false;
        }

        for ( int i = players.length -1; i >= 0; i-- ){
            if ( players[i] == null ){
                players[i] = player;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(FootballPlayer player) {
        return getIndex(player) != -1;
    }

    @Override
    public boolean remove(FootballPlayer player) {
        int i = getIndex(player);

        if ( i == -1 ) {
            return false;
        }

        players[i] = null;
        size--;
        return true;
    }

    private int getIndex(FootballPlayer player){
        for ( int i = players.length -1; i >= 0; i-- ){
            if ( player.equals(players[i]) ){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        players = new FootballPlayer[players.length];
        size = 0;
    }

    @Override
    public FootballPlayer[] getPlayers() {
        return players;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getMaxSize() {
        return players.length;
    }

    @Override
    public int calculateEmotionSum() {
        int emotionSum = 0;
        for ( int i = players.length -1; i >= 0; i-- ){
            if ( players[i] != null ){
                emotionSum+=players[i].getEmotion();
            }
        }
        return emotionSum;
    }

    @Override
    public int calculateSkillSum() {
        int skillSum = 0;
        for ( int i = players.length -1; i >= 0; i-- ){
            if ( players[i] != null ){
                skillSum+=players[i].getEmotion();
            }
        }
        return skillSum;
    }
}
