package racinggame.controller;

import racinggame.model.Model;
import racinggame.view.MsgInputTryCountView;
import racinggame.view.View;

public class MsgInputTryCountController implements Controller{

    public View handle() {
        return this.handle(null);
    }

    @Override
    public View handle(Model model) {
        return new MsgInputTryCountView(model);
    }
}
