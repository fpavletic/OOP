package lab03;

import java.util.Set;

public interface StudentProcessor {

    void start();
    void process(String student, Set<CourseResult> courses);
    void finish();
}
