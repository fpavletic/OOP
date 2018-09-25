package lab03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Printer implements StudentProcessor {

    private Map<String, Set<CourseResult>> studentToCourses;

    @Override
    public void start() {
        studentToCourses = new HashMap<>();
    }

    @Override
    public void process(String student, Set<CourseResult> courses) {
        studentToCourses.put(student, courses);
    }

    @Override
    public void finish() {
        for (Map.Entry<String, Set<CourseResult>> student : studentToCourses.entrySet() ){

            System.out.println(student.getKey());
            System.out.println("----------------------------------------");
            for ( CourseResult course : student.getValue() ){
                System.out.println(course.toString());
            }
            System.out.println();
        }
        System.out.println("************************************************************\nDone printing students' grades\n");
    }
}
