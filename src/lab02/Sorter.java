package lab02;

import lab02.people.FootballPlayer;
import lab02.people.playerCollection.IFootballPlayersCollection;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter {

    public void sortBySkill (IFootballPlayersCollection players, boolean isAscending){
        Arrays.sort(players.getPlayers(), new SkillComparator( isAscending ));
    }

    public void sortByPosition (IFootballPlayersCollection players, boolean isAscending){
        Arrays.sort(players.getPlayers(), new PositionComparator(isAscending));
    }

    private class PositionComparator implements Comparator<FootballPlayer>{

        private boolean isAscending;

        public PositionComparator(boolean isAscending) {
            this.isAscending = isAscending;
        }

        @Override
        public int compare(FootballPlayer player1, FootballPlayer player2) {
            if ( player1 == null ){
                return isAscending ? -1 : 1;
            }
            if ( player2 == null ){
                return isAscending ? 1 : -1;
            }
            int result = Integer.compare(player1.getPlayingPosition().ordinal(), player2.getPlayingPosition().ordinal());
            if ( isAscending ){
                return result;
            }
            return -result;
        }
    }

    private class SkillComparator implements Comparator<FootballPlayer>{

        private boolean isAscending;

        public SkillComparator(boolean isAscending) {
            this.isAscending = isAscending;
        }

        @Override
        public int compare(FootballPlayer player1, FootballPlayer player2) {
            if ( player1 == null ){
                return isAscending ? -1 : 1;
            }
            if ( player2 == null ){
                return isAscending ? 1 : -1;
            }
            int result = Integer.compare(player1.getPlayingSkill(), player2.getPlayingSkill());
            if ( isAscending ){
                return result;
            }
            return -result;
        }
    }

}
