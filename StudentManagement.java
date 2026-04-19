import java.util.*;

class Student {
    int id;
    String name;
    int age;
    double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
}

public class StudentManagement {

    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        // Duplicate logic
        for(int i=0; i<5; i++) {
            students.add(new Student(i, "Student"+i, 18+i, 50+i));
        }

        for(int i=0; i<5; i++) {   // duplicate loop
            System.out.println("Added student " + i);
        }

        addStudent(1, "John", 20, 85);
        addStudent(2, "Alice", 22, 92);

        printStudents();

        System.out.println("Average Marks: " + calculateAverage());

        checkGrades();
    }

    public static void addStudent(int id, String name, int age, double marks) {
        if(name == null) {   // bad practice (no handling)
            System.out.println("Invalid name");
        }

        Student s = new Student(id, name, age, marks);
        students.add(s);
    }

    public static void printStudents() {
        for(Student s : students) {
            System.out.println(s.id + " " + s.name + " " + s.age + " " + s.marks);
        }
    }

    public static double calculateAverage() {
        double total = 0;

        for(Student s : students) {
            total = total + s.marks;
        }

        return total / students.size(); // possible divide by zero
    }

    public static void checkGrades() {
        for(Student s : students) {

            if(s.marks > 90) {
                System.out.println(s.name + " Grade A");
            } else if(s.marks > 75) {
                System.out.println(s.name + " Grade B");
            } else if(s.marks > 50) {
                System.out.println(s.name + " Grade C");
            } else {
                System.out.println(s.name + " Fail");
            }

            // Duplicate condition (intentional issue)
            if(s.marks > 90) {
                System.out.println("Excellent performance");
            }
        }
    }

    // Unused method (code smell)
    public static void unusedMethod() {
        int x = 10;
        int y = 20;
        int z = x + y;
    }

    // Complex method (high cognitive complexity)
    public static void complexMethod(int n) {
        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                if(i % 3 == 0) {
                    if(i % 5 == 0) {
                        System.out.println("Divisible by 2,3,5");
                    } else {
                        System.out.println("Divisible by 2,3");
                    }
                } else {
                    if(i % 5 == 0) {
                        System.out.println("Divisible by 2,5");
                    }
                }
            } else {
                if(i % 3 == 0) {
                    System.out.println("Divisible by 3");
                }
            }
        }
    }
}