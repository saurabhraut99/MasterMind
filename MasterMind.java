import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MasterMind {
	static JFrame f = new JFrame("MASTER MIND");
	static JLabel buffer = new JLabel();
	static String optionColours[] = { "red", "yellow", "blue", "green", "white", "black" };
	static String optionColoursz[] = { "Select Colour", "red", "yellow", "blue", "green", "white", "black" };
	static ArrayList<String> optionsArray;
	static String[] tryColours = new String[4];
	static String[] randomColours = null;
	static JComboBox cb1, cb2, cb3, cb4;
	static JButton b;
	static ArrayList<JLabel> afterCheck = new ArrayList<JLabel>();
	static ArrayList<String> bingos = new ArrayList<String>();
	static int tryTotal = 5;
	static JButton quitB = new JButton("QUIT");
	static JDialog name = new JDialog(f, true);
	static JDialog help = new JDialog(f, "HELP", true);
	static JTextField input = new JTextField("Enter your name");
	static String nameString;
	static JLabel rule1 = new JLabel("⦿ Select 4 colours from the dropdown");
	static JLabel rule2 = new JLabel(" menu and press check.             ");
	static JLabel rule3 = new JLabel("⦿ Decide the colours and their location");
	static JLabel rule4 = new JLabel("based on the message that appears.  ");
	static JLabel rule5 = new JLabel("⦿ Each player will get only 5 chances.");

	public static void main(String[] args) {
		f.getContentPane().setBackground(Color.red);
		name.setBounds(208, 275, 300, 100);
		name.getContentPane().setBackground(Color.CYAN);
		help.setBounds(100, 350, 500, 300);
		help.getContentPane().setBackground(Color.CYAN);
		rule1.setFont(new Font("Calibri", Font.BOLD, 30));
		rule1.setVisible(true);
		rule2.setFont(new Font("Calibri", Font.BOLD, 30));
		rule2.setVisible(true);
		rule3.setFont(new Font("Calibri", Font.BOLD, 30));
		rule3.setVisible(true);
		rule4.setFont(new Font("Calibri", Font.BOLD, 30));
		rule4.setVisible(true);
		rule5.setFont(new Font("Calibri", Font.BOLD, 30));
		rule5.setVisible(true);
		help.add(rule1);
		help.add(rule2);
		help.add(rule3);
		help.add(rule4);
		help.add(rule5);
		input.setFont(new Font("Calibri", Font.BOLD, 20));
		name.add(input);
		name.setLayout(new FlowLayout());
		help.setLayout(new FlowLayout());
		JButton ok = new JButton("OK");
		ok.setFont(new Font("Calibri", Font.BOLD, 15));
		JButton helpQuit = new JButton("OK");
		ok.setFont(new Font("Calibri", Font.BOLD, 30));
		help.add(helpQuit);
		name.add(ok);
		ok.setVisible(true);
		final JLabel title = new JLabel("MASTER MIND");
		title.setBounds(100, 100, 500, 200);
		title.setFont(new Font("Calibri", Font.ITALIC, 83));
		f.add(title);
		title.setVisible(true);
		final JButton startB = new JButton("START");
		startB.setBounds(250, 350, 200, 50);
		f.add(startB);
		startB.setFont(new Font("Calibri", Font.BOLD, 45));

		quitB.setBounds(250, 500, 200, 50);
		f.add(quitB);
		quitB.setFont(new Font("Calibri", Font.BOLD, 45));
		b = new JButton("CHECK");
		b.setBounds(250, 320, 200, 50);
		f.add(b);
		b.setFont(new Font("Calibri", Font.BOLD, 45));
		final JLabel cl = new JLabel();
		cl.setBounds(275, 400, 150, 60);
		f.add(cl);
		cl.setFont(new Font("Calibri", Font.BOLD, 23));
		startB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setVisible(true);
			}
		});

		helpQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help.dispose();
			}
		});
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameString = input.getText();
				System.out.println(nameString);
				cb1.setVisible(true);
				cb2.setVisible(true);
				cb3.setVisible(true);
				cb4.setVisible(true);
				b.setVisible(true);
				cl.setVisible(true);
				startB.setVisible(false);

				System.out.println("help false");
				title.setVisible(false);
				b.setVisible(true);
				quitB.setBounds(250, 550, 200, 50);
				name.dispose();
			}
		});
		quitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cb1 = new JComboBox(optionColoursz);
		cb1.setBounds(25, 50, 140, 30);
		f.add(cb1);
		cb1.setFont(new Font("Calibri", Font.BOLD, 20));
		cb2 = new JComboBox(optionColoursz);
		cb2.setBounds(190, 50, 140, 30);
		f.add(cb2);
		cb2.setFont(new Font("Calibri", Font.BOLD, 20));
		cb3 = new JComboBox(optionColoursz);
		cb3.setBounds(355, 50, 140, 30);
		f.add(cb3);
		cb3.setFont(new Font("Calibri", Font.BOLD, 20));
		cb4 = new JComboBox(optionColoursz);
		cb4.setBounds(520, 50, 140, 30);
		f.add(cb4);
		cb4.setFont(new Font("Calibri", Font.BOLD, 20));
		try {
			cb1.setVisible(false);
			cb2.setVisible(false);
			cb3.setVisible(false);
			cb4.setVisible(false);
			b.setVisible(false);
			cl.setVisible(false);
		} catch (NullPointerException eff) {
		}
		JLabel l1 = new JLabel();
		l1.setBounds(35, 100, 130, 30);
		f.add(l1);
		l1.setFont(new Font("Serif", Font.BOLD, 15));
		JLabel l2 = new JLabel();
		l2.setBounds(200, 100, 130, 30);
		f.add(l2);
		l2.setFont(new Font("Serif", Font.BOLD, 15));
		JLabel l3 = new JLabel();
		l3.setBounds(365, 100, 130, 30);
		f.add(l3);
		l3.setFont(new Font("Serif", Font.BOLD, 15));
		JLabel l4 = new JLabel();
		l4.setBounds(530, 100, 130, 30);
		f.add(l4);
		l4.setFont(new Font("Serif", Font.BOLD, 15));

		afterCheck.addAll(Arrays.asList(l1, l2, l3, l4, cl));
		afterCheck.get(4).setText("Chances left: " + tryTotal);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				bingos.clear();
				if (tryTotal > 0) {
					random4();
					tryColours[0] = (String) cb1.getItemAt(cb1.getSelectedIndex());
					tryColours[1] = (String) cb2.getItemAt(cb2.getSelectedIndex());
					tryColours[2] = (String) cb3.getItemAt(cb3.getSelectedIndex());
					tryColours[3] = (String) cb4.getItemAt(cb4.getSelectedIndex());
					for (int i = 0; i < tryColours.length; i++) {
						if (tryColours[i].equals(randomColours[i])) {
//                        afterCheck.get(i).setText("BINGO");
							bingos.add(tryColours[i]);
//                        continue;
						}

					}
					for (int i = 0; i < tryColours.length; i++) {
						if (tryColours[i].equals(randomColours[i])) {
							afterCheck.get(i).setText("BINGO");
//                        bingos.add(tryColours[i]);
							continue;
						}
						for (int k = 0; k < 4; k++) {
							if (tryColours[i].equals(randomColours[k])) {
								if (bingos.contains(tryColours[i])) {
									continue;
								}
								afterCheck.get(i).setFont(new Font("Calibri", Font.BOLD, 15));
								afterCheck.get(i).setText("Colour Exists");
								break;
							} else {
								afterCheck.get(i).setFont(new Font("Calibri", Font.BOLD, 15));
								afterCheck.get(i).setText("Color doesn't exist");
							}
						}
					}

					if ((tryTotal - 1) > 0 && (tryTotal - 1) < 6) {
						if (bingos.size() == 4) {
							afterCheck.get(4).setText("");
						} else {
							afterCheck.get(4).setText("Chances left: " + (tryTotal - 1));
						}
					} else {
						afterCheck.get(4).setText("");
					}
					tryTotal--;
					visible(true);
					if (bingos.size() == 4) {
						quitB.setVisible(false);
						winnerWinner();
						visible(false);
						cb1.setVisible(false);
						cb2.setVisible(false);
						cb3.setVisible(false);
						cb4.setVisible(false);
						b.setVisible(false);
					}
				}
				if (tryTotal == 0 && bingos.size() != 4) {
					afterCheck.get(4).setText("");
					quitB.setVisible(false);
					loserLoser();
					visible(false);
					cb1.setVisible(false);
					cb2.setVisible(false);
					cb3.setVisible(false);
					cb4.setVisible(false);
					b.setVisible(false);
					System.out.println("khatam");
				}
			}
		});
		f.setSize(700, 700);
		f.setLayout(null);
		f.setVisible(true);
	}

	static void winnerWinner() {
		System.out.println("calling winner");
		System.out.println("True winner");
		final JLabel ww = new JLabel("WINNER WINNER JAIN DINNER!");
		f.add(ww);
		f.add(buffer);
		// JLabel jd =new JLabel(" JAIN DINNER!"); f.add(jd);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				buffer.setForeground(Color.WHITE);
				buffer.setBounds(250, 300, 200, 50);
				buffer.setFont(new Font("Calibri", Font.BOLD, 100));
				System.out.println("buffer");
				for (int t = 0; t < 3; t++) {
					buffer.setText("  .");
					try {
						Thread.sleep(300);
					} catch (Exception e) {
					}
					buffer.setText("  ..");
					try {
						Thread.sleep(300);
					} catch (Exception e) {
					}
					buffer.setText("  ...");
					try {
						Thread.sleep(300);
					} catch (Exception e) {
					}
					buffer.setText("  ....");
					try {
						Thread.sleep(300);
					} catch (Exception e) {
					}
				}
				buffer.setVisible(false);
				for (int i = 1; i < 30; i++) {
					try {
						Thread.sleep(20);
						// f.getContentPane().setBackground(new
						// Color(255-(i+i+i+i+i+i+i+i+i+i+i+i),255-(i+i+i+i+i+i+i+i+i+i+i+i),255-(i+i+i+i+i+i+i+i+i+i+i+i)));
						ww.setBounds(i + i + i, 250, 700, 150);// jd.setBounds(475-i-i-i,350,700,150);
						ww.setFont(new Font("Calibri", Font.BOLD, 40)); // jd.setFont(new Font("Serif",Font.BOLD,35));
					} catch (Exception ffe) {

					}
				}
			}
		});
		ww.setForeground(Color.WHITE);
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("in t2");
				for (int j = 1; j < 256; j++) {
					try {

						Thread.sleep(25);
						f.getContentPane().setBackground(new Color(j, 0, 0));
						// quitB.setBackground(new Color(j,0,0));
					} catch (Exception ffe) {

					}
				}

				for (int j = 1; j < 256; j++) {
					try {
						Thread.sleep(25);
						f.getContentPane().setBackground(new Color(255 - j, j, 0));
						// quitB.setBackground(new Color(255-j,j,0));
					} catch (Exception ffe) {

					}
				}
				for (int j = 1; j < 256; j++) {
					try {
						Thread.sleep(25);
						f.getContentPane().setBackground(new Color(0, 255 - j, j));
						// quitB.setBackground(new Color(0,255-j,j));
					} catch (Exception ffe) {

					}
				}
				System.exit(0);
			}
		});
		t1.start();
		t2.start();
	}

	static void loserLoser() {
		System.out.println("calling loser");
		System.out.println("True loser");
		// JLabel ll1 = new JLabel("WINNER WINNER JAIN DINNER!"); f.add(ll1);
		final JLabel admin1 = new JLabel();
		f.add(admin1);
		final JLabel admin2 = new JLabel();
		f.add(admin2);
		final JLabel admin3 = new JLabel();
		f.add(admin3);
		final JLabel admin4 = new JLabel();
		f.add(admin4);
		final JLabel playerName1 = new JLabel();
		f.add(playerName1);
		final JLabel playerName2 = new JLabel();
		f.add(playerName2);
		final JLabel buffer1 = new JLabel();
		f.add(buffer1);
		final JLabel buffer2 = new JLabel();
		f.add(buffer2);
		final JLabel buffer3 = new JLabel();
		f.add(buffer3);
		final JLabel buffer4 = new JLabel();
		f.add(buffer4);
		final JLabel buffer5 = new JLabel();
		f.add(buffer5);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				buffer1.setForeground(Color.WHITE);
				buffer2.setForeground(Color.WHITE);
				buffer3.setForeground(Color.WHITE);
				buffer4.setForeground(Color.WHITE);
				buffer5.setForeground(Color.WHITE);
				admin1.setForeground(Color.white);
				playerName1.setForeground(Color.white);
				admin2.setForeground(Color.white);
				playerName2.setForeground(Color.white);
				admin3.setForeground(Color.white);
				admin4.setForeground(Color.white);
				System.out.println("buffer");
				admin1.setBounds(0, 50, 700, 50);
				admin1.setFont(new Font("Calibri", Font.BOLD, 25));
				admin2.setBounds(0, 75, 700, 50);
				admin2.setFont(new Font("Calibri", Font.BOLD, 25));
				buffer1.setBounds(0, 100, 700, 50);
				buffer1.setFont(new Font("Calibri", Font.BOLD, 25));
				buffer2.setBounds(0, 125, 700, 50);
				buffer2.setFont(new Font("Calibri", Font.BOLD, 25));
				buffer3.setBounds(0, 150, 700, 50);
				buffer3.setFont(new Font("Calibri", Font.BOLD, 25));
				playerName1.setBounds(480, 200, 700, 50);
				playerName1.setFont(new Font("Calibri", Font.BOLD, 25));
				playerName2.setBounds(480, 225, 700, 50);
				playerName2.setFont(new Font("Calibri", Font.BOLD, 25));
				buffer4.setBounds(480, 250, 250, 50);
				buffer4.setFont(new Font("Calibri", Font.BOLD, 25));
				admin3.setBounds(0, 300, 700, 50);
				admin3.setFont(new Font("Calibri", Font.BOLD, 25));
				admin4.setBounds(0, 325, 700, 50);
				admin4.setFont(new Font("Calibri", Font.BOLD, 25));
				buffer5.setBounds(0, 350, 700, 50);
				buffer5.setFont(new Font("Calibri", Font.BOLD, 25));

				buffer1.setText("                                                            LOSER");

			}
		});
		// ww.setForeground(Color.WHITE);
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("in t2");
				for (int y = 0; y < 11; y++) {
					for (int j = 1; j < 256; j++) {
						try {
							Thread.sleep(5);
							f.getContentPane().setBackground(new Color(j, 0, 0));
							// quitB.setBackground(new Color(j,0,0));
						} catch (Exception ffe) {
						}
					}
					for (int j = 1; j < 256; j++) {
						try {
							Thread.sleep(5);
							f.getContentPane().setBackground(new Color(256 - j, 0, 0));
							// quitB.setBackground(new Color(j,0,0));
						} catch (Exception ffe) {

						}
					}
				}
				System.exit(0);
			}
		});
		t1.start();
		t2.start();
	}

	static void random4() {
		if (randomColours != null) {
			return;
		}
		optionsArray = new ArrayList(Arrays.asList(optionColours));
		System.out.println("size " + optionsArray.size());

		randomColours = new String[4];
		for (int i = 0; i < 4; i++) {
			Random random = new Random();
			int randomIndex = random.nextInt(optionsArray.size());
			randomColours[i] = optionsArray.get(randomIndex);
			optionsArray.remove(randomIndex);
			System.out.println(randomColours[i]);
		}
	}

	static void visible(boolean visiblity) {
		for (int i = 0; i < afterCheck.size(); i++) {
			afterCheck.get(i).setVisible(visiblity);
		}
	}
}
