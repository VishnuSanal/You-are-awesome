package com.vishnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOkayCool, buttonNoNo;
    private JPanel buttonsJPanel;
    private JLabel awesomeLabel;

    public Dialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOkayCool);

        buttonOkayCool.addActionListener(e -> awesomeLabel.setText("Yay!"));

        buttonNoNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                moveButton();
            }
        });

        buttonNoNo.addActionListener(e -> moveButton());
        buttonOkayCool.addActionListener(e -> {

            buttonOkayCool.setVisible(false);
            buttonNoNo.setVisible(false);

        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void moveButton() {
        Random random = new Random();
        Dimension dimension = new Dimension();

        buttonsJPanel.getSize(dimension);

        buttonNoNo.setLocation(
                random.nextInt(dimension.width - buttonNoNo.getWidth()),
                random.nextInt(dimension.height - buttonNoNo.getHeight())
        );
    }

    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.pack();
        dialog.setSize(250, 250);
        dialog.setTitle("You're Awesome");
        dialog.setResizable(false);
        dialog.setVisible(true);
        System.exit(0);
    }
}
