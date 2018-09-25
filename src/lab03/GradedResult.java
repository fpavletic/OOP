package lab03;

public class GradedResult extends CourseResult {

    int grade = 0;

    public GradedResult(String courseName, int grade) {
        super(courseName, false);
        setGrade(grade);
    }

    public GradedResult(String courseName) {
        super(courseName, false);
    }

    public final void setGrade(int grade) {
        if ( grade < 1 || grade > 5 ){
            throw new IllegalArgumentException("Grade must be an integer between 1 and 5.");
        }
        this.grade = grade;
        setPassed(grade > 1);
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString(){
        return getCourseName() + ": " + (isPassed() ? grade : "Not passed yet");
    }
}
