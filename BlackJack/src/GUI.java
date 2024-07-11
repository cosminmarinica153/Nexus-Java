import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;
import java.io.*;


public class GUI extends JFrame {
    private JButton readyBtn;
    private JButton startBtn;
    private ServerClient serverClient;
    private final JButton hitBtn;
    private final JButton standBtn;
    private Player player;
    private final JTextField playerName;
    private JButton conectionBtn ;


    public GUI(){
        serverClient = new ServerClient();

        playerName = new JTextField(20);



        JLabel userName = new JLabel("Username: ");

        standBtn = new JButton("Stand");
        standBtn.setVisible(false);
        hitBtn = new JButton("Hit");
        hitBtn.setVisible(false);
        conectionBtn = new JButton("Conect");
        readyBtn = new JButton("Ready");
        startBtn = new JButton("Start");


        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        topPanel.add(userName, c);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        topPanel.add(playerName, c);
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        topPanel.add(conectionBtn, c);




        JPanel bottomPanel = new JPanel(new GridBagLayout());



        c.gridx = 7;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        bottomPanel.add(hitBtn, c);
        c.gridx = 6;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        bottomPanel.add(standBtn, c);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        bottomPanel.add(readyBtn, c);
        c.gridx = 5;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        bottomPanel.add(startBtn, c);


        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);



        conectionBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String userName = playerName.getText().trim();
                if (!userName.isEmpty()){

                    try {
                        player = new Player(userName);
                        serverClient.startConection("localhost",2222);
                        conectionBtn.setVisible(false);
                        playerName.setEditable(false);
                        hitBtn.setVisible(true);
                        standBtn.setVisible(true);
                        serverClient.sendObject(player);
                        readyBtn.setVisible(true);
                        startBtn.setVisible(true);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });

        hitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverClient.sendMessage("Hit");

            }
        });

        standBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverClient.sendMessage("Stand");
            }
        });

        readyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                serverClient.sendMessage("Ready");



            }
        });

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                serverClient.sendMessage("Start");

            }
        });





        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setVisible(true);


    }


    public static void main(String[] args) {
        GUI gui =new GUI();
        GUI gui1 =new GUI();

    }


}