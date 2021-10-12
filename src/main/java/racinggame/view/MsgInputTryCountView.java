package racinggame.view;

import racinggame.model.Model;

public class MsgInputTryCountView implements View {

    public MsgInputTryCountView(Model model) {

    }

    @Override
    public void output() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
