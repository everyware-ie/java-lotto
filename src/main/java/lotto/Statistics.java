package lotto;

import java.util.List;

public class Statistics { //당첨 통계 클래스

    //상금을 미리 저장해놓은 배열
    int[] prizes = {0, 2000000000, 30000000, 1500000, 50000, 5000};
    int[] countOfPrizes;

    Order order;
    Statistics(Order order, int[] countOfPrizes) {
        this.countOfPrizes = countOfPrizes;
        this.order = order;
    }

    public double calRate () {
        int baseMoney = order.getPrice();
        int earnMoney = 0;

        for (int i = 1; i < prizes.length; i++) {
            earnMoney += prizes[i] * countOfPrizes[i];
        }

        return (double) earnMoney / baseMoney * 100;
    }

    // 결과값을 출력해주는 메소드 만들어야함
    // 수익률을 구하는 메소드 또한 필요
    public void result(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + countOfPrizes[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + countOfPrizes[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + countOfPrizes[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfPrizes[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + countOfPrizes[1] + "개");
        System.out.println("총 수익률은 " + Math.round(calRate() * 10) / 10 + "%입니다.");
    }
}
