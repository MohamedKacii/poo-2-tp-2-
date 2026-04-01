import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Exercise1 {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(3, "mou7", "kaci"));
        studentList.add(new Student(1, "riyad", "guerni"));
        studentList.add(new Student(2, "ali", "chway"));

        studentList.add(new Student(3, "mou7", "kaci"));
        studentList.add(new Student(1, "riyad", "guerni"));

        for (Student student : studentList) {
            System.out.println(student);
        }

        int Id = 2;
        Student foundStudent = findStudentById(studentList, targetId);

        if (foundStudent != null) {
            System.out.println("Found student (ID " + targetId + ") : " + foundStudent);
        } else {
            System.out.println("No student found with ID " + targetId);
        }

        Set<Student> studentSet = new HashSet<>(studentList);
        for (Student student : studentSet) {
            System.out.println(student);
        }

        System.out.println("Size of List (duplicates) : " + studentList.size());
        System.out.println("Size of Set (duplicates removed): " + studentSet.size());

        List<Student> uniqueStudentsList = new ArrayList<>(studentSet);
        Collections.sort(uniqueStudentsList);

        for (Student student : uniqueStudentsList) {
            System.out.println(student);
        }

        Collections.sort(uniqueStudentsList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getLastName().compareToIgnoreCase(s2.getLastName());
            }
        });

        for (Student student : uniqueStudentsList) {
            System.out.println(student);
        }
    }

    public static Student findStudentById(List<Student> students, int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

class Student implements Comparable<Student> {
    private int id;
    private String lastName;
    private String firstName;

    public Student() {
    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}
