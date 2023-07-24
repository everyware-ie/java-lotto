package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    User user;
    List<Integer> numbers = new ArrayList<>();

    public UserInput(User user){
        this.user = user;
    }

    //유저의 구입금액을 입력받는 메소드
    public void inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String tmp = readLine();
        int price = Integer.parseInt(tmp);
        user.buyLotto(price);
        user.setPrice(price);
    }

    //당첨 번호를 입력받는 메소드
    public void inputNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] tmpNumbers = readLine().split(",");
        for(int i=0; i< tmpNumbers.length; i++) {
            int num = Integer.parseInt(tmpNumbers[i]);
            validate(num);
            numbers.add(num);
        }

        user.setNumbers(numbers);
    }

    //보너스 번호를 입력받는 메소드
    public void inputBonusNum(){
        System.out.println("보너스 번호를 입력해주세요");
        int bonusNum = Integer.parseInt(readLine());
        validate(bonusNum);
        user.setBonusNum(bonusNum);
    }

    // 번호가 1에서 45사이인지 유효성 검사
    // 에러 시 "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." 라는 문구 출력되게 수정
    private void validate(int numbers){
            if(numbers<1 || numbers>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
    }

//    private void validate(List<Integer> numbers){
//        for(int i=0; i<numbers.size(); i++){
//            if(numbers.get(i)<1 || numbers.get(i)>45){
//                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
//            }
//        }
//    }
}
