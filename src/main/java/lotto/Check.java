package lotto;

import java.util.List;

public class Check {
    int[] countOfPrizes = new int[6];

    LottoMachine lottoMachine;
    Lotto lotto;

    public Check(LottoMachine lottoMachine, Lotto lotto) {
        this.lottoMachine = lottoMachine;
        this.lotto = lotto;
    }

    // 로또 번호와 당첨 번호가 몇개 일치했는지 검사해서 해당 등수를 리턴
    public int update(List<Integer> checkLotto, int cnt) {
        if (cnt == 6) {
            return 1;
        }
        // 번호가 5개 일치할 때만 보너스 볼 일치하는지 확인하면됨
        if (cnt == 5) {
            if (checkLotto.contains(lotto.getBonusNum())) return 2;
            return 3;
        }
        if (cnt == 4) {
            return 4;
        }
        if (cnt == 3) {
            return 5;
        }
        return 0;
    }

    public void check() {
        // user가 구매한 로또가 당첨번호와 얼마나 일치하는지 검사
        for (int i = 0; i < lottoMachine.getYourLotto().size(); i++) {
            List<Integer> checkLotto = lottoMachine.getYourLotto().get(i);
            compare(checkLotto);
        }
    }

    // 로또 번호와 당첨 번호를 비교해서 같은게 존재하면 cnt++
    public void compare(List<Integer> checkLotto) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.getNumbers().contains(checkLotto.get(i))) {
                cnt++;
            }
        }
        // 등수 계산
        int prize = update(checkLotto, cnt);

        // 현재 등수를 통계에 추가
        countOfPrizes[prize]++;
    }
}
