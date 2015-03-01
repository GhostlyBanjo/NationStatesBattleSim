package com.ge.NSBS.src;

/**
 * Created by Forrest on 2/28/2015.
 */
public class Outcome {

        private Team w, l;

    public Outcome(Team w, Team l) {
        this.w = w;
        this.l = l;
    }
    public String toString(){
        return w.getName() + " has defeated " + l.getName();
    }

}
