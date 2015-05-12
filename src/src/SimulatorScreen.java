package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Forrest on 2/28/2015.
 */
public class SimulatorScreen {
    private static boolean run = true;
    private Simulation simulation;
    private JTextField t1Name;
    private JLabel team1;
    private JLabel team2;
    private JTextField t2Name;
    private JLabel team1Size;
    private JTextField t1SizeInput;
    private JLabel t2SizeInput;
    private JTextField t2ForceCount;
    private JPanel panel1;
    private JButton runButton;
    private JLabel teamOneMorale;
    private JTextField t1MoraleInput;
    private JTextField t1Tech;
    private JTextField t1TR;
    private JTextField t1Exp;
    private JTextField t1LR;
    private JTextField t1Supply;
    private JTextField t1Intel;
    private JLabel t1labels;
    private JLabel eff;
    private JLabel nword;
    private JLabel ugh;
    private JLabel teamOneIntelLabel;
    private JTextField t2Morale;
    private JLabel no;
    private JLabel noMoreVariablesplz;
    private JLabel cantSayTheNWord;
    private JTextField t2Tech;
    private JTextField t2TR;
    private JTextField t2CE;
    private JTextField t2L;
    private JTextField t2S;
    private JTextField t2I;
    private JLabel notavirus;
    private JLabel noplzno;
    private JLabel plzgo;
    private JPanel inputPanel;
    private JTabbedPane tabbedPane;
    private JPanel outputPanel;
    private JTextArea outputArea;
    private JTextField t2name;
    private JTextField t1name;
    private JTextField t1fc;
    private JSlider t1m;
    private JSlider t1t;
    private JSlider t1tr;
    private JSlider t1ce;
    private JSlider t1l;
    private JSlider t1i;
    private JTextField t2fc;
    private JSlider t2m;
    private JSlider t2t;
    private JSlider t2tr;
    private JSlider t2ce;
    private JSlider t2l;
    private JSlider t2i;
    private JTextArea outputText;
    private JScrollPane scrollPane;

    public SimulatorScreen() {
        outputText.setText("This is the output screen");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                simulation = new Simulation(new Team(
                        t1name.getText(),
                        Integer.parseInt(t1fc.getText()),
                        t1m.getValue(),
                        t1t.getValue(),
                        t1tr.getValue(),
                        t1ce.getValue(),
                        t1l.getValue(),
                        t1i.getValue())
                        ,new Team(
                        t2name.getText(),
                        Integer.parseInt(t2fc.getText()),
                        t2m.getValue(),
                        t2t.getValue(),
                        t2tr.getValue(),
                        t2ce.getValue(),
                        t2l.getValue(),
                        t2i.getValue()),
                        0
                );

                    do{
                       addNewText();
                    }while(run);
                }
                catch(NumberFormatException exception){
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Try inputing the right things");
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimulatorScreen");
        frame.setContentPane(new SimulatorScreen().tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void out(String in){

    }
    public static void Stop(){
        run = false;
    }

    public void addNewText(){
        outputText.append(simulation.Simulate().toString());
    }
}
