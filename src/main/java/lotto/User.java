package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Lotto> lottoList = new ArrayList<>();
    int price;
    List<Integer> numbers;
    int bonusNum;
    public User(){}

    // TODO: payment로 변경
    public void setPrice(int price){
        this.price = price;
    }
    public void setBonusNum(int bonusNum){
        this.bonusNum =bonusNum;
    }
    public void setNumbers(List<Integer> numbers){
        this.numbers = numbers;
    }

    public int getPrice(){
        return this.price;
    }
    public int getBonusNum(){
        return this.bonusNum;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public List<Lotto> getLottoList(){
        return this.lottoList;
    }

    // 구입금액을 가져와 유효성 검사 후 로또의 개수를 createLotto에 넘겨줌
    public void buyLotto(int price){
        validate(price);
        this.price = price;
        int tickets = price/1000;
        createLotto(tickets);

    }

    // 로또의 개수를 받아와 그 수만큼 로또 제작
    private void createLotto(int tickets){
        System.out.println(tickets + "개를 구매했습니다.");
        for(int i=0; i<tickets; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(numbers));
        }
    }

    // 구입금액에 대한 유효성 검사
    private void validate(int price){
        if(price%1000 != 0)
            throw new IllegalArgumentException();
    }
}
