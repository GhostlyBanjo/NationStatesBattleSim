package src;

/**
 * Created by Forrest on 2/28/2015.
 */
public class Team {
    public int getForces() {
        return forces;
    }

    public int getMorale() {
        return morale;
    }

    public int getTech() {
        return tech;
    }

    public int getTrainingRating() {
        return trainingRating;
    }

    public int getExperience() {
        return experience;
    }

    public int getLogisticsRating() {
        return logisticsRating;
    }
    public int getIntel() {
        return intel;
    }


    public boolean isHomeTeam() {
        return homeTeam;
    }

    public boolean isTakesPOW() {
        return takesPOW;
    }
    private String name;
    private int forces;
    private int morale;
    private int tech;
    private int trainingRating;
    private int experience;
    private int logisticsRating;
    private int intel;
    private boolean homeTeam, takesPOW;


    public String getName() {
        return name;
    }

    public Team(String name, int forces, int morale, int tech, int trainingRating, int experience, int logisticsRating, int intel, boolean homeTeam, boolean takesPOW) {
        this.name = name;
        this.forces = forces;
        this.morale = morale;
        this.tech = tech;
        this.trainingRating = trainingRating;
        this.experience = experience;
        this.logisticsRating = logisticsRating;
        this.homeTeam = homeTeam;
        this.takesPOW = takesPOW;

        this.intel = intel;
    }

}
