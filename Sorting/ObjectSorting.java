import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
  * ObjectSorting
  */
 public class ObjectSorting {
 
     public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Alan", 90.18));
        students.add(new Student("Alam", 90.18));
        students.add(new Student("clan", 98.18));
        students.add(new Student("milan", 89.1));
        students.add(new Student("pilan", 91.18));
     
        Comparator<Student> studentCmp = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if( s1.getScore() != s2.getScore()){
                    return Double.compare(s2.getScore(), s1.getScore());
                }
                return s1.getName().compareTo(s2.getName());
            }
        };

        System.out.println("Before Sorting");
        for (Student s : students) {
            System.out.println(s.getName()+" : "+s.getScore());
        }

        Collections.sort(students, studentCmp);

        System.out.println("\nAfter Sorting");
        for (Student s : students) {
            System.out.println(s.getName()+" : "+s.getScore());
        }

     }
 }
 /**
  * Student
  */
 class Student {
 
    double score;
    String name;
     
    Student(String name, double score){
        this.name = name;
        this.score = score;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

 }