import java.util.*;
import java.math.*; //seems not using this..
//Math.Random? OR Random rand?

public class DeMereProblem {
    public static void main(String[] args) {
        System.out.println("확통 드메레 문제 주사위 머신 v1.0 \n");

        int tryDiceTimes = 1000000;  //Simulation thrown dice counts,주사위 던지는 갯수를 조절하고 싶으면 여기서 ㄱㄱ //멀티스레드 도입해보는것도 ㄱㅊ을듯?
        String quickReadDiceTimes = null;

        double singleDiceProbability = simulateSingleDice(tryDiceTimes);
        double doubleDiceProbability = simulateDoubleDice(tryDiceTimes);

        if(tryDiceTimes == 1000) {
            quickReadDiceTimes = "천회";
        } else if (tryDiceTimes == 10000) {
            quickReadDiceTimes = "만회";
        } else if (tryDiceTimes == 100000) {
            quickReadDiceTimes = "십만회";
        } else if (tryDiceTimes == 1000000) {
            quickReadDiceTimes = "백만회";
        } else if (tryDiceTimes == 10000000) {
            quickReadDiceTimes = "천만회";
        } else if (tryDiceTimes == 100000000) { //holy crap, whaat did i do?? 이걸왜만든거냐 그냥 자릿수에 따라서 자동명명하지..
            quickReadDiceTimes = "1억회";
        } else {
            quickReadDiceTimes = null;
        }
        System.out.printf("한개의 주사위를 4번 더져서 적어도 한번 (6)나올 확률: %.5f%n", singleDiceProbability);
        System.out.printf("두개의 주사위를 24번 던져서 적어도 한번 (6,6)나올 확률: %.5f%n", doubleDiceProbability);

        if (quickReadDiceTimes == null) {
            System.out.println("시도횟수: " + tryDiceTimes + "회");
        } else {
            System.out.println("시도횟수: " + quickReadDiceTimes + "(" + tryDiceTimes + "회)"); //tryDiceTime에 print할때 자동으로 1,000,000이런식으로 표시되게 하면 좋을듯
        }


    }

    private static double simulateSingleDice(int tryDiceTimes) { //한개의 주사위를 던졌을때의 경우의 함수호출
        Random rand = new Random();
        int successCount = 0;

        for (int i = 0; i < tryDiceTimes; i++) {
            boolean success = false;

            for (int j = 0; j < 4; j++) {
                if (rand.nextInt(6) + 1 == 6) {
                    success = true;
                    break;
                }
            }

            if (success) {
                successCount++;
            }

        }

        return (double) successCount / tryDiceTimes; //계산
    }



    private static double simulateDoubleDice(int tryDiceTimes) { //두개의 주사위를 던졌을때의 경우의 함수호출
        Random rand = new Random();
        int successCount = 0;

        for (int i = 0; i < tryDiceTimes; i++) {
            boolean success = false;
            for (int j = 0; j < 24; j++) {
                int diceA = rand.nextInt(6) + 1;
                int diceB = rand.nextInt(6) + 1;
                if (diceA == 6 && diceB == 6) {
                    success = true;
                    break;
                }
            }
            if (success) {
                successCount++;
            }
        }

        return (double) successCount / tryDiceTimes; //계산
    }
}

