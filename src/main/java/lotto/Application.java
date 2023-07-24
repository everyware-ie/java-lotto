package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        process();
    }

    //처음 코드 실행 부분
    public static void process() {
        User user = new User();
        UserInput ui = new UserInput(user);

        // 구입 금액 입력받기
        // 로또 구매
        ui.inputPrice();

        // 구매한 로또 출력
        for (int i = 0; i < user.lottoList.size(); i++) {
            System.out.println(user.lottoList.get(i).getNumbers().toString());
        }

        // TODO: lottoNum jackpotNum
        // 로또 당첨 번호 입력 받음
        ui.inputNumbers();

        // 추가 보너스 번호 입력 받음
        ui.inputBonusNum();

        Statistics stat = new Statistics(user);
        stat.check();
        stat.result();
    }
}
