Feature: A game in homepage 
    In order to select a game,
    As a player
    I need to see a game
    
    Scenario:
        Given a player
        When visited the homepage
        Then the player should see a game in the banner  
        
        