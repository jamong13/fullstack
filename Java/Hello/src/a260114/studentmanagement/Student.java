package a260114.studentmanagement;

public class Student {
    private String studentID; // 학번
    private String name; // 이름
    private int age; // 나이
    private String major; // 전공
    private int kor;
    private int eng;
    private int math;
    
    public Student(String studentID, String name, int age, String major, int kor, int eng, int math) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.major = major;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
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

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int calculateTotal(){
        return (getKor() + getEng() + getMath());
    }
    public double calculateAverage(){
        return calculateTotal() / 3.0;
    }
}
