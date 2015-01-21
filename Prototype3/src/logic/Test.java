package logic;
import gui.AcademicFrame;

import java.util.Vector;

import javax.swing.JFrame;


public class Test {
	
	public static void main( String args[] )
	   { 
        Vector<Student> students=new Vector<Student>();
		
		students.add(new Student("12345","Yossi","Cohen",new Faculty("SE","9901000")));
		students.add(new Student("66666","Yossefa","Levi",new Faculty("IE","9901123")));
		students.add(new Student("77777","moshe","galili",Faculty.getFaculty("SE")));
		students.add(new Student("77778","moran","galil",Faculty.getFaculty("SE")));
		
		new Faculty("ME","9901995");   
		
		Student s1=students.get(0);
		Student s2=students.get(1);
		Student s3=students.get(2);
		Student s4=students.get(3);
		
		  		
		  AcademicFrame aFrame = new AcademicFrame(); // create StudentFrame
		  aFrame.loadStudent(s1);
		  aFrame.loadStudent(s2);
		  aFrame.loadStudent(s3);
		  aFrame.loadStudent(s4);
	      aFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      aFrame.setSize( 300,250 ); // set frame size
	      aFrame.setVisible( true ); // display frame
	  } // end main
	
}
