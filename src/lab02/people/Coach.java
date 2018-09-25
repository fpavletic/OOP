package lab02.people;

import lab02.Formation;
import lab02.starting_eleven.ElevenPicker;
import lab02.teams.IManageableTeam;

public class Coach extends Person implements Manager {

    private int coachingSkill = 50;
    private Formation formation = Formation.F442;
    private IManageableTeam managingTeam;

    public Coach() {}

    public Coach(String name, String country, int emotion, int coachingSkill, Formation formation) {
        super(name, country, emotion);
        setCoachingSkill(coachingSkill);
        setFormation(formation);
    }

    public int getCoachingSkill() {
        return coachingSkill;
    }

    public final void setCoachingSkill(int coachingSkill) {
        if ( coachingSkill < 0 || coachingSkill > 100 ){
            System.err.println("Coaching skill must be between 0 and 100, value unchanged!");
            return;
        }
        this.coachingSkill = coachingSkill;
    }

    public Formation getFormation() {
        return formation;
    }

    public final void setFormation(Formation formation) {
        if ( formation == null ) {
            System.err.println("Formation must not be null, value unchanged!");
            return;
        }
        this.formation = formation;
    }


    @Override
    public void forceMyFormation() {
        managingTeam.setFormation(formation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Coach coach = (Coach) o;

        if (coachingSkill != coach.coachingSkill) return false;
        if (formation != coach.formation) return false;
        return managingTeam != null ? managingTeam.equals(coach.managingTeam) : coach.managingTeam == null;
    }

    @Override
    public int hashCode() {
        int result = coachingSkill;
        result = 31 * result + (formation != null ? formation.hashCode() : 0);
        result = 31 * result + (managingTeam != null ? managingTeam.hashCode() : 0);
        return result;
    }

    @Override
    public void pickStartingEleven(ElevenPicker picker) {
        picker.pickStartingEleven(managingTeam);
    }

    @Override
    public void setManagingTeam(IManageableTeam team) {
        if ( team == null ){
            System.err.println("Team must not be null, value unchanged");
            return;
        }
        managingTeam = team;
    }
}
