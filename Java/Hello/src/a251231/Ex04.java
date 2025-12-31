package a251231;

public class Ex04 {
    public static void main(String[] args) {
        // 6세 이상 탑승 가능(단, 키가 120cm 이상이면 보호자 동반 하에 탑승 가능)
        // 키 120cm 이상 탑승 가능
        // 심장 관련 질환자 탑승 불가
        // age 나이, height 키, parent 보호자 동반 여부, 심장질환여부 heartDisease, take 탑승 가능 여부

        int age = 6;
        int height = 130;
        boolean parent = false;
        boolean heartDisease = false;
        boolean take = ((age >= 6 && height >= 120) || (height >= 120 && parent == true)) && heartDisease == false;

        System.out.println(take);
        // 신장이 120 이상이면서 나이가 6세 이상이거나 보호자가 동반되고 심장질환이 없을 때만 탑승 가능
        
    }
}
