abstract class PlayerStats{
    public String playerName;
    public String playerSurname;
    public String playerSport;
    public String playerTeam;

    public PlayerStats(String playerName, String playerSurname, String playerSport, String playerTeam) {
        this.playerName = playerName;
        this.playerSurname = playerSurname;
        this.playerSport = playerSport;
        this.playerTeam = playerTeam;
    }
}
class FootballStats extends PlayerStats{
    public String league;
    public int goalsScored;
    public int shirtNumber;
    public String fieldPosition;
    public FootballStats(String playerName, String playerSurname, String playerSport, String playerTeam,
                         int goalsScored, int shirtNumber, String league, String fieldPosition) {
        super(playerName, playerSurname, playerSport, playerTeam);

        this.league = league;
        this.goalsScored = goalsScored;
        this.shirtNumber = shirtNumber;
        this.fieldPosition = fieldPosition;
    }
    public void getFootballerDetails() {
        System.out.println("=================================");
        System.out.println("Player name: " + this.playerName);
        System.out.println("Player surname: " + this.playerSurname);
        System.out.println("Sport: " + this.playerSport);
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

    public BasketballStats(String playerName, String playerSurname, String playerSport, String playerTeam,
                         int pointsScored, String league, float playerShoeSize, double playerHeight) {
        super(playerName, playerSurname, playerSport, playerTeam);

        this.pointsScored = pointsScored;
        this.league = league;
        this.playerShoeSize = playerShoeSize;
        this.playerHeight = playerHeight;
    }
}
class CricketStats extends PlayerStats{
    public int runsScored;
    public int catches;
    public int wicketsTaken;
    public int strikeRate;
    public CricketStats(String playerName, String playerSurname, String playerSport, String playerTeam,
                         int runsScored, int catches, int wicketsTaken, int strikeRate) {
        super(playerName, playerSurname, playerSport, playerTeam);
        this.runsScored = runsScored;
        this.catches = catches;
        this.wicketsTaken = wicketsTaken;
        this.strikeRate = strikeRate;

    }
}

class SportReport {
    public static void main(String[] args) {

    }
}

