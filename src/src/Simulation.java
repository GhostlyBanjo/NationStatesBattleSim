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
    private boolean go;
    private int homeTeam;


    public Simulation(Team one, Team two, int homeTeam){
        team[0] = one;
        team[1] = two;
        this.homeTeam = homeTeam;
    }

    public Outcome Simulate() {

        int rand = (int) (Math.random() * 1000);

        int winner = 0;


        Outcome outcome;
        do {

            score[homeTeam] += 5;
            score[0] += (10 * ((int) (team[0].getForces() / team[1].getForces())));
            score[1] += (10 * ((int) (team[1].getForces() / team[0].getForces())));


            CompareMorale(team[0].getMorale(), team[1].getMorale());
            Compare(team[0].getIntel(), team[1].getIntel());
            Compare(team[0].getLogisticsRating(), team[1].getLogisticsRating());
            Compare(team[0].getExperience(), team[1].getExperience());
            Compare(team[0].getTrainingRating(), team[1].getTrainingRating());
            Compare(team[0].getTech(), team[1].getTech());

            System.out.println(team[0] + " " + score[0]);
            System.out.println(team[1] + " " + score[1]);

            int total = score[1] + score[0];
            double ratio = ((double) score[0] / total);


            System.out.println("Rand = " + rand);
            outcome = new Outcome();
            if (rand >= ratio * 1000) {
                outcome = new Outcome(team[1], score[1], team[0], score[0]);
                winner = 1;
            } else if (rand < ratio * 1000) {

                outcome = new Outcome(team[0], score[0], team[1], score[1]);
                winner = 0;
            }
            String[] options = {
                    "Continue!", "Retreat!"
            };
            if (JOptionPane.showOptionDialog(null, outcome.toString(), "Retreat?", YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1) {
                go = false;
            }
            wins[winner]++;
            score = new int[2];
        } while (go);

        if (winner == 0) {
            return new Outcome(team[0], wins[0], team[1], wins[1]);
        }
        if (winner == 1) {
            return new Outcome(team[1], wins[1], team[0], wins[0]);
        }
        if (winner == 0) {
            return new Outcome(team[0], wins[0], team[1], wins[1]);
        }
        return null;
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
