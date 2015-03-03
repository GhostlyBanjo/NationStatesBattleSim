package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Forrest on 2/28/2015.
 */
public class SimulatorScreen {
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
    private JPanel outputPane;
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

    public SimulatorScreen() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                simulation = new Simulation(new Team(
                        t1Name.getText(),
                        Integer.parseInt(t1SizeInput.getText()),
                        Integer.parseInt(t1MoraleInput.getText()),
                        Integer.parseInt(t1Tech.getText()),
                        Integer.parseInt(t1TR.getText()),
                        Integer.parseInt(t1Exp.getText()),
                        Integer.parseInt(t1LR.getText()),
                                                Integer.parseInt(t1Intel.getText()),
                        true,
                        true)
                        ,new Team(
                        t2Name.getText(),
                        Integer.parseInt(t2ForceCount.getText()),
                        Integer.parseInt(t2Morale.getText()),
                        Integer.parseInt(t2Tech.getText()),
                        Integer.parseInt(t2TR.getText()),
                        Integer.parseInt(t2CE.getText()),
                        Integer.parseInt(t2L.getText()),
                                                Integer.parseInt(t2I.getText()),
                        true,true),
                        0
                );
                outputArea.setText(simulation.Simulate().toString());
                    JOptionPane.showMessageDialog(null, outputArea.getText());
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
}
