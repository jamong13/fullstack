package a251231;

public class Ex03 {
    public static void main(String[] args) {
        // 한 반에 27명인 학급. 색연필 5다스. 각 학생에게 나눠 줄 수 있는 색연필의 수와 나눠주고 남은 색연필의 수는?

        int colorPen = 5 * 12;
        int studentCount = 27;

        int divColorPen = colorPen / studentCount;

        System.out.println("각 학생에게 나눠 줄 수 있는 색연필의 수: " + divColorPen);

        int remainColorPen = colorPen % studentCount;
        System.out.println("나눠주고 남은 색연필의 수: " + remainColorPen);
    }
}
