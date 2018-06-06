package talkbox;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

// A DAMON PRODUCT

// TODO: Scale winodw's size? 
// TODO: History functionality?
// TODO: Change all names if any name input is changed.

public class Window {
	private static String finalStr;
	private static String currentFileName;
	private static String currentFileDir;
	private static FunctionHandler fh;

	private JTextField qesNameInput;
	private JTextField ansNameInput;
	private JTextField yearInput;
	private JTextField monthInput;
	private JTextField dayInput;
	private JTextField locationInput;
	private JTextField fileNameInput;

	public Window() {
		String finalStr = new String();
		Window.finalStr = finalStr;
		String currentFileName = null;
		Window.currentFileName = currentFileName;
		String currentFileDir = null;
		Window.currentFileDir = currentFileDir;
		Window.fh = new FunctionHandler();

		// ========== Main Window ==========
		JFrame mainJFrame = new JFrame("mainJFrame");
		mainJFrame.setTitle("TalkBox");
		mainJFrame.setSize(1250, 900);
		mainJFrame.setLocation(300, 200);
		mainJFrame.getContentPane().setLayout(null);

		// ========== Final product panel ==========
		JPanel productPanel = new JPanel();
		productPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		productPanel.setBounds(897, 6, 347, 829);
		mainJFrame.getContentPane().add(productPanel);
		productPanel.setLayout(null);

		JTextPane productTextPanel = new JTextPane();
		productTextPanel.setBounds(6, 6, 335, 817);
		productTextPanel.setForeground(Color.BLACK);
		productTextPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		productPanel.add(productTextPanel);

		// ========== Basic information Panel ==========
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoPanel.setBounds(6, 6, 750, 210);
		mainJFrame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);

		JLabel qesLabel = new JLabel("Questioner's Name");
		qesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qesLabel.setBounds(6, 47, 143, 29);
		infoPanel.add(qesLabel);

		JLabel dirLabel = new JLabel("Empty Directory");
		dirLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dirLabel.setBounds(175, 6, 569, 29);
		infoPanel.add(dirLabel);

		qesNameInput = new JTextField();
		qesNameInput.setBounds(175, 48, 130, 26);
		infoPanel.add(qesNameInput);
		qesNameInput.setColumns(10);

		JLabel anslabel = new JLabel("Answerer's Name");
		anslabel.setHorizontalAlignment(SwingConstants.CENTER);
		anslabel.setBounds(6, 88, 143, 29);
		infoPanel.add(anslabel);

		ansNameInput = new JTextField();
		ansNameInput.setColumns(10);
		ansNameInput.setBounds(175, 89, 130, 26);
		infoPanel.add(ansNameInput);

		JLabel dateLabel = new JLabel("Date");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setBounds(6, 129, 143, 29);
		infoPanel.add(dateLabel);

		yearInput = new JTextField();
		yearInput.setColumns(10);
		yearInput.setBounds(175, 130, 66, 26);
		infoPanel.add(yearInput);

		monthInput = new JTextField();
		monthInput.setColumns(10);
		monthInput.setBounds(239, 130, 66, 26);
		infoPanel.add(monthInput);

		dayInput = new JTextField();
		dayInput.setColumns(10);
		dayInput.setBounds(304, 130, 66, 26);
		infoPanel.add(dayInput);

		JLabel locationLabel = new JLabel("Location");
		locationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		locationLabel.setBounds(6, 170, 143, 29);
		infoPanel.add(locationLabel);

		locationInput = new JTextField();
		locationInput.setColumns(10);
		locationInput.setBounds(175, 171, 130, 26);
		infoPanel.add(locationInput);

		JLabel fileNameLabel = new JLabel("File Name");
		fileNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fileNameLabel.setBounds(382, 47, 143, 29);
		infoPanel.add(fileNameLabel);

		fileNameInput = new JTextField();
		fileNameInput.setColumns(10);
		fileNameInput.setBounds(537, 48, 130, 26);
		infoPanel.add(fileNameInput);

		JButton dirBut = new JButton("Select Directory");
		dirBut.setBounds(6, 6, 143, 29);
		infoPanel.add(dirBut);

		// ========== TextPanel ==========
		JPanel textPanel = new JPanel();
		textPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPanel.setBounds(6, 231, 750, 641);
		mainJFrame.getContentPane().add(textPanel);
		textPanel.setLayout(null);

		JLabel qesLabel2 = new JLabel("Question");
		qesLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		qesLabel2.setBounds(6, 6, 738, 29);
		textPanel.add(qesLabel2);

		JLabel ansLabel2 = new JLabel("Answer");
		ansLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		ansLabel2.setBounds(6, 236, 738, 29);
		textPanel.add(ansLabel2);

		JTextPane qesInput = new JTextPane();
		qesInput.setBounds(6, 47, 738, 174);
		qesInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPanel.add(qesInput);

		JTextPane ansInput = new JTextPane();
		ansInput.setBounds(6, 277, 738, 358);
		ansInput.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPanel.add(ansInput);

		// ========== Buttons ==========
		JButton pushBut = new JButton(">");
		pushBut.setBounds(768, 806, 117, 29);
		mainJFrame.getContentPane().add(pushBut);

		// JButton pullBut = new JButton("<");
		// pullBut.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// }
		// });
		// pullBut.setBounds(768, 750, 117, 29);
		// mainJFrame.getContentPane().add(pullBut);

		JButton exportBut = new JButton("Save");
		exportBut.setBounds(1020, 843, 117, 29);
		mainJFrame.getContentPane().add(exportBut);

		// ========== Listeners ==========
		// Select a file.
		dirBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Choose a file/directory");
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					String selectedFileName = file.getName();
					String selectedFileDir = file.getParent().toString();

					// Case 1: A txt file is selected.
					if (file.exists() && selectedFileName.toLowerCase().endsWith(".txt")) {
						// Case 1.1: Check if this is the first time to select a file.
						if (Window.currentFileName == null && Window.currentFileDir == null) {
							Window.currentFileName = selectedFileName;
							Window.currentFileDir = selectedFileDir;

							// Case 1.2: Check if the selected file is the same file.
						} else if (Window.currentFileName.equals(selectedFileName)
								&& Window.currentFileDir.equals(selectedFileDir)) {
							JInternalFrame frame = new JInternalFrame();
							JOptionPane.showMessageDialog(frame, "Same file.", "File warning",
									JOptionPane.WARNING_MESSAGE);
							return;
						}

						// Case 1.3: Successful.
						Window.currentFileName = selectedFileName;
						Window.currentFileDir = selectedFileDir;
						BufferedReader br;
						String buff;
						// Clear the previous finalStr after the new import.
						Window.finalStr = "";

						try {
							br = new BufferedReader(new FileReader(file));
							buff = br.readLine();

							// Load the interview's basic info.
							for (int i = 0; i < 4; i++) {

								switch (buff.substring(0, 1)) {
								case "L":
									locationInput.setText(buff.substring(10, buff.length()));
									break;
								case "T":
									yearInput.setText(buff.substring(6, 10));
									monthInput.setText(buff.substring(11, 13));
									dayInput.setText(buff.substring(14, 16));
									break;
								case "Q":
									qesNameInput.setText(buff.substring(3, 6));
									break;
								case "A":
									ansNameInput.setText(buff.substring(3, 6));
									break;
								}

								buff = br.readLine();
							}

							// Load the content of the interview.
							while ((buff = br.readLine()) != null) {
								Window.finalStr += buff + "\n";
							}

							// Text's content.
							productTextPanel.setText(Window.finalStr);
							// File's Name.
							dirLabel.setText(chooser.getSelectedFile().getParent().toString());
							fileNameInput.setText(selectedFileName.substring(0, selectedFileName.length() - 4));

						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e2) {
							e2.printStackTrace();
						}

						// Case 2: a directory is selected
					} else if (file.isDirectory()) {
						dirLabel.setText(chooser.getSelectedFile().getAbsolutePath().toString());

						// Case 3: The selected file doesn't end with .txt.
					} else if (file.exists() && !selectedFileName.toLowerCase().endsWith(".txt")) {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "The selected file is not a .txt file.", "Type error",
								JOptionPane.ERROR_MESSAGE);

						if (Window.currentFileDir == null) {
							dirLabel.setText("No Selection");
						}

						// Case 4: Didn't select any file.
					} else if (Window.currentFileDir == null) {
						dirLabel.setText("No Selection");
					}
				}
			}
		});

		// Push the text content to the productTextPanel.
		qesInput.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Question/Answer's name can't be empty.
					if (fh.doubleRECheck(qesNameInput.getText())) {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "Question's Name can't be empty.", "Name warning",
								JOptionPane.WARNING_MESSAGE);
						return;

					} else if (fh.doubleRECheck(ansNameInput.getText())) {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "Answer's Name can't be empty.", "Name warning",
								JOptionPane.WARNING_MESSAGE);
						return;

						// Only include the question/answer that is not empty.
					} else {
						if (!fh.doubleRECheck(qesInput.getText())) {
							Window.finalStr += qesNameInput.getText() + ": " + qesInput.getText() + "\n\n";
							qesInput.setText("");
						}

						if (!fh.doubleRECheck(ansInput.getText())) {
							Window.finalStr += ansNameInput.getText() + ": " + ansInput.getText() + "\n\n";
							ansInput.setText("");
						}

						productTextPanel.setText(Window.finalStr);
					}
				}

				// Move the cursor down to ansInput.
				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
					ansInput.requestFocus();
				}

				// Move the cursor right to productTextPanel.
				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
					productTextPanel.requestFocus();
				}
			}
		});

		ansInput.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Question/Answer's name can't be empty.
					if (fh.doubleRECheck(qesNameInput.getText())) {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "Question's Name can't be empty.", "Name warning",
								JOptionPane.WARNING_MESSAGE);
						return;

					} else if (fh.doubleRECheck(ansNameInput.getText())) {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "Answer's Name can't be empty.", "Name warning",
								JOptionPane.WARNING_MESSAGE);
						return;

						// Only include the question/answer that is not empty.
					} else {
						if (!fh.doubleRECheck(qesInput.getText())) {
							Window.finalStr += qesNameInput.getText() + ": " + qesInput.getText() + "\n\n";
							qesInput.setText("");
						}

						if (!fh.doubleRECheck(ansInput.getText())) {
							Window.finalStr += ansNameInput.getText() + ": " + ansInput.getText() + "\n\n";
							ansInput.setText("");
						}

						productTextPanel.setText(Window.finalStr);
					}
				}

				// Move the cursor down to ansInput.
				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
					ansInput.requestFocus();
				}

				// Move the cursor right to productTextPanel.
				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
					productTextPanel.requestFocus();
				}
			}
		});

		pushBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Question/Answer's name can't be empty.
				if (fh.doubleRECheck(qesNameInput.getText())) {
					JInternalFrame frame = new JInternalFrame();
					JOptionPane.showMessageDialog(frame, "Question's Name can't be empty.", "Name warning",
							JOptionPane.WARNING_MESSAGE);
					return;

				} else if (fh.doubleRECheck(ansNameInput.getText())) {
					JInternalFrame frame = new JInternalFrame();
					JOptionPane.showMessageDialog(frame, "Answer's Name can't be empty.", "Name warning",
							JOptionPane.WARNING_MESSAGE);
					return;

					// Only include the question/answer that is not empty.
				} else {
					if (!fh.doubleRECheck(qesInput.getText())) {
						Window.finalStr += qesNameInput.getText() + ": " + qesInput.getText() + "\n\n";
						qesInput.setText("");
					}

					if (!fh.doubleRECheck(ansInput.getText())) {
						Window.finalStr += ansNameInput.getText() + ": " + ansInput.getText() + "\n\n";
						ansInput.setText("");
					}

					productTextPanel.setText(Window.finalStr);
				}
			}
		});

		// Dynamically update the finalStr.
		productTextPanel.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				// Move the cursor right to productTextPanel.
				if (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_LEFT) {
					qesInput.requestFocus();

				} else {
					Window.finalStr = productTextPanel.getText();
					System.out.println(Window.finalStr);
				}
			}
		});

		// Save to a file.
		exportBut.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				// Should work on Windows.
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
					String fileName = fileNameInput.getText();
					String qesName = qesNameInput.getText();
					String ansName = ansNameInput.getText();
					String year = yearInput.getText();
					String month = monthInput.getText();
					String day = dayInput.getText();
					String location = locationInput.getText();
					String date = year + "--" + month + "--" + day;

					System.out.println(date);

					if (fileName.length() == 0 || qesName.length() == 0 || ansName.length() == 0 || year.length() == 0
							|| month.length() == 0 || day.length() == 0 || location.length() == 0) {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "All fields need to be filled.", "Missing info warning",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					// Check if the date is valid.
					if (!fh.dateCheck(date)) {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "Date is not valid.", "Invalid date error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					String targetDir = dirLabel.getText();
					// Check save location/dir.
					if (targetDir == "No Selection" || targetDir.length() == 0 || targetDir == "Empty Directory") {
						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "File location is not valid.", "File location error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					File targetFile = new File(targetDir + "/" + fileName + ".txt");
					// Create a new file if it doesn't exist yet.
					if (!targetFile.exists()) {
						try {
							targetFile.createNewFile();

						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					FileWriter fw;

					try {
						fw = new FileWriter(targetFile.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);

						bw.write("Location: " + location + "\n");
						bw.write("Time: " + year + "-" + month + "-" + day + "\n");
						bw.write("Q: " + qesName + "\n");
						bw.write("A: " + ansName + "\n\n");
						bw.write(Window.finalStr);

						bw.close();

						JInternalFrame frame = new JInternalFrame();
						JOptionPane.showMessageDialog(frame, "The file is successfully saved.", "Successful",
								JOptionPane.INFORMATION_MESSAGE);
						return;

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		exportBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fileName = fileNameInput.getText();
				String qesName = qesNameInput.getText();
				String ansName = ansNameInput.getText();
				String year = yearInput.getText();
				String month = monthInput.getText();
				String day = dayInput.getText();
				String location = locationInput.getText();
				String date = year + "--" + month + "--" + day;

				System.out.println(date);

				if (fileName.length() == 0 || qesName.length() == 0 || ansName.length() == 0 || year.length() == 0
						|| month.length() == 0 || day.length() == 0 || location.length() == 0) {
					JInternalFrame frame = new JInternalFrame();
					JOptionPane.showMessageDialog(frame, "All fields need to be filled.", "Missing info warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Check if the date is valid.
				if (!fh.dateCheck(date)) {
					JInternalFrame frame = new JInternalFrame();
					JOptionPane.showMessageDialog(frame, "Date is not valid.", "Invalid date error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				String targetDir = dirLabel.getText();
				// Check save location/dir.
				if (targetDir == "No Selection" || targetDir.length() == 0 || targetDir == "Empty Directory") {
					JInternalFrame frame = new JInternalFrame();
					JOptionPane.showMessageDialog(frame, "File location is not valid.", "File location error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				File targetFile = new File(targetDir + "/" + fileName + ".txt");
				// Create a new file if it doesn't exist yet.
				if (!targetFile.exists()) {
					try {
						targetFile.createNewFile();

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				FileWriter fw;

				try {
					fw = new FileWriter(targetFile.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write("Location: " + location + "\n");
					bw.write("Time: " + year + "-" + month + "-" + day + "\n");
					bw.write("Q: " + qesName + "\n");
					bw.write("A: " + ansName + "\n\n");
					bw.write(Window.finalStr);

					bw.close();

					JInternalFrame frame = new JInternalFrame();
					JOptionPane.showMessageDialog(frame, "The file is successfully saved.", "Successful",
							JOptionPane.INFORMATION_MESSAGE);
					return;

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		mainJFrame.setVisible(true);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Window w = new Window();
	}
}
