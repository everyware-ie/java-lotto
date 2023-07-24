package lotto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
//        validate(numbers);
        this.numbers = numbers;
    }

//    private void validate(List<Integer> numbers) {
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException("[ERROR] 6개 입력해라잉");
//        }
//    }
}
