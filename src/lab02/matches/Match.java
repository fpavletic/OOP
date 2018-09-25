package lab02.matches;

import java.util.Random;

public class Match implements IPlayableMatch{

    private IMatchInspectableTeam home;
    private IMatchInspectableTeam away;
    private MatchType type;
    private MatchOutcome result = MatchOutcome.NOT_AVAILABLE;

    private static final Random RNG = new Random(System.nanoTime());

    public Match(IMatchInspectableTeam home, IMatchInspectableTeam away, MatchType type) {
        this.home = home;
        this.away = away;
        this.type = type;
    }

    public boolean isPlayable(){
        if ( home == null || away == null || type == null ){
            return false;
        }

        if ( type != MatchType.COMPETITIVE ){
            return true;
        }

        if ( home.getClass().equals(away.getClass())){
            return true;
        }

        return false;
    }

    public void play(){

        double randomNumber = RNG.nextDouble();
        double totalRating = home.calculateRating() + away.calculateRating();
        double h = home.calculateRating() / totalRating;
        double a = 1 - h;
        double min = Math.min(h, a);

        result = randomNumber < h - min/2 ? MatchOutcome.AWAY_WIN :
                randomNumber > h + min/2 ? MatchOutcome.HOME_WIN : MatchOutcome.DRAW;

    }

    @Override
    public MatchOutcome getOutcome() {
        return result;
    }


}
