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
    public int goalsScored;
    public String league;
    public String fieldPosition;
    public FootballStats(String playerName, String playerSurname, String playerSport, String playerTeam,
                         int goalsScored, String league, String fieldPosition) {
        super(playerName, playerSurname, playerSport, playerTeam);

        this.goalsScored = goalsScored;
        this.league = league;
        this.fieldPosition = fieldPosition;
    }
}
class CricketStats extends PlayerStats{
    public int pointsScored;
    public String league;
    public float playerShoeSize;
    public double playerHeight;

    public CricketStats(String playerName, String playerSurname, String playerSport, String playerTeam,
                         int pointsScored, String league, float playerShoeSize, double playerHeight) {
        super(playerName, playerSurname, playerSport, playerTeam);

        this.pointsScored = pointsScored;
        this.league = league;
        this.playerShoeSize = playerShoeSize;
        this.playerHeight = playerHeight;
    }
}
class SportReport {
    public static void main (String[] args) {

    }
}
