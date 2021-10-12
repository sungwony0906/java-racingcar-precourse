package racinggame.controller;

import racinggame.model.Model;
import racinggame.view.MsgCarRacingView;
import racinggame.view.View;

public class MsgCarRacingController implements Controller{

    public View handle() {
        return this.handle(null);
    }

    @Override
    public View handle(Model model) {
        return new MsgCarRacingView();
    }
}
