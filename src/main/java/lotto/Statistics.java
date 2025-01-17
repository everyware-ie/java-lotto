package lotto;

import java.util.HashMap;
import java.util.List;

public class Statistics { //당첨 통계 클래스
    User user;
    //상금을 미리 저장해놓은 배열
    int[] prizes = {0, 2000000000, 30000000, 1500000, 50000, 5000};
    // 이름 뭐로할지 몰라서 일단 a로 해둠, 값이 1인 인덱스를 prizes에 적용하면 해당 금액
    int[] countOfPrizes = new int[6];

    public Statistics(User user) {
        this.user = user;
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

    // 로또 번호와 당첨 번호를 비교해서 같은게 존재하면 cnt++
    public void compare(List<Integer> checkLotto){
        int cnt = 0;
        for(int j =0; j<6; j++){
            if(checkLotto.contains(user.getNumbers().get(j))) {
                cnt++;
            }
        }
        // 등수 계산
        int prize = update(checkLotto,cnt);
        // 현재 등수를 통계에 추가
        countOfPrizes[prize]++;
    }

    // 로또 번호와 당첨 번호가 몇개 일치했는지 검사해서 해당 등수를 리턴
    public int update(List<Integer> checkLotto, int cnt){
        if(cnt==6){
            return 1;
        }
        // 번호가 5개 일치할 때만 보너스 볼 일치하는지 확인하면됨
        if(cnt==5){
            if(checkLotto.contains(user.getBonusNum())) return 2;
            return 3;
        }
        if(cnt==4){
            return 4;
        }
        if(cnt==3){
            return 5;
        }
        return 0;
    }

    public void check(){
        // user가 구매한 로또가 당첨번호와 얼마나 일치하는지 검사
        for(int i = 0; i < user.getLottoList().size(); i++){
            List<Integer> checkLotto = user.getLottoList().get(i).getNumbers();
            compare(checkLotto);
        }
    }

    public double calRate () {
        int baseMoney = user.price;
        int earnMoney = 0;

        for (int i = 1; i < prizes.length; i++) {
            earnMoney += prizes[i] * countOfPrizes[i];
        }

        return (double) earnMoney / baseMoney * 100;
    }
}
