package lab02.people;

import lab02.PlayingPosition;

public class FootballPlayer extends Person{

    int playingSkill = 50;
    PlayingPosition playingPosition = PlayingPosition.MF;

    public FootballPlayer(String name, String country, int emotion, int playingSkill, PlayingPosition playingPosition) {
        super(name, country, emotion);
        setPlayingSkill(playingSkill);
        setPlayingPosition(playingPosition);
    }

    public int getPlayingSkill() {
        return playingSkill;
    }

    public final void setPlayingSkill(int playingSkill) {
        if ( playingSkill > 100 || playingSkill < 0 ){
            System.err.println("Playing skill must be between 0 and 100, value unchanged!");
            return;
        }
        this.playingSkill = playingSkill;
    }

    public PlayingPosition getPlayingPosition() {
        return playingPosition;
    }

    public final void setPlayingPosition(PlayingPosition playingPosition) {
        this.playingPosition = playingPosition;
    }

}
