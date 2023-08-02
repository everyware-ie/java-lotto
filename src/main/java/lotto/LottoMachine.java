package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class LottoMachine {
    List<List<Integer>> yourLotto = new ArrayList<>();
    int payment;

    // 구입금액을 가져와 유효성 검사 후 로또의 개수를 createLotto에 넘겨줌
    public void receiveMoney(int payment){
        int tickets = payment / 1000;
        createLottoNum(tickets);
    }

    // 로또의 개수를 받아와 그 수만큼 로또 제작
    private void createLottoNum(int tickets){ // 로또 번호
        System.out.println(tickets + "개를 구매했습니다.");
        for(int i=0; i<tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            yourLotto.add(numbers);
        }

        outputLottoNum();
    }

    // 구매한 로또 출력
    public void outputLottoNum() {
        for(int i = 0; i < yourLotto.size(); i++) {
            System.out.println(yourLotto.get(i).toString());
        }
    }
}
