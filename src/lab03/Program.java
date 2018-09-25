package lab03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		HashMap<String, Set<CourseResult>> studentsGrades =  new HashMap<>();
		studentsGrades.put("Pliva�ica",  new HashSet<CourseResult>(Arrays.asList(
				new DescriptiveResult("Tjelesni 1", "Polo�eno plivanjem za Fakultet")
				, new GradedResult("Matematika 1", 4)
				, new DescriptiveResult("Tjelesni 2", "Polo�eno plivanjem za Fakultet")
				, new DescriptiveResult("Tjelesni 3")
				, new GradedResult("Matematika 2", 5)
				, new GradedResult("OOP", 5)
				, new GradedResult("VJEKO", 3)				
				)));

		studentsGrades.put("Nijemi Matemati�ar",  new HashSet<CourseResult>(Arrays.asList(
				new DescriptiveResult("Tjelesni 1", "Polo�eno dolascima u dvoranu")
				, new DescriptiveResult("Tjelesni 2", "Polo�eno dolascima u dvoranu")
				, new DescriptiveResult("Tjelesni 3", "Polo�eno dolascima u dvoranu")
				, new GradedResult("Matematika 1", 5)
				, new GradedResult("Matematika 2", 5)
				, new GradedResult("OOP")
				)));

		studentsGrades.put("Ciceron",  new HashSet<CourseResult>(Arrays.asList(
				new DescriptiveResult("Tjelesni 1")
				, new DescriptiveResult("Tjelesni 2")
				, new GradedResult("Matematika 1", 3)
				, new GradedResult("Matematika 2", 2)
				, new GradedResult("OOP")
				, new GradedResult("VJEKO", 5)
				)));

		studentsGrades.put("Steve Irwin",  new HashSet<CourseResult>(Arrays.asList(
				new DescriptiveResult("Tjelesni 1", "Polo�eno odlascima na Sljeme")
				, new DescriptiveResult("Tjelesni 2", "Polo�eno odlascima na Sljeme")
				, new DescriptiveResult("Tjelesni 3", "Polo�eno odlascima na Sljeme")
				, new GradedResult("Matematika 1")
				, new GradedResult("Matematika 2")
				, new GradedResult("OOP")
				, new GradedResult("VJEKO", 3)				
				)));
		
		studentsGrades.put("John Olliver",  new HashSet<CourseResult>(Arrays.asList(
				new DescriptiveResult("Tjelesni 1")
				, new DescriptiveResult("Tjelesni 2")
				, new GradedResult("Matematika 1")
				, new GradedResult("Matematika 2")
				, new GradedResult("OOP")
				, new GradedResult("VJEKO", 5)				
				)));
		try {
		studentsGrades.put("Stephen Hawking", new HashSet<CourseResult>(Arrays.asList(
				new GradedResult("Physcs 1", 6)
				, new GradedResult("Physics 2", 6)
				, new GradedResult("Physics 3", 6)
				, new GradedResult("Matematika X", 6)
				)));
		}
		catch(Exception e) { 
			System.err.println("Nice try with the 6...");
		}

		StudentProcessor[] processors = new StudentProcessor[] {
				new Printer()
				, new Statistics()
		};
		for(StudentProcessor p : processors) { p.start(); }
		for(String s : studentsGrades.keySet()) { 
			for(StudentProcessor p : processors) { 
				p.process(s,  studentsGrades.get(s));
			}
		}
		for(StudentProcessor p : processors) { p.finish(); }
	}
/*
 * 
Expected output on System.out is something like:

Students' grades:
************************************************************

Nijemi Matemati�ar
----------------------------------------
Matematika 2: 5
OOP: Not passed yet
Tjelesni 3: Polo�eno dolascima u dvoranu
Tjelesni 2: Polo�eno dolascima u dvoranu
Matematika 1: 5
Tjelesni 1: Polo�eno dolascima u dvoranu

Steve Irwin
----------------------------------------
Tjelesni 2: Polo�eno odlascima na Sljeme
Matematika 2: Not passed yet
VJEKO: 3
Matematika 1: Not passed yet
OOP: Not passed yet
Tjelesni 1: Polo�eno odlascima na Sljeme
Tjelesni 3: Polo�eno odlascima na Sljeme

John Olliver
----------------------------------------
Tjelesni 2: Not passed yet
VJEKO: 5
OOP: Not passed yet
Matematika 2: Not passed yet
Matematika 1: Not passed yet
Tjelesni 1: Not passed yet

Ciceron
----------------------------------------
VJEKO: 5
Tjelesni 2: Not passed yet
Tjelesni 1: Not passed yet
OOP: Not passed yet
Matematika 1: 3
Matematika 2: 2

Pliva�ica
----------------------------------------
Tjelesni 2: Polo�eno plivanjem za Fakultet
OOP: 5
VJEKO: 3
Matematika 2: 5
Tjelesni 1: Polo�eno plivanjem za Fakultet
Matematika 1: 4
Tjelesni 3: Not passed yet

************************************************************
Done printing students' grades


Statistics for all seen courses:

Tjelesni 2                    : Passed: 3 out of 5
Matematika 1                  : Passed: 3 out of 5
OOP                           : Passed: 1 out of 5
Tjelesni 3                    : Passed: 2 out of 3
Matematika 2                  : Passed: 3 out of 5
VJEKO                         : Passed: 4 out of 4
Tjelesni 1                    : Passed: 3 out of 5


 *
 *
 *
 */
}
