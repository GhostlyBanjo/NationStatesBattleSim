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
            score[homeTeam] += 5;
            score[0] += (10 * ((int) (team[0].getForces() / team[1].getForces())));
            score[1] += (10 * ((int) (team[1].getForces() / team[0].getForces())));


            CompareMorale(team[0].getMorale(), team[1].getMorale());
            Compare(team[0].getIntel(), team[1].getIntel());
            Compare(team[0].getLogisticsRating(), team[1].getLogisticsRating());
            Compare(team[0].getExperience(), team[1].getExperience());
            Compare(team[0].getTrainingRating(), team[1].getTrainingRating());
            Compare(team[0].getTech(), team[1].getTech());

            System.out.println(team[0].getName() + " " + score[0]);
            System.out.println(team[1].getName() + " " + score[1]);

            double ratio = ((double) score[0] / (score[1] + score[0]));

            System.out.println("Rand = " + rand);
            finalOutcome = new Outcome();
            if (rand >= ratio * 1000) {


                winner = 1;
                loser = 0;
            } else if (rand < ratio * 1000) {

                winner = 0;
                loser = 1;
            }
            String[] options = {
                    "Continue!", "Retreat!"
            };

            team[0].kill((int) Math.abs(Math.random() * ((team[0].getForces() / team[1].getForces()) * score[1])));
            team[1].kill((int) Math.abs(Math.random() * ((team[1].getForces() / team[0].getForces()) * score[0])));


            if(team[0].getForces() <=0 && go){

                outcome = OutcomeType.LOSE;
                team[0].kill(team[0].getForces());
                go = false;
            }
            if(team[1].getForces() <=0 && go){
                outcome = OutcomeType.WIN;
                team[1].kill(team[1].getForces());
                go = false;

            }
            wins[winner]++;
            finalOutcome = new Outcome(outcome, team[0], wins[0], team[1], wins[1]);
            JOptionPane.showMessageDialog(null, finalOutcome.toString());
            if (go &&JOptionPane.showOptionDialog(null, team[0].getName() + ", what do you do?", "Retreat?", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1) {
                outcome = OutcomeType.LOSE;
            }
            if (go && JOptionPane.showOptionDialog(null, team[1].getName() + ", what do you do?", "Retreat?", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1) {
                outcome = OutcomeType.WIN;
            }
            score = new int[2];
        } while (go);

        return finalOutcome;
    }



    private void CompareMorale(int one  , int two) {
        score[0]+=(10*((int)one/two));
        score[1]+=(10*((int)two/one));
    }

    public int Compare(int one, int two){

        score[0]+=(5*((int)one/two));
        score[1]+=(5*((int)two/one));
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