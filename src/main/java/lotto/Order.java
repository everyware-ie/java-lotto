package lotto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

@Getter
public class Order {
    LottoMachine lottoMachine;
    List<Integer> numbers = new ArrayList<>();
    int price;

    public Order(LottoMachine lottoMachine){
        this.lottoMachine = lottoMachine;
    }

    //유저의 구입금액을 입력받는 메소드
    public void inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");

        String tmp = readLine();
        price = Integer.parseInt(tmp);
        validate(price);

        lottoMachine.receiveMoney(price);
    }

    // 구입금액에 대한 유효성 검사
    private void validate(int payment){
        if(payment%1000 != 0)
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구매해야 합니다.");
    }
}
