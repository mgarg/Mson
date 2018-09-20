package Main;

public class Class {
    Teacher teacher;
    Student[] students;

    Class() {
        teacher = new Teacher("Mr X");
        Student s1 = new Student("Mahak", 25);
        Student s2 = new Student("Anuj", 31);
        students = new Student[]{s1, s2};
    }
}
