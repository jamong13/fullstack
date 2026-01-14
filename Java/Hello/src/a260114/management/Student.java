package a260114.management;

public class Student {
    private String studentID; // 학번
    private String name; // 이름
    private int age; // 나이
    private String major; // 전공

    public Student(String studentID, String name, int age, String major) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    
    
}
