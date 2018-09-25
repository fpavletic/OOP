package lab03;

public class DescriptiveResult extends CourseResult {

    private String passComment;

    public DescriptiveResult(String courseName, String passComment) {
        super(courseName, true);
        this.passComment = passComment;
    }

    public DescriptiveResult(String courseName) {
        super(courseName, false);
    }

    public void setPassComment(String passComment) {
        this.passComment = passComment;
        setPassed(passComment != null);
    }

    public String getPassComment() {
        return passComment;
    }

    @Override
    public String toString() {
        return getCourseName() + ": " + (isPassed() ? passComment : "Not passed yet");
    }
}
