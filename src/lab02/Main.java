package lab02;

import lab02.matches.IPlayableMatch;
import lab02.matches.Match;
import lab02.matches.MatchType;
import lab02.people.Coach;
import lab02.people.FootballPlayer;
import lab02.starting_eleven.DontCarePicker;
import lab02.starting_eleven.ElevenPicker;
import lab02.starting_eleven.StandardPicker;
import lab02.teams.IManageableTeam;
import lab02.teams.NationalTeam;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rng = new Random(System.nanoTime());
        IManageableTeam home = new NationalTeam("Liberland", Formation.F442, "Liberland");
        //IManageableTeam away = new NationalTeam("Sealand", Formation.F442, "Sealand");

        for (int i = 0; i < 20; i++) {
            home.registerPlayer(new FootballPlayer(i+"", "Liberland", (int)(100 * rng.nextDouble()), (int)(100 * rng.nextDouble()), PlayingPosition.values()[rng.nextInt(4)]));
            //away.registerPlayer(new FootballPlayer(i+"", "Sealand", (int)(100 * rng.nextDouble()), (int)(100 * rng.nextDouble()), PlayingPosition.FW));
        }

        ElevenPicker picker = new StandardPicker();
        Coach coach = new Coach();
        coach.setManagingTeam(home);
        coach.pickStartingEleven(picker);
        new Sorter().sortByPosition(home.getStartingEleven(), false);
        for ( FootballPlayer player : home.getStartingEleven().getPlayers() ){
            System.out.print(player + ", ");
        }
        System.out.println();

        picker = new DontCarePicker();
        coach.setManagingTeam(home);
        coach.pickStartingEleven(picker);
        new Sorter().sortByPosition(home.getStartingEleven(), false);
        for ( FootballPlayer player : home.getStartingEleven().getPlayers() ){
            System.out.print(player + ", ");
        }
        System.out.println();

        //IPlayableMatch match = new Match(home, away, MatchType.COMPETITIVE);

    }
}
