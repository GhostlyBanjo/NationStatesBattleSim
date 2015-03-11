package src;

import javax.swing.*;

import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 * Created by Forrest on 2/28/2015.
 */
public class Simulation {

    private Team[] team = new Team[2];
    private int[] wins = new int[2];
    private int[] score = new int[2];
    private boolean go = true;
    private int homeTeam;


    public Simulation(Team one, Team two, int homeTeam){
        team[0] = one;
        team[1] = two;
        this.homeTeam = homeTeam;
    }

    public Outcome Simulate() {

        int rand;

        int winner = 0;
        int loser = 1;


        Outcome finalOutcome;
        OutcomeType outcome = OutcomeType.DRAW;
        do {
            rand = (int) (Math.random() * 1000);
            int one, two;
            score[homeTeam] += 5;
            score[0] += (10 * ((int) (team[0].getForces() / team[1].getForces())));
            score[1] += (10 * ((int) (team[1].getForces() / team[0].getForces())));


            CompareMorale(team[0].getMorale(), team[1].getMorale());


            one = team[0].getIntel(); two = team[1].getIntel();
            score[0]+=(7*((int)one/two));
            score[1]+=(7*((int)two/one));
            if(one>two)
                score[0]++;
            if(one<two)
                score[1]++;

            one = team[0].getLogisticsRating(); two = team[1].getLogisticsRating();
            score[0]+=(7*((int)one/two));
            score[1]+=(7*((int)two/one));
            if(one>two)
                score[0]++;
            if(one<two)
                score[1]++;

            one = team[0].getExperience(); two = team[1].getExperience();
            score[0]+=(5*((int)one/two));
            score[1]+=(5*((int)two/one));
            if(one>two)
                score[0]++;
            if(one<two)
                score[1]++;

            one = team[0].getTrainingRating(); two = team[1].getTrainingRating();
            score[0]+=(5*((int)one/two));
            score[1]+=(5*((int)two/one));
            if(one>two)
                score[0]++;
            if(one<two)
                score[1]++;
            Compare(team[0].getTech(), team[1].getTech());

            System.out.println(team[0].getName() + " " + score[0]);
            System.out.println(team[1].getName() + " " + score[1]);

            double ratio = ((double) score[0] / (score[1] + score[0]));

            System.out.println("Rand = " + rand);
            finalOutcome = new Outcome();
            if (rand >= ratio * 1000) {


                winner = 1;
                loser = 0;
                System.out.println(team[0].kill((int) (Math.random() * (((double) team[1].getForces() / (double) team[0].getForces())))));
                outcome = OutcomeType.LOSE;
            } else if (rand < ratio * 1000) {

                winner = 0;
                loser = 1;
                System.out.println(team[1].kill((int) (Math.random() * ((double) ((double) team[0].getForces() / (double) team[1].getForces())))));
                outcome = OutcomeType.WIN;
            }
            String[] options = {
                    "Continue!", "Retreat!"
            };





            if(team[0].getForces() <=0 && go){

                outcome = OutcomeType.LOSE;
                System.out.println(team[0].kill(-1 * (int) Math.abs(team[0].getForces())));
                go = false;
            }
            if(team[1].getForces() <=0 && go){
                outcome = OutcomeType.WIN;
                System.out.println(team[1].kill(-1 * (int) Math.abs(team[1].getForces())));
                go = false;

            }
            wins[winner]++;
            finalOutcome = new Outcome(outcome, team[0], wins[0], team[1], wins[1]);
            score = new int[2];
        } while (go);

        return finalOutcome;
    }



    private void CompareMorale(int one  , int two) {
        score[0]+=(10*((int)one/two));
        score[1]+=(10*((int)two/one));
    }

    public int Compare(int one, int two){

        score[0]+=(2*((int)one/two));
        score[1]+=(2*((int)two/one));
        if(one>two)
            return 0;
        if(one<two)
            return 1;
        return -1;
    }

}
enum OutcomeType{
    WIN, LOSE, DRAW
}