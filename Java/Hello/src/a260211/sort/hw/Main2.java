package a260211.sort.hw;

public class Main2 {
    public static void main(String[] args) {

        Student[] students = {
            new Student("김철수", 20, 2023003),
            new Student("홍길동", 21, 2023001),
            new Student("박민수", 19, 2023005),
            new Student("최지은", 22, 2023002),
            new Student("이영희", 20, 2023004)
        };

        // 선택 정렬
        SelectionSort(students);

        // 정렬된 결과 출력
        System.out.println("정렬된 학생 목록:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    private static void SelectionSort(Student[] students){
        int n = students.length;

    for (int i = 0; i < n - 1; i++) {

        int minIndex = i;

        for (int j = i + 1; j < n; j++) {
            if (students[j].getName().compareTo(students[minIndex].getName()) < 0) {
                minIndex = j;
            }
        }

        Student temp = students[minIndex];
        students[minIndex] = students[i];
        students[i] = temp;
    }
    }
}

class Student{
    private String name;
    private int age;
    private int StudentId;
    
    public Student(String name, int age, int studentId) {
        this.name = name;
        this.age = age;
        StudentId = studentId;
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
    public int getStudentId() {
        return StudentId;
    }
    public void setStudentId(int studentId) {
        StudentId = studentId;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", StudentId=" + StudentId + "]";
    }
}
