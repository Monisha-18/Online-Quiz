/*Online Java Paper Test*/

import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Number of primitive data types in Java are?");
			jb[0].setText("6");jb[1].setText("7");jb[2].setText("8");jb[3].setText("9");	
		}
		if(current==1)
		{
			l.setText("Que2: What is the size of float and double in java?");
			jb[0].setText("32 and 64");jb[1].setText("32 and 32");jb[2].setText("64 and 64");jb[3].setText("64 and 32");
		}
		if(current==2)
		{
			l.setText("Que3: Automatic type conversion is possible in which of the possible cases?");
			jb[0].setText("Byte to int");jb[1].setText("Int to long");jb[2].setText("Long to int");jb[3].setText("Short to int");
		}
		if(current==3)
		{
			l.setText("Que4: Select the valid statement.");
			jb[0].setText("char[] ch=new char(5)");jb[1].setText("char[] ch=new char[5]");jb[2].setText("char[] ch=new char()");jb[3].setText("char[] ch=new char[]");
		}
		if(current==4)
		{
			l.setText("Que5: When an array is passed to a method, what does the method receive?");
			jb[0].setText("The reference of the array");jb[1].setText("A copy of the array");jb[2].setText("Length of the array");jb[3].setText("Copy of first element");
		}
		if(current==5)
		{
			l.setText("Que6: Select the valid statement to declare and initialize an array.");
			jb[0].setText("int[] A={}");jb[1].setText("int[] A={1,2,3}");jb[2].setText("int[] A=(1,2,3)");jb[3].setText("int[][] A={1,2,3}");
		}
		if(current==6)
		{
			l.setText("Que7: Arrays in java are- ");
			jb[0].setText("Object reference");jb[1].setText("objects");jb[2].setText("Primitive data type");jb[3].setText("None");
		}
		if(current==7)
		{
			l.setText("Que8: When is the object created with new keyword?");
			jb[0].setText("At run time");jb[1].setText("At compile time");jb[2].setText("Depends on the code");jb[3].setText("None");		
		}
		if(current==8)
		{
			l.setText("Que9: Identify the corrected definition of a package.");
			jb[0].setText("A package is a collection of editing tools");jb[1].setText("A package is a collection of classes");jb[2].setText("A package is a collection of classes and interfaces");jb[3].setText("A package is a collection of interfaces");
		}
		if(current==9)
		{
			l.setText("Que10: Identify the keyword among the following that makes a variable belong to a class,rather than being defined for each instance of the class.");
			jb[0].setText("final");jb[1].setText("static");jb[2].setText("volatile");jb[3].setText("abstract");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[2].isSelected());
		if(current==1)
			return(jb[0].isSelected());
		if(current==2)
			return(jb[1].isSelected());
		if(current==3)
			return(jb[1].isSelected());
		if(current==4)
			return(jb[0].isSelected());
		if(current==5)
			return(jb[1].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[0].isSelected());
		if(current==8)
			return(jb[2].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
