import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class StonePaper extends JFrame implements ActionListener {
    JButton stone, paper, scissor;
    JLabel scoreP, scoreC, playerOuput, computerOutput;
    int playerScore = 0, computerScore = 0, playerChoice = 0, computerChoice = 0, looseScore = 0;

    StonePaper() {
        super("Stone Paper Scissor Game");

        stone = new JButton("Stone");
        paper = new JButton("Paper");
        scissor = new JButton("Scissor");
        playerOuput = new JLabel("Player Choice: [ ]");
        computerOutput = new JLabel("Computer Choice: [ ]");
        scoreP = new JLabel("Player: [0]", JLabel.CENTER);
        scoreC = new JLabel("Computer: [0]", JLabel.CENTER);

        stone.addActionListener(this);
        paper.addActionListener(this);
        scissor.addActionListener(this);

        setVisible(true);
        setSize(260, 170);
        setLayout(new FlowLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(stone);
        add(paper);
        add(scissor);
        add(scoreP);
        add(scoreC);
        add(new JLabel("\n"));
        add(playerOuput);
        add(new JLabel("\n"));
        add(computerOutput);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Stone") {
            Random r = new Random();
            int ch_c = r.nextInt(3) + 1;
            if (ch_c > 3) {
                ch_c = 3;
            }

            playerOuput.setText("Player choice: Stone");
            if (ch_c == 1) {
                playerOuput.setText("Player choice: Stone (Draw)");
                computerOutput.setText("Computer choice: Stone (Draw)");
                // JOptionPane.showMessageDialog(null, "Draw");
            } else if (ch_c == 2) {
                computerOutput.setText("Computer choice: Paper");
                computerScore++;
                scoreC.setText("Computer: " + computerScore);
            } else if (ch_c == 3) {
                computerOutput.setText("Computer choice: Scissor");
                playerScore++;
                scoreP.setText("Player " + playerScore);
            }
        } else if (e.getActionCommand() == "Paper") {
            Random r = new Random();
            int ch_c = r.nextInt(3) + 1;
            if (ch_c > 3) {
                ch_c = 3;
            }

            playerOuput.setText("Player choice: Paper");
            if (ch_c == 2) {
                // JOptionPane.showMessageDialog(null, "Draw");
                computerOutput.setText("Computer choice: Paper (Draw)");
                playerOuput.setText("Player choice: Paper (Draw)");
            } else if (ch_c == 1) {
                computerOutput.setText("Computer choice: Stone");
                playerScore++;
                scoreP.setText("Player: " + playerScore);
            } else if (ch_c == 3) {
                computerOutput.setText("Computer choice: Scissor");
                computerScore++;
                scoreC.setText("Computer: " + computerScore);
            }
        } else if (e.getActionCommand() == "Scissor") {
            Random r = new Random();
            int ch_c = r.nextInt(3) + 1;
            if (ch_c > 3) {
                ch_c = 3;
            }
            playerOuput.setText("Player choice: Scissor");
            if (ch_c == 3) {
                playerOuput.setText("Player choice: Scissor (Draw)");
                computerOutput.setText("Computer choice: Scissor (Draw)");
            } else if (ch_c == 2) {
                computerOutput.setText("Computer choice: Paper");
                playerScore++;
                scoreP.setText("Player: " + playerScore);
            } else if (ch_c == 1) {
                computerOutput.setText("Computer choice: Stone");
                computerScore++;
                scoreC.setText("Computer: " + computerScore);
            }
        }

        if (playerScore == 10) {
            JOptionPane.showMessageDialog(null, "Congratulations, You win!");
            playerScore = 0;
            computerScore = 0;
            scoreP.setText("Player: " + playerScore);
            scoreC.setText("Computer: " + computerScore);
            looseScore = 0;
        } else if (computerScore == 10) {
            JOptionPane.showMessageDialog(null, "You loose!. Try again");
            playerScore = 0;
            computerScore = 0;
            scoreP.setText("Player: " + playerScore);
            scoreC.setText("Computer: " + computerScore);
            playerScore = 3;
        }
    }

    public static void main(String[] args) {
        new StonePaper();
    }
}
