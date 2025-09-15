package gameslib;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class GamesLibraryTest {

  private GamesLibrary lib;
  private Platform ns;
  private Platform ps4;
  private Platform pc;
  private List<Game> ps4Games;
  private List<Game> pcGames;
  private List<Game> nsGames;

  @Before
  public void before_createLib(){
    lib = new GamesLibrary();

    ns = new Platform("Switch", "Nintendo");
    ps4 = new Platform("Playstation 4", "Sony");
    pc = new Platform("PC", "n/a");

    lib.addPlatform(ns);
    lib.addPlatform(ps4);
    lib.addPlatform(pc);


    ps4Games = new ArrayList<Game>();
    pcGames = new ArrayList<Game>();
    nsGames = new ArrayList<Game>();

    // Top 50 Metacritic for PC
    pcGames = List.of(
        new Game("Grand Theft Auto V", Genre.ACTION, pc, 2015, 96),
        new Game("The Orange Box", Genre.SHOOTER, pc, 2007, 96),
        new Game("Half-Life", Genre.SHOOTER, pc, 1998, 96),
        new Game("BioShock", Genre.SHOOTER, pc, 2007, 96),
        new Game("Baldur's Gate II: Shadows of Amn", Genre.ROLE_PLAYING_GAME, pc, 2000, 95),
        new Game("Portal 2", Genre.PUZZLE, pc, 2011, 95),
        new Game("The Elder Scrolls V: Skyrim", Genre.ROLE_PLAYING_GAME, pc, 2011, 94),
        new Game("Mass Effect 2", Genre.ACTION, pc, 2010, 94),
        new Game("Grand Theft Auto: Vice City", Genre.ACTION, pc, 2003, 94),
        new Game("Sid Meier's Civilization II", Genre.STRATEGY, pc, 1996, 94),
        new Game("Quake", Genre.SHOOTER, pc, 1996, 94),
        new Game("BioShock Infinite", Genre.SHOOTER, pc, 2013, 94),
        new Game("The Elder Scrolls IV: Oblivion", Genre.ROLE_PLAYING_GAME, pc, 2006, 94),
        new Game("Grim Fandango", Genre.ADVENTURE, pc, 1998, 94),
        new Game("Diablo", Genre.ROLE_PLAYING_GAME, pc, 1996, 94),
        new Game("Sid Meier's Civilization IV", Genre.STRATEGY, pc, 2005, 94),
        new Game("The Witcher 3: Wild Hunt", Genre.ROLE_PLAYING_GAME, pc, 2015, 93),
        new Game("Company of Heroes", Genre.STRATEGY, pc, 2006, 93),
        new Game("Half-Life: Alyx", Genre.ACTION, pc, 2020, 93),
        new Game("Divinity: Original Sin II", Genre.ROLE_PLAYING_GAME, pc, 2017, 93),
        new Game("Unreal Tournament 2004", Genre.SHOOTER, pc, 2004, 93),
        new Game("Starcraft II: Wings of Liberty", Genre.STRATEGY, pc, 2010, 93),
        new Game("Minecraft", Genre.BUILDING, pc, 2011, 93),
        new Game("Red Dead Redemption 2", Genre.ACTION, pc, 2019, 93),
        new Game("Grand Theft Auto III", Genre.ACTION, pc, 2002, 93),
        new Game("Homeworld", Genre.STRATEGY, pc, 1999, 93),
        new Game("Star Wars: Knights of the Old Republic", Genre.ROLE_PLAYING_GAME, pc, 2003, 93),
        new Game("World of Warcraft", Genre.ROLE_PLAYING_GAME, pc, 2004, 93),
        new Game("Grand Theft Auto: San Andreas", Genre.ACTION, pc, 2005, 93),
        new Game("Call of Duty 4: Modern Warfare", Genre.ACTION, pc, 2007, 92),
        new Game("Warcraft III: Reign of Chaos", Genre.STRATEGY, pc, 2002, 92),
        new Game("Sid Meier's Gettysburg!", Genre.STRATEGY, pc, 1997, 92),
        new Game("Team Fortress 2", Genre.SHOOTER, pc, 2007, 92),
        new Game("System Shock 2", Genre.ACTION, pc, 1999, 92),
        new Game("Tom Clancy's Splinter Cell: Chaos Theory", Genre.ACTION, pc, 2005, 92),
        new Game("Rome: Total War", Genre.STRATEGY, pc, 2004, 92),
        new Game("Okami HD", Genre.ADVENTURE, pc, 2017, 92),
        new Game("Undertale", Genre.ROLE_PLAYING_GAME, pc, 2015, 92),
        new Game("Thief: The Dark Project", Genre.ACTION, pc, 1998, 92),
        new Game("Age of Empires II: The Age of Kings", Genre.STRATEGY, pc, 1999, 92),
        new Game("Unreal Tournament (1999)", Genre.SHOOTER, pc, 1999, 92),
        new Game("Sid Meier's Alpha Centauri", Genre.STRATEGY, pc, 1999, 92),
        new Game("Galactic Civilizations II: Twilight of the Arnor", Genre.STRATEGY, pc, 2008, 92),
        new Game("Out of the Park Baseball 17", Genre.SPORT, pc, 2016, 92),
        new Game("The Witcher 3: Wild Hunt - Blood and Wine", Genre.ROLE_PLAYING_GAME, pc, 2016, 92),
        new Game("Tiger Woods PGA Tour 2003", Genre.SPORT, pc, 2002, 92),
        new Game("Dishonored", Genre.ACTION, pc, 2012, 91),
        new Game("Medal of Honor: Allied Assault", Genre.SHOOTER, pc, 2002, 91),
        new Game("Myth: The Fallen Lords", Genre.ADVENTURE, pc, 1997, 91),
        new Game("World of Warcraft: Wrath of the Lich King", Genre.ROLE_PLAYING_GAME, pc, 2008, 91));
    
    // Top 20 Metacritic for Nintendo Switch
    nsGames = List.of(
        new Game("The Legend of Zelda: Breath of the Wild", Genre.ADVENTURE, ns, 2017, 97) ,
        new Game("Super Mario Odyssey", Genre.PLATFORMER, ns, 2017, 97) ,
        new Game("Divinity: Original Sin II - Definitive Edition", Genre.ROLE_PLAYING_GAME, ns, 2019, 93) ,
        new Game("Undertale", Genre.ROLE_PLAYING_GAME, ns, 2018, 93) ,
        new Game("Super Smash Bros. Ultimate", Genre.PLATFORMER, ns, 2018, 93) ,
        new Game("Celeste", Genre.PLATFORMER, ns, 2018, 92) ,
        new Game("Bayonetta 2", Genre.ACTION, ns, 2018, 92) ,
        new Game("Mario Kart 8 Deluxe", Genre.SPORT, ns, 2017, 92) ,
        new Game("INSIDE", Genre.ACTION, ns, 2018, 91) ,
        new Game("Dragon Quest XI S: Echoes of an Elusive Age - Definitive Edition", Genre.ROLE_PLAYING_GAME, ns, 2019, 91) ,
        new Game("Sonic Mania Plus", Genre.PLATFORMER, ns, 2018, 91) ,
        new Game("SteamWorld Heist: Ultimate Edition", Genre.STRATEGY, ns, 2017, 91) ,
        new Game("Shovel Knight: Treasure Trove", Genre.PLATFORMER, ns, 2017, 91) ,
        new Game("Animal Crossing: New Horizons", Genre.BUILDING, ns, 2020, 91) ,
        new Game("Bastion", Genre.ACTION, ns, 2018, 90) ,
        new Game("Hollow Knight", Genre.METROIDVANIA, ns, 2018, 90) ,
        new Game("Ori and the Blind Forest: Definitive Edition", Genre.METROIDVANIA, ns, 2019, 90) ,
        new Game("Bayonetta + Bayonetta 2", Genre.ACTION, ns, 2018, 90) ,
        new Game("Dead Cells", Genre.ACTION, ns, 2018, 89));
      


    // Top 30 Metacritic for PS4
    ps4Games = List.of(
        new Game("Red Dead Redemption 2", Genre.ACTION, ps4, 2018, 97 ),
        new Game("Grand Theft Auto V", Genre.ACTION, ps4, 2014, 97 ) ,
        new Game("The Last of Us Part II", Genre.ACTION, ps4, 2020, 96 ) ,
        new Game("Persona 5 Royal", Genre.ACTION, ps4, 2020, 95 ) ,
        new Game("The Last of Us Remastered", Genre.ACTION, ps4, 2014, 95 ) ,
        new Game("God of War", Genre.ACTION, ps4, 2018, 94 ) ,
        new Game("Persona 5", Genre.ACTION, ps4, 2017, 93 ) ,
        new Game("Metal Gear Solid V: The Phantom Pain", Genre.ACTION, ps4, 2015, 93 ) ,
        new Game("Uncharted 4: A Thief's End", Genre.ACTION, ps4, 2016, 93 ) ,
        new Game("Journey", Genre.ACTION, ps4, 2015, 92 ) ,
        new Game("Bloodborne", Genre.ACTION, ps4, 2015, 92 ) ,
        new Game("Undertale", Genre.ACTION, ps4, 2017, 92 ) ,
        new Game("The Witcher 3: Wild Hunt", Genre.ACTION, ps4, 2015, 92 ) ,
        new Game("Divinity: Original Sin II - Definitive Edition", Genre.ACTION, ps4, 2018, 92 ) ,
        new Game("Final Fantasy XIV: Shadowbringers", Genre.ACTION, ps4, 2019, 91 ) ,
        new Game("Shadow of the Colossus", Genre.ACTION, ps4, 2018, 91 ) ,
        new Game("The Witcher 3: Wild Hunt - Blood and Wine", Genre.ACTION, ps4, 2016, 91 ) ,
        new Game("Celeste", Genre.ACTION, ps4, 2018, 91 ) ,
        new Game("INSIDE", Genre.ACTION, ps4, 2016, 91 ) ,
        new Game("NieR: Automata - Game of the YoRHa Edition", Genre.ACTION, ps4, 2019, 91 ) ,
        new Game("Resident Evil 2", Genre.ACTION, ps4, 2019, 91 ) ,
        new Game("flower", Genre.ACTION, ps4, 2013, 91 ) ,
        new Game("Diablo III: Ultimate Evil Edition", Genre.ACTION, ps4, 2014, 90 ) ,
        new Game("Overwatch", Genre.ACTION, ps4, 2016, 90 ) ,
        new Game("Shovel Knight", Genre.ACTION, ps4, 2015, 90 ) ,
        new Game("Rayman Legends", Genre.ACTION, ps4, 2014, 90 ) ,
        new Game("Fez", Genre.ACTION, ps4, 2014, 90 ) ,
        new Game("Monster Hunter: World", Genre.ACTION, ps4, 2018, 90 ) ,
        new Game("Tales From The Borderlands: Episode 5 - The Vault of the Traveler", Genre.ACTION, ps4, 2015, 90 ) ,
        new Game("The Witcher 3: Wild Hunt - Hearts of Stone", Genre.ACTION, ps4, 2015, 90 ));

    // add all games to library
    pcGames.forEach( game -> lib.addGame(game) );
    nsGames.forEach( game -> lib.addGame(game) );
    ps4Games.forEach( game -> lib.addGame(game) );

  }




}
