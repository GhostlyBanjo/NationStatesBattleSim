package src;

/**
 * Created by Forrest on 2/28/2015.
 */
public class Outcome {

        private Team w, l;
    private int sl,sw;

    public Outcome(){

    }

    public Outcome(Team w, int scorew, Team l, int scorel) {
        this.w = w;
        this.l = l;
        this.sw = scorew;
        this.sl = scorel;
    }
    public String toString(){
        return w.getName()+" ("+sw+")" + " has defeated " + l.getName()+"("+sl+")";
    }

}
