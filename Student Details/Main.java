
class Student {

    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

class Exam extends Student {

    int examMarks;

    public Exam(String name, int rollNo, int examMarks) {
        super(name, rollNo);
        this.examMarks = examMarks;
    }

    public void displayExamMarks() {
        System.out.println("Exam Marks: " + examMarks);
    }
}

interface Sports {

    int getSportsGraceMarks();
}

class Results extends Exam implements Sports {

    int sportsGraceMarks;

    public Results(String name, int rollNo, int examMarks, int sportsGraceMarks) {
        super(name, rollNo, examMarks);
        this.sportsGraceMarks = sportsGraceMarks;
    }

    @Override
    public int getSportsGraceMarks() {
        return sportsGraceMarks;
    }

    public void displayFinalMarks() {
        int finalMarks = examMarks + getSportsGraceMarks();
        displayStudentDetails();
        displayExamMarks();
        System.out.println("Sports Grace Marks: " + sportsGraceMarks);
        System.out.println("Final Marks: " + finalMarks);
    }
}

public class Main {

    public static void main(String[] args) {
        Results student1 = new Results("Rajan", 101, 85, 10);
        student1.displayFinalMarks();
    }
}
