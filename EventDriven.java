package eventDriven;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Main3 {
	
	private static int y = 0;
	private static ArrayList<JCheckBox> tasks = new ArrayList<>();
	
	public static int yAx() {
		y++;
		return 120+(20*y);
	}
	
	public static void main(String[] args) {
		
		//set the frame
		JFrame frame = new JFrame("ToDoList application");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);	
		
		//set the title
		JLabel title = new JLabel("  ToDoList");
		title.setBounds(40, 25, 250, 100);
		Font font = new Font("Berlin Sans FB Demi", Font.BOLD, 50); 
		title.setFont(font);
		Color color = new Color(28, 103, 88);
		title.setForeground(color);
		frame.add(title);
		
		//you are amazing:)
		JLabel title2 = new JLabel("you are amazing, keep going ❤️");
		title2.setBounds(300, 411, 200, 50);
		title2.setForeground(color);
		title.setFont(font);
		frame.add(title2);
		
//		//a failed try to add a logo
//		ImageIcon image = new ImageIcon("Users\\PC\\Desktop\\henna\\HTU\\programming\\Assignment\\logo.png");
//		JLabel logo = new JLabel(image);
//		logo.setBounds(20, 200, 50, 50);
//		frame.add(logo);
		
		//set the add button
		JButton button1 = new JButton ("+");
		button1.setBounds(330,40, 50, 45);
		frame.add(button1);
		button1.setForeground(color);
		
		//set the see button
		JButton button2 = new JButton ("*_*");
		button2.setBounds(390,40, 50, 45);
		frame.add(button2);
		button2.setForeground(color);
		
		//set the Delete button
		JButton button3 = new JButton ("Delete");
		button3.setBounds(330,90, 110, 30);
		frame.add(button3);
		button3.setForeground(color);
		
		//set the Move me button
		JButton button4 = new JButton ("Move me 🙂");
		button4.setBounds(332,370, 105, 40);
		frame.add(button4);
		button4.setForeground(color);
		
		//let button4 move
		frame.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				button4.setBounds(e.getX()-10, e.getY()-30, 105, 40);
				
			}
		});
		
		// add tasks when click button1
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String task= JOptionPane.showInputDialog("Enter your task");
				
				if (task != null && !task.trim().isEmpty()) {
					JCheckBox checkBox = new JCheckBox (task);
					checkBox.setBounds(50, yAx(), 450, 20);
					tasks.add(checkBox);
					frame.add(checkBox);
					frame.revalidate();
	                frame.repaint();
	                
	                checkBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	if (checkBox.equals(true)) {
                            tasks.remove(checkBox);
                            frame.revalidate();
                            frame.repaint();
                        	} else if (checkBox.equals(false)){
                        	tasks.add(checkBox);
                        	}
                        }
                    });
	               
				}
				
			}		
		});
		
		//see the tasks left when button2 click
		button2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				StringBuilder allT = new StringBuilder("The Tasks Left:\n");
				for (JCheckBox task : tasks) {
					if (!task.isSelected()) {
						allT.append("- ");
						allT.append(task.getText());
						allT.append("\n");
					}
				}
				JOptionPane.showMessageDialog(frame, allT.toString());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		//delete tasks when button3 click
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<JCheckBox> tasksD = new ArrayList<>();
				for(JCheckBox task : tasks) {
					if (task.isSelected()) {
						tasksD.add(task);
					}
				}
				for(JCheckBox task : tasksD) {
					frame.remove(task);
					tasks.remove(task);
				}
				frame.revalidate();
                frame.repaint();
			}
		});
		
}
}

