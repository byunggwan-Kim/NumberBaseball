import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int count = 0;

        // 랜덤한 수 3개를 만들어 각각 변수에 넣는다.
        int num1 = rd.nextInt(10);
        int num2 = rd.nextInt(10);
        int num3 = rd.nextInt(10);

        while (true) { // 중복제거
            if ((num1 == num2) || (num2 == num3) || (num1 == num3) ) {
                num1 = rd.nextInt(10);
                num2 = rd.nextInt(10);
                num3 = rd.nextInt(10);
            } else {
                break;
            }
        }

        // ArrayList에 각각 추가한다.
        intList.add(num1);
        intList.add(num2);
        intList.add(num3);


        // ArrayList에 넣은 각각의 값에 접근하여 Integer 변수에 할당한다.
        Integer result1 = intList.get(0);
        Integer result2 = intList.get(1);
        Integer result3 = intList.get(2);

        // 컴퓨터가 설정한 랜덤 값 보여주기
        // System.out.println(result1 + "" + result2 + "" + result3);


        while (true) {
            int ball = 0;
            int strike = 0;
            count++;
            System.out.print(count + "번째 시도 : ");

            int i = sc.nextInt(); // 숫자를 입력받음

            int throw1 = i / 100; // 백의 자리수
            int throw2 = (i % 100)/10; // 십의 자리수
            int throw3 = (i % 100)%10; // 일의 자리수

            // ball 판정 조건
            if((result1 == throw2) || (result1 == throw3)) {
                ball++;
            }
            if ((result2 == throw1) || (result2 == throw3)) {
                ball++;
            }
            if ((result3 == throw1) || (result3 == throw2)) {
                ball++;
            }

            // strike 판정 조건
            if(result1 == throw1) {
                strike++;
            }
            if (result2 == throw2) {
                strike++;
            }
            if (result3 == throw3) {
                strike++;
            }


            // 종료 조건
            if((result1 == throw1) && (result2 == throw2) && (result3 == throw3)) {
                System.out.println(strike + "S");
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

            // 판정
            System.out.println(ball + "B" + strike + "S");
        }
    }
}