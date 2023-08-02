package lotto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

@Getter @Setter
public class Lotto {
    private List<Integer> numbers = new ArrayList<>();
    private int bonusNum;
    // 당첨 번호를 입력받는 메소드
    public void inputNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] tmpNumbers = readLine().split(",");
        for(int i=0; i< tmpNumbers.length; i++) {
            int num = Integer.parseInt(tmpNumbers[i]);
            numbers.add(num);
        }

        validate(numbers);
    }

    //보너스 번호를 입력받는 메소드
    public void inputBonusNum(){
        System.out.println("보너스 번호를 입력해주세요");
        bonusNum = Integer.parseInt(readLine());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개 입력해라잉");
        }
    }
}
