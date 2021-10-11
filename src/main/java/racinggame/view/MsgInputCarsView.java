package racinggame.view;

import racinggame.model.Model;

public class MsgInputCarsView implements View{

    private Model model;

    public MsgInputCarsView(Model model){
        this.model = model;
    }

    @Override
    public void output() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
