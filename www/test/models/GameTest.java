package models;

import org.junit.*;
import java.util.*;
import play.test.*;

public class GameTest extends UnitTest {
    Game duckRunnerGame;
	Game parkingLotGame;

    @Before
    public void setup() {
        Fixtures.deleteAll();

        Fixtures.load("data.yml");
        
        duckRunnerGame = Game.find("byName", "Duck Runner").first();
        parkingLotGame = Game.find("byName", "Parking Lot").first();
    }
    
    @Test
    public void createsAndRetrievesGameCorrectly() {
        assertEquals("Duck Runner", duckRunnerGame.name);
        assertEquals("You're here to run a duck from flying angels", 
            duckRunnerGame.description);
        assertEquals("/public/games/duck_runner.swf", 
            duckRunnerGame.gamePath);
        assertEquals("Follow your heart", duckRunnerGame.playingTips);
        assertEquals("Arrow keys are fine.", duckRunnerGame.playingKeys);
        assertEquals("/public/game-images/duck_runner.jpg", 
            duckRunnerGame.thumbnailPath);
        assertEquals("/public/game-images/duck_runner_large.jpg", 
            duckRunnerGame.largeThumbnailPath);
    }

    @Test
    public void evenlyRandomlySelectsGame() {
        boolean duckRunnerGameFetched = false;
        boolean parkingLotGameFetched = false;
        
        // two games should be fetched by random chance
        
        for (int i = 0; i < 25; i++) {
            String aRandomGameName = Game.random().name;
            assertNotNull(aRandomGameName);
            
            if (aRandomGameName == duckRunnerGame.name) {
                duckRunnerGameFetched = true;
            } else if (aRandomGameName == parkingLotGame.name) {
                parkingLotGameFetched = true;
            } else {
                fail("should select existing games only...");
            }
        }
        
        if (!duckRunnerGameFetched) {
            fail("duck runner game should've been selected...");
        }

        if (!parkingLotGameFetched) {
            fail("parking lot game should've been selected...");
        }
    }

    @Test
    public void evenlyRandomlySelectGameButTheSelectedGame() {
        String selectedGameName = Game.randomBut(parkingLotGame.name).name;
		assertEquals("duck runner game should've been selected...", 
		    "Duck Runner", selectedGameName);
    }
}
