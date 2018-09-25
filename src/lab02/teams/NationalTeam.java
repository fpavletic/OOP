package lab02.teams;

import lab02.people.FootballPlayer;
import lab02.Formation;

public class NationalTeam extends Team {
    private String country = "Noland";

    public NationalTeam() {
        super(23);
    }

    public NationalTeam(String name, Formation formation, String country) {
        super(name, formation, 23);
        setCountry(country);
    }

    public final void setCountry(String country) {
        if ( country == null ){
            System.err.println("Country must not be null, using default!");
            return;
        }
        this.country = country;
    }

    @Override
    public double calculateRating() {
        return getRegisteredPlayers().calculateSkillSum() * 0.3 +
                getRegisteredPlayers().calculateEmotionSum() * 0.7;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player) {
        if (!player.getCountry().equals(country)){
            return false;
        }
        return super.registerPlayer(player);
    }
}
