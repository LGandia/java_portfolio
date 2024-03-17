abstract class PlayerStats{
    public String playerName;
    public String playerSurname;
    public String playerTeam;

    public PlayerStats(String playerName, String playerSurname, String playerTeam) {
        this.playerName = playerName;
        this.playerSurname = playerSurname;
        this.playerTeam = playerTeam;
    }
}
class FootballStats extends PlayerStats{
    public String league;
    public int goalsScored;
    public int shirtNumber;
    public String fieldPosition;
    public FootballStats(String playerName, String playerSurname, String playerTeam,
                         int goalsScored, int shirtNumber, String league, String fieldPosition) {
        super(playerName, playerSurname, playerTeam);

        this.league = league;
        this.goalsScored = goalsScored;
        this.shirtNumber = shirtNumber;
        this.fieldPosition = fieldPosition;
    }
    public void getFootballerDetails() {
        System.out.println("=================================");
        System.out.println("Player name: " + this.playerName);
        System.out.println("Player surname: " + this.playerSurname);
        System.out.println("Team: " + this.playerTeam);
        System.out.println("League: " + this.league);
        System.out.println("Goals scored: " + this.goalsScored);
        System.out.println("Shirt Number: " + this.shirtNumber);
        System.out.println("Position on the field: " + this.fieldPosition);
        System.out.println("=================================");
    }
}
class BasketballStats extends PlayerStats{
    public int pointsScored;
    public String league;
    public float playerShoeSize;
    public double playerHeight;

    public BasketballStats(String playerName, String playerSurname, String playerTeam,
                         int pointsScored, String league, float playerShoeSize, double playerHeight) {
        super(playerName, playerSurname, playerTeam);

        this.pointsScored = pointsScored;
        this.league = league;
        this.playerShoeSize = playerShoeSize;
        this.playerHeight = playerHeight;
    }
    public void getBasketballerDetails() {
        System.out.println("=================================");
        System.out.println("Player name: " + this.playerName);
        System.out.println("Player surname: " + this.playerSurname);
        System.out.println("Team: " + this.playerTeam);
        System.out.println("League: " + this.league);
        System.out.println("Goals scored: " + this.pointsScored);
        System.out.println("Shoe size: " + this.playerShoeSize);
        System.out.println("Height: " + this.playerHeight);
        System.out.println("=================================");
    }
}
class CricketStats extends PlayerStats{
    public int runsScored;
    public int catches;
    public int wicketsTaken;
    public int strikeRate;
    public CricketStats(String playerName, String playerSurname, String playerTeam,
                        int runsScored, int catches, int wicketsTaken, int strikeRate) {
        super(playerName, playerSurname, playerTeam);
        this.runsScored = runsScored;
        this.catches = catches;
        this.wicketsTaken = wicketsTaken;
        this.strikeRate = strikeRate;

    }
    public void getCricketerDetails() {
        System.out.println("=================================");
        System.out.println("Player name: " + this.playerName);
        System.out.println("Player surname: " + this.playerSurname);
        System.out.println("Team: " + this.playerTeam);
        System.out.println("Runs scored: " + this.runsScored);
        System.out.println("Catches: " + this.catches);
        System.out.println("Wickets taken: " + this.wicketsTaken);
        System.out.println("Strike rate: " + this.strikeRate);
        System.out.println("=================================");
    }
}

class SportReport {
    public static void main(String[] args) {
        CricketStats cricketPlayer1 = new CricketStats("Aaron","Skyes","Chicago",8,5,8,8);
        cricketPlayer1.getCricketerDetails();

        BasketballStats basketball1 = new BasketballStats("LeBron","James","Lakers",75,"NBA",9,1.80);
        basketball1.getBasketballerDetails();

        FootballStats footballer1 = new FootballStats("Andres","Iniesta","Spain",42,8,"La Liga","Midfielder");
        footballer1.getFootballerDetails();
    }
}

