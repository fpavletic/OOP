package lab02.people;

import lab02.starting_eleven.ElevenPicker;
import lab02.teams.IManageableTeam;

public interface Manager {

    void forceMyFormation();
    void pickStartingEleven(ElevenPicker picker);
    void setManagingTeam(IManageableTeam team);

}
