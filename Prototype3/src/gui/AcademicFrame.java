package gui;


import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import logic.Faculty;
import logic.Student;


public class AcademicFrame extends JFrame {

	private StudentForm sf;
	private Dima d;
	private JPanel FirstPanel = null;
	private JButton StudentsButton = null;
	private JComboBox comboBox = null;
	private Student[] stu=new Student[4];
	private static int i=0;
	/**
	 * This method initializes StudentsButton	
	 */
	private JButton getStudentsButton() {
		if (StudentsButton == null) {
			StudentsButton = new JButton();
			StudentsButton.setBounds(new Rectangle(68, 147, 172, 29));
			StudentsButton.setText("Student info");
			StudentsButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
					for (int j=0;j<i;j++)
						if (comboBox.getSelectedItem()==stu[j].getPName())
							sf.loadStudent(stu[j]);
					setContentPane(sf);
				}
			});
			
		}
		return StudentsButton;
	}

	
	/**
	 * This is the default constructor
	 */
	public AcademicFrame() {
		super();
		setResizable(false);
		initialize();
	}

	/**
	 * This method initializes AcademicFrame 
	 */
	private void initialize() {
		this.setSize(320, 300);
		this.setContentPane(getFirstPanel());
		this.setTitle("Academic Managment Tool");
		this.sf=new StudentForm();
		this.d=new Dima();
		sf.btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Close was pressed");
				setContentPane(getFirstPanel());
			}
		});
		sf.btnDima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(d);
			}
		});
		d.btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(sf);
			}
		});
	}

	/**
	 * This method initializes FirstPanel
	 */
	private JPanel getFirstPanel() {
		if (FirstPanel == null) {
			FirstPanel = new JPanel();
			FirstPanel.setLayout(null);
			FirstPanel.add(getStudentsButton(), null);
			
			comboBox = new JComboBox();
			comboBox.setBounds(68, 25, 172, 22);
			FirstPanel.add(comboBox);
		}
		return FirstPanel; 
	}

	public void loadStudent(Student s) {
		//this.sf.loadStudent(s);
		comboBox.addItem(s.getPName());
		stu[i]=s;
		i++;
		
	}
	
}
