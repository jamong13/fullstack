package a260120.ex01;

public class Student {
    String name;
    int age;
    int score;
    public Student() {
        // 기본 생성자
        // String name = null;
        // int age = 0;
        // int score = 0;
        // 자동으로 값을 넣어줌
        // 만약 없을 경우 Student(String name, int age, int score)의 형식만 가능하게 됨
    }
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString() {
        return "이름: " + name + ", 나이: " + age + ", 점수: " + score;
    }
    public String getGrade() {
        if(score >= 90){
            return "A";
        }else if(score >= 80){
            return "B";
        }else if(score >= 70){
            return "C";
        }else if(score >= 60){
            return "D";
        }else{
            return "F";
        }
    }

    
    
}
