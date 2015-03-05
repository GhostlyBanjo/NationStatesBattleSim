package src;

/**
 * Created by Forrest on 2/28/2015.
 */
public class Outcome {

        private Team one, two;
    private int s2,s1;
    private OutcomeType o;

    public Outcome(){

    }

    public Outcome(OutcomeType o, Team w, int scorew, Team l, int scorel) {
        this.o=o;
        this.one = w;
        this.two = l;
        this.s1 = scorew;
        this.s2 = scorel;
    }
    public String toString(){
        switch (o){
            case WIN:return one.getName() + " has defeated " + two.getName() + "!" + "\n Score: " + s1 +" | "+ s2;
            case DRAW:
                break;
            case LOSE:
                break;

        }
        return one.getName() + " has defeated " + two.getName() + "!" + "\n Score: " + s1 +" | "+ s2;
    }

}
