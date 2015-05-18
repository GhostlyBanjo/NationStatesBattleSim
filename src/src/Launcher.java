package src;

import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Forrest on 3/8/2015.
 */
public class Launcher {
    private static JFrame launchFrame;

    private JLabel img;
    private JLabel titleLabel = new JLabel("Nation States Battle Simulator");
    private JPanel panel = new JPanel();
    private JButton button1 = new JButton("Launch Simulator ");


    public Launcher() {
        img = new JLabel(new ImageIcon("imgs/NSBS.jpg"));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.setLayout(new BorderLayout());
        panel.add(titleLabel,BorderLayout.NORTH);
        panel.add(img,BorderLayout.CENTER);
        panel.add(button1,BorderLayout.SOUTH);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulatorScreen.main(new String[] {});
                launchFrame.setVisible(false);
            }
        });
        launchFrame.setLayout(new FlowLayout());
        launchFrame.add(panel);
        launchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        launchFrame.pack();
        launchFrame.setVisible(true);
    }

    public static void main(String[] args) {

        launchFrame = new JFrame("Nation States Battle Simulator");
        new Launcher();


    }

}
