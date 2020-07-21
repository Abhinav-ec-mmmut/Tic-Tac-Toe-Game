import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import java.awt.*;

public class Game implements ActionListener {

	Random random;
	boolean player1_turn;
	JFrame frame;
	JPanel button_panel;
	JLabel label;
	JButton[] buttons;

	Game() {
		random = new Random();

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		label = new JLabel();
		label.setBounds(0, 0, 600, 100);
		label.setBackground(new Color(50, 50, 50));
		label.setForeground(Color.green);
		label.setFont(new Font("Monotype Corsiva", Font.BOLD, 75));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic-Tac-Toe");
		label.setOpaque(true);

		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(150, 150, 150));
		buttons = new JButton[9];

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttons[i].setFont(new Font("Ink Free", Font.BOLD, 120));
			buttons[i].addActionListener(this);
			buttons[i].setFocusable(false);
			button_panel.add(buttons[i]);
		}

		frame.add(button_panel);
		frame.add(label, BorderLayout.NORTH);

		Turn();
	}

	public void Turn() {
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (random.nextInt(2) == 0) {
			player1_turn = true;
			label.setText("X turn");
		} else {
			player1_turn = false;
			label.setText("O turn");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player1_turn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1_turn = false;
						label.setText("O turn");
						check();
					}

				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						player1_turn = true;
						label.setText("X turn");
						check();
					}
				}
			}
		}
	}

	public void check() {
		// x win check
		if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}
		// o win check
		if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			oWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(2, 4, 6);
		}
	}

	public void xWins(int a, int b, int c) {
		
		label.setText("X wins");
		buttons[a].setBackground(new Color(0, 255, 0));
		buttons[b].setBackground(new Color(0, 255, 0));
		buttons[c].setBackground(new Color(0, 255, 0));
		for (int i = 0; i < 9; i++)
			buttons[i].setEnabled(false);
	}

	public void oWins(int a, int b, int c) {
		
		label.setText("O wins");
		buttons[a].setBackground(new Color(0, 255, 0));
		buttons[b].setBackground(new Color(0, 255, 0));
		buttons[c].setBackground(new Color(0, 255, 0));
		for (int i = 0; i < 9; i++)
			buttons[i].setEnabled(false);
	}

}
