package a260115.management;

public class Student {
    private String studentID; // 학번
    private String name; // 이름
    private int age; // 나이
    private String major; // 전공
    private int kor; // 국어 점수
    private int eng; // 영어 점수
    private int math; // 수학 점수
    
    public Student(){}; // 기본 생성자

    public Student(String studentID, String name, int age, String major, int kor, int eng, int math) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.major = major;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        // this.sum = kor + eng + math;
    }

    
    @Override
    public String toString() {
        return "Student [studentID=" + studentID + ", name=" + name + ", age=" + age + ", major=" + major + ", kor="
                + kor + ", eng=" + eng + ", math=" + math + "총점=" + calculateTotal() + "평균=" + calculateAverage() + "]";
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
    
    // 총점 계산 메서드
    public int calculateTotal(){
        return kor + eng + math;
    }

    // 평균 계산 메서드
    public double calculateAverage(){
        return calculateTotal() / 3.0;
    }
    
}
