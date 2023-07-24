package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        process();
    }

    //처음 코드 실행 부분
    public static void process(){
        User user = new User();
        UserInput ui = new UserInput(user);

        ui.inputPrice();

        for(int i = 0; i < user.lottoList.size(); i++){
            System.out.println(user.lottoList); // list 출력
        }

        ui.inputNumbers();

        ui.inputBonusNum();

        Statistics stat = new Statistics(user);

    }

}
