package PayRoll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;



@SuppressWarnings("serial")
public class HomePage extends JFrame implements ActionListener {



	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hamha\\Desktop\\Untitled.png"));
		lblNewLabel.setBounds(30, 207, 212, 61);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("X");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(47, 79, 79));
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(0, 0, 70, 62);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(Color.ORANGE);
		label_1.setBounds(0, 0, 277, 408);
		contentPane.add(label_1);
		
		JButton button = new JButton("Make a payrate");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				PasteUpForm pf = new PasteUpForm();
	pf.setVisible(true);
				dispose();
			}
		});
		button.setBounds(449, 109, 186, 51);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Updating the data");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateForm uf =new UpdateForm();
				uf.setVisible(true);
				
		        dispose();
		        
				
				
			}
		});
		button_1.setBounds(449, 212, 180, 51);
		contentPane.add(button_1);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
