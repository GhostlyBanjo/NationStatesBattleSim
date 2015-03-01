package com.ge.NSBS.src;

/**
 * Created by Forrest on 2/28/2015.
 */
public class Simulation {

    private Team[] team = new Team[2];
    private int[] score = new int[2];
    private int homeTeam;


    public Simulation(Team one, Team two, int homeTeam){
        team[0] = one;
        team[1] = two;
        this.homeTeam = homeTeam;
    }

    public Outcome Simulate(){

        Team winner = team[0];
        Team loser = team[1];

        Outcome outcome;
        score[homeTeam]+=5;
        score[0]+=(10*((int)(team[0].getForces()/team[1].getForces())));
        score[1]+=(10*((int)(team[1].getForces()/team[0].getForces())));
        score[Compare(team[0].getMorale(),team[1].getMorale())]+=7;
        score[Compare(team[0].getIntel(),team[1].getIntel())]+=5;
        score[Compare(team[0].getLogisticsRating(),team[1].getLogisticsRating())]+=5;
        score[Compare(team[0].getExperience(),team[1].getExperience())]+=3;
        score[Compare(team[0].getTrainingRating(),team[1].getTrainingRating())]+=2;
        score[Compare(team[0].getTech(),team[1].getTech())]+=2;


        System.out.println("one"+score[0]);
        System.out.println("Two" +score[1]);
        double ratio = ((double)score[0]/(double)score[1]);
        System.out.println(ratio);

        if( (int) (Math.random()*1000)>ratio*1000){
                winner = team[1];
                loser = team[0];
        }
        else if( (int) (Math.random()*1000)<ratio*1000){
                winner = team[0];
                loser = team[1];
        }


        return new Outcome(winner, loser);
    }
    public int Compare(int one, int two){

        if(one>two){
            return 0;
        }
        if(one<two){
            return 1;
        }
        return 0;
    }

}
