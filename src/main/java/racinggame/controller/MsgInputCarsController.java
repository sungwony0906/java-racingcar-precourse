package racinggame.controller;

import racinggame.model.Model;
import racinggame.view.MsgInputCarsView;
import racinggame.view.View;

public class MsgInputCarsController implements Controller{

    public View handle() {
        return this.handle(null);
    }

    @Override
    public View handle(Model model) {
        return new MsgInputCarsView(model);
    }
}
