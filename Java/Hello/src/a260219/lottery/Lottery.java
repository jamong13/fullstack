package a260219.lottery;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Lottery {
    String randomNum = "";
    String [] randomNumbers = new String[6];
    
    // 랜덤으로 로또번호가 생성되게 한다.
    // 1~45 범위에서 중복없이 6개를 선택
    
    public void randomLotteryNum() {
        for(int i = 0; i < 6; i++){
            randomNum += random(0, 9);
        }
        this.randomNum = randomNum;
    }

    private static int random(int min, int max) {
        int num = (int) ((Math.random() * (max - min + 1)) + min);
        // max - min + 1 == 10
        return num;
    }

    // 랜덤 생성 로또 번호를 출력
    public void lotteryNum() {
        System.out.println("\n[INFO] 로또 당첨 번호 안내 드립니다.");
        System.out.println("\n★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
        System.out.println("★☆★☆★☆★☆★☆[" + randomNum + "]★☆★☆★☆★☆★☆");
        System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Calendar time = Calendar.getInstance();
        String format_time1 = format1.format(time.getTime());
        System.out.println((format_time1));

        System.out.println("\n===================================================");
    }
    
    // 로또 결과를 출력한다.
    public void result(){
        Membership m = Membership.getInstance();
        Purchase p = Purchase.getInstance();

        System.out.println("[INFO] " + m.name + "님의 당첨 결과를 3초 후에 안내드립니다.");
        System.out.println("\n=====================================================");
        Loading l = new Loading();
        l.loading();
        if(p.customerNum.equals(randomNum)){
            System.out.println("[INFO] " + m.name + "님의 로또 번호는 " + p.customerNum + "입니다.");
            System.out.println("[INFO] 축하드립니다. 로또에 당첨되셨습니다.");
        }else{
            System.out.println("[INFO] " + m.name + "님의 로또 번호는 " + p.customerNum + "입니다.");
            System.out.println("당첨 번호는 " + randomNum + "입니다.");
            System.out.println("[INFO]낙첨되셨습니다. 다음 기회를 노려보세요.");
        }
        System.out.println("\n=============================================================");
    }
}
