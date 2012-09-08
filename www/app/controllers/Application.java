package controllers;

import play.mvc.*;
import models.*;

public class Application extends Controller {

    public static void index() {
        Game game = Game.random();
        render(game);
    }

    public static void random(String currentSelectedGame) {
        Game game = Game.randomBut(currentSelectedGame);
        renderJSON(game);
    }
}