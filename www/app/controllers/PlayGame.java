package controllers;

import play.mvc.*;
import models.*;

public class PlayGame extends Controller {
    public static void index(String gameName) {
        Game game = Game.find("byName", gameName).first();
        render(game);
    }
}
