package lab02.teams;

import lab02.people.FootballPlayer;
import lab02.Formation;

public class ClubTeam extends Team {

    private int reputation = 50;

    public ClubTeam() {
        super(25);
        System.out.println(this.getClass().getName());
    }

    public ClubTeam(String name, Formation formation, int reputation) {
        super(name, formation, 25);
        setReputation(reputation);
    }

    public final void setReputation(int reputation) {
        if ( reputation < 0 || reputation > 100 ){
            System.err.println("Reputation must be between 0 and 100, value unchanged!");
            return;
        }

        this.reputation = reputation;
    }

    @Override
    public double calculateRating() {
        return 0;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player) {
        if ( player.getPlayingSkill() < reputation ){
            return false;
        }
        return super.registerPlayer(player);
    }
}
