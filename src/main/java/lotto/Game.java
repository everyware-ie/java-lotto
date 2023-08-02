package lotto;

public class Game {
    public static void start() {
        LottoMachine lottoMachine = new LottoMachine();
        Order order = new Order(lottoMachine);
        Lotto lotto = new Lotto();
        Check check = new Check(lottoMachine, lotto);

        // 구입 금액 입력받기
        order.inputPrice();

        // 로또 당첨 번호 입력 받음
        lotto.inputNumbers();

        // 추가 보너스 번호 입력 받음
        lotto.inputBonusNum();

        // 결과 검사
        check.check();

        Statistics stat = new Statistics(order, check.countOfPrizes);

        // 결과 출력
        stat.result();
    }
}
