package lab02.starting_eleven;

import lab02.people.FootballPlayer;
import lab02.teams.IManageableTeam;

public class DontCarePicker implements ElevenPicker {

    @Override
    public void pickStartingEleven(IManageableTeam team) {
        team.clearStartingEleven();
        for (FootballPlayer player : team.getRegisteredPlayers().getPlayers() ){
            if (player == null){
                continue;
            }
            if(!team.addPlayerToStartingEleven(player)){
                break;
            }
        }
    }
}
