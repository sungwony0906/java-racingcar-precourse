package racinggame.controller;

import racinggame.model.Model;
import racinggame.view.View;

public interface Controller {

    public View handle(Model model);
}
