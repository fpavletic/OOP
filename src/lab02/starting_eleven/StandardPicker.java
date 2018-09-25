package lab02.starting_eleven;

import lab02.people.FootballPlayer;
import lab02.teams.IManageableTeam;

public class StandardPicker implements ElevenPicker {

    @Override
    public void pickStartingEleven(IManageableTeam team) {
        team.clearStartingEleven();
        int[] counts = new int[4];
        for ( FootballPlayer player : team.getRegisteredPlayers().getPlayers() ){
            if ( player == null ){
                continue;
            }
            int index = player.getPlayingPosition().ordinal();
            if ( counts[index] < team.getFormation().getCount(player.getPlayingPosition())){
                counts[index]++;
                if (!team.addPlayerToStartingEleven(player)){
                    break;
                }
            }
        }
    }
}
