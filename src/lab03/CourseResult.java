package lab03;

public abstract class CourseResult {

    private String courseName;
    private boolean passed;

    public CourseResult(String courseName, boolean passed) {
        this.courseName = courseName;
        this.passed = passed;
    }

    public void setPassed(boolean value){
        passed = value;
    }

    public boolean isPassed(){
        return passed;
    }
    public String getCourseName(){
        return courseName;
    }

}
