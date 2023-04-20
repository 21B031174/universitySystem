package universitySystem.User;

import javax.swing.*;

import universitySystem.Faculty.Faculty;

import java.awt.event.*;  

public class Game implements ActionListener{  
    JTextField tf1,tf2,tf3;  
    JButton b1,b2;  
    JFrame f= new JFrame();  
    public void start (){  
        tf1=new JTextField();  
//        tf1.setBounds(150,180,150,20);  
        tf2=new JTextField();  
//        tf2.setBounds(150,220,150,20);  
        tf3=new JTextField();  
//        tf3.setBounds(50,150,150,20);  
//        tf3.setEditable(false);   
        b1=new JButton("Sign in");  
        b1.setBounds(150,200,80,50);  
        b2=new JButton("Sign up");  
        b2.setBounds(240,200,80,50);  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);f.add(b2);  
        f.setSize(500,500);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    
    public void login() {
    	f.setVisible(false); 
//    	JFrame f= new JFrame();  
        tf1=new JTextField();  
        tf1.setBounds(150,180,150,20);  
        tf2=new JTextField();  
        tf2.setBounds(150,220,150,20);  
        tf3=new JTextField();  
        tf3.setBounds(50,150,150,20);  
        tf3.setEditable(false);   
        b1=new JButton("Sign in");  
        b1.setBounds(150,200,80,50);   
        b1.addActionListener(this);  
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(b1);  
        f.setSize(500,500);  
        f.setLayout(null);  
        f.setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==b1){  
            login(); 
        }else if(e.getSource()==b2){  
//            logout(); 
        }  
    }  
public static void main(String[] args) {  
    Game g = new Game();  
    g.start();
    g.actionPerformed(null);
    
    
    Faculty fit = new Faculty("FIT");
//	
	Student u1 = new Student("Inara", "Almagambetova", "Baitasovna", 1, fit, Degree.BACHELOR);
	Student u2 = new Student("Aitolkyn", "Amantai", "Avc", 1, fit, Degree.BACHELOR);
//	
//	Message m = new Message(u1, "hey", u2);
//	Message m1 = new Message(u1, "heyyyyy", u2);
//	Message m2 = new Message(u1, "hello", u2);
//	
//	u2.sendMessage(m);
//	u2.sendMessage(m1);
//	
//	System.out.println(u1.getPersonalMessages());
//	System.out.println(u2.getPersonalMessages());
//	
//	System.out.println(u1.getReadMessages());
//	System.out.println(u2.getReadMessages());
	
//	System.out.println(u1.showMessages());
//	System.out.println(u2.showMessages());
	
//	u1.answerToMesage(m1, "hello");
//	
//	System.out.println(u1.showMessages());
//	System.out.println(u2.showMessages());
//	
//	Lesson oop = new Lesson("OOP");
//	
//	Teacher t1 = new Teacher("aaa", "bbb", "ccc", 100, TeachingStatus.ASSISTENT);
//	Teacher t2 = new Teacher("ddd", "eee", "fff", 1000, TeachingStatus.ASSISTENT);
	
//	t1.putMark(u2, oop, new Mark(2), 2, new Semester());
	
//	System.out.println(u2.getDisciplinesGrades());
	
//	System.out.println(t2.compareTo(t1));
//	
	CreateSingleton singleton = CreateSingleton.getInstance("FOO");
//	
//	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt")))
//    {
//        oos.writeObject(t1.toString());
//    }
//    catch(Exception ex) {
//         
//        System.out.println(ex.getMessage());
//    } 
//	
	singleton.addStudent(u2);
	singleton.addStudent(u1);
	
//	System.out.print(u1.getPassword());
	
//u2.registerOnDisciplines(oop);
	
//t1.putMark(u2, oop, new Mark(2), 2, new Semester());
	
//	System.out.println(u2.getDisciplinesGrades());
	
	System.out.print(CreateSingleton.getStudents());
    
    
} }  

//import java.awt.BorderLayout;
//import java.awt.Canvas;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.TextField;
//import java.awt.image.BufferStrategy;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
//public class Game {
//	
//	static JFrame jFrame = new JFrame();
//	
//	static JPanel jPanel = new JPanel();
//	
//	static JFrame getFrame() {
//		JFrame jFrame = new JFrame() {
//
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;};
//		jFrame.setVisible(true);
//		jFrame.setBounds(750, 250, 500, 500);
//		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		return jFrame;
//	}
//	
//	public static void main(String[] args) throws Exception {
//		jFrame.add(jPanel);
//		jPanel.add(new JLabel("kalsl"));
//		jPanel.add(new JTextField("login", 20));
//		JTextField jTextField = new JTextField();
//		jTextField.getText();
//		
//		jPanel.add(new JPasswordField(20));
//		JTextArea jTextArea = new JTextArea(5, 20);
//		jTextArea.setLineWrap(true);
//		jPanel.add(jTextArea);
//		jPanel.revalidate();
//	}
//}
//	
//////	Graphics.KeyListener;
////	
////	boolean running;
////
////	static JPanel jPanel = new JPanel();
////	
////	private static final long serialVersionUID = 1L;
////
////	public void start() {
////		running = true;
////		new Thread(this).start();
////	}
//	
//	public void run() {
//		long lastTime = System.currentTimeMillis();
//		long delta;
//		
//		init();
//			
//		while(running) {
//			delta = System.currentTimeMillis() - lastTime;
//			lastTime = System.currentTimeMillis();	
//			update(delta);
//			render();
//		}
//	}
//		
//	public void init() {
//			
//	}
//		
//	public void render() {
//		BufferStrategy bs = getBufferStrategy(); 
//		if (bs == null) {
//			createBufferStrategy(2); //создаем BufferStrategy для нашего холста
//			requestFocus();
//			return;
//		}
//			
//		Graphics g = bs.getDrawGraphics(); //получаем Graphics из созданной нами BufferStrategy
//		g.setColor(Color.gray); //выбрать цвет
//		g.fillRect(0, 0, getWidth(), getHeight()); //заполнить прямоугольник 
//		g.dispose();
//		bs.show(); //показать
//		
//		
//		
//	}
//		
//	public void update(long delta) {
//			
//	}
//	
//	public static int WIDTH = 800; //ширина
//	public static int HEIGHT = 500; //высота
//	public static String NAME = "Uni"; //заголовок окна
//
//	public static void main(String[] args) {
//		Game game = new Game();
//		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//
//		JFrame frame = new JFrame(Game.NAME);
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //выход из приложения по нажатию клавиши ESC
//		frame.setLayout(new BorderLayout());
//		frame.add(game, BorderLayout.CENTER); //добавляем холст на наш фрейм
//		
//		
//		frame.add(jPanel);
//		jPanel.add(new JLabel("Login"));
//		jPanel.add(new TextField("dhhf", 20));
//		JTextField jTextField = new JTextField();
//		jTextField.getText();
//		jPanel.add(new JPasswordField(20));
//		JTextArea jTextArea = new JTextArea(5, 20);
//		jTextArea.setLineWrap(true);
//		jPanel.revalidate();
//		
//		
//		
//		
//		frame.pack();
//		frame.setResizable(false);
//		frame.setVisible(true);
//
//		game.start();
//	}
//	
//}