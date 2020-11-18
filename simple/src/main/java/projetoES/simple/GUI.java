package projetoES.simple;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
<<<<<<< HEAD
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

=======
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class GUI {
	private App app;	
	private JFrame frame;
	private JButton btnFile;
	private JButton btnInsert;
	private JButton btnClear;
<<<<<<< HEAD
	private JButton btnSearch;
=======
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
	private JTextField textField1;
	private JTextField textField2;
	private JComboBox<Object> comboBox;
	private JComboBox<Object> comboBox1;
	private JComboBox<Object> comboBox2;
	private String[] metricas = { "LOC", "CYCLO", "ATFD", "LAA"};
	private String[] metricas2 = {">", "<", "="};
	private String[] andor = { "AND" , "OR" };
	private String selected;
	private String selected1;
	private String selected2;
	private String selected3;
	private JTextPane textPane ;
	private JScrollPane scrollPane;
	private JTable excel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

<<<<<<< HEAD


=======
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
	public GUI() throws InvalidFormatException, IOException {
		initialize();
	}

	private void initialize() throws InvalidFormatException, IOException {
		initComponents();
		createEvents();
	}

	private void initComponents() {
		app = new App();
		frame = new JFrame();
		frame.setTitle("Projeto");
		frame.setBounds(100, 100, 570, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnFile = new JButton("Choose File");
		btnFile.setBounds(412, 29, 85, 21);
		frame.getContentPane().add(btnFile);

		textField1 = new JTextField();
		textField1.setBounds(52, 30, 350, 19);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		comboBox = new JComboBox<Object>(metricas);
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		comboBox.setBounds(52, 70, 59, 21);
		frame.getContentPane().add(comboBox);

		comboBox1 = new JComboBox<Object>(metricas2);
		comboBox1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		comboBox1.setBounds(118, 70, 59, 21);
		frame.getContentPane().add(comboBox1);

		textField2 = new JTextField();
		textField2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		textField2.setBounds(187, 70, 96, 21);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);

		comboBox2 = new JComboBox<Object>(andor);
		comboBox2.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		comboBox2.setBounds(293, 70, 56, 21);
<<<<<<< HEAD
		comboBox2.setEditable(true);
=======
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
		frame.getContentPane().add(comboBox2);

		btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		btnInsert.setBounds(412, 60, 85, 32);
		frame.getContentPane().add(btnInsert);

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		btnClear.setBounds(412, 95, 85, 32);
		frame.getContentPane().add(btnClear);

<<<<<<< HEAD
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		btnSearch.setBounds(412, 130, 85, 32);
		frame.getContentPane().add(btnSearch);

=======
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
		textPane = new JTextPane();
		textPane.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		textPane.setBounds(52, 101, 304, 26);
		frame.getContentPane().add(textPane);

	}

<<<<<<< HEAD

=======
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
	private void createEvents() throws InvalidFormatException, IOException {
		btnFile.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\Downloads")); //Downloads Directory as default
				chooser.setDialogTitle("Select Location");
				chooser.setAcceptAllFileFilterUsed(false);
				int returnValue = chooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					textField1.setText(selectedFile.getAbsolutePath ());
					try {
						app.readFile(textField1.getText());
						String[][] rowData = new String[app.rowNum()][app.columnNum()];
						String[] columnNames = new String[app.columnNum()];
						for (int row=0 ; row<app.rowNum()+1 ; row++) {
							for (int column=0 ; column<app.columnNum(); column++) {
								String cell = app.get(row, column);
								if (row == 0)
									columnNames[column] = cell;
								else
									rowData[row - 1][column] = cell;
							}
						}
						excel = new JTable (rowData, columnNames);
<<<<<<< HEAD
						excel.setFillsViewportHeight(true);
						scrollPane = new JScrollPane(excel);
						scrollPane.setBounds(40, 200, 500, 200 );
						frame.add(scrollPane);
=======
		        		excel.setFillsViewportHeight(true);
						scrollPane = new JScrollPane(excel);
		                scrollPane.setBounds(40, 200, 500, 200 );
		                frame.add(scrollPane);
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
					} catch (InvalidFormatException | IOException e1) {
						System.out.println("Something went wrong...");
					}
				}}
		});

		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected = comboBox.getSelectedItem().toString();
				selected1 = comboBox1.getSelectedItem().toString();
				selected2 = textField2.getText();
				selected3 = comboBox2.getSelectedItem().toString();
				if (selected2.isEmpty()) {
					System.out.println("Espaço não preenchido");
				} else {
					textPane.setText(textPane.getText()+" "+selected);
					textPane.setText(textPane.getText()+" "+selected1);
					textPane.setText(textPane.getText()+" "+selected2);
					textPane.setText(textPane.getText()+" "+selected3);
				}		
<<<<<<< HEAD

			}	
		});


		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String metrics= textPane.getText();
				String [] v= metrics.split(" ");
				String cond= String.join("", v[1], v[2]);
				char c1= cond.charAt(1);
				char c2= cond.charAt(2);
				double d2= c2;
				String c= v[0];
				String verdadeiro= "VERDADEIRO";
				String falso= "FALSO";

				try {
					app.readFile(textField1.getText());
					String[][] rowData = new String[app.rowNum()][app.columnNum()];
					String[] columnNames = new String[app.columnNum()];
					for (int row=0 ; row<app.rowNum()+1 ; row++) {
						for (int column=0 ; column<app.columnNum(); column++) {
							String cell = app.get(row, column);
							if (row == 0)
								columnNames[column] = cell;
							else
								rowData[row - 1][column] = cell;
						}
					}


					int size= columnNames.length;

					for (int nrColumn=0; nrColumn<size; nrColumn++){
						if(columnNames[nrColumn]==v[0]) {
							for (Row row : sheet) { 
								Cell cell = row.getCell(nrColumn);
								int index= cell.getRowIndex();
								double value= cell.getNumericCellValue();

								switch(c1) {
								case '<':
									if(value < d2) {
										cell.escreveVF(c,verdadeiro, index);
									}
									else {
										cell.escreveVF(c,falso, index);
									}
								case '>':
									if(value > d2) {
										cell.escreveVF(c, verdadeiro, index);
									}
									else {
										cell.escreveVF(c, falso, index);
									}
								case '=':
									if(value == d2) {
										cell.escreveVF(c, verdadeiro, index);
									}
									else {
										cell.escreveVF(c, falso, index);
									}
								}
							}

						}	}
				});
			}

			public void  escreveVF (String string, String VF, int ind){
				app.readFile(textField1.getText());
				String[][] rowData1 = new String[app.rowNum()][app.columnNum()];
				String[] columnNames1 = new String[app.columnNum()];
				for (int row=0 ; row<app.rowNum()+1 ; row++) {
					for (int column=0 ; column<app.columnNum(); column++) {
						String cell = app.get(row, column);
						if (row == 0)
							columnNames1[column] = cell;
						else
							rowData1[row - 1][column] = cell;
					}
				}
				if(string =="LOC" || string =="CYCLO") {
					for (int nrColumn=0; nrColumn<size; nrColumn++){
						if(columnNames1[nrColumn]== "is_long_method") {
							Row r = sheet.getRow(ind); 
							if (r == null) {
								r = sheet.createRow(ind);
							}

							Cell c = r.getCell(nrColumn); 
							if (c == null) {
								c = r.createCell(nrColumn, Cell.CELL_TYPE_STRING);
							}
							c.setCellValue(VF);
						}
					}
				}
				if(string =="ATFD" || string =="LAA") {
					for (int nrColumn=0; nrColumn<size; nrColumn++){
						if(columnNames1[nrColumn]== "is_feature_envy") {
							Row r = sheet.getRow(ind); 
							if (r == null) {
								r = sheet.createRow(ind);
							}

							Cell c = r.getCell(nrColumn); 
							if (c == null) {
								c = r.createCell(nrColumn, Cell.setCellType(String));
							}
							c.setCellValue(VF);
						}
					}
				}
			}


			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textPane.setText("");
				}
			}));
		}
=======
			}	
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
			}
		});
	}
}
>>>>>>> f8e7e59e064ae0e2565e1c63b771c39b41968c95
