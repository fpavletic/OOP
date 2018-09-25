package lab03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Statistics implements StudentProcessor {

    private Map<String, Integer> courseToPassCount;

    @Override
    public void start() {
        courseToPassCount = new HashMap<>();
    }

    @Override
    public void process(String student, Set<CourseResult> courses){
        for ( CourseResult course : courses ){
            if ( !course.isPassed() ){
                continue;
            }
            courseToPassCount.merge(course.getCourseName(), 1, (i, j) -> i+j);
        }
    }

    @Override
    public void finish() {
        System.out.println("Statistics for all seen courses");
        for(Map.Entry entry : courseToPassCount.entrySet() ){
            System.out.format("%-30s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
