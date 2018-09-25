package lab02.matches;

public interface IPlayableMatch {

    boolean isPlayable();

    void play();

    MatchOutcome getOutcome();
}
