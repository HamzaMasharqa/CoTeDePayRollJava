package PayRoll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UpdateForm extends JFrame {

	private JPanel contentPane;
	private JTextField hourratetxt;
	private JTextField statustxt;
	private JTextField tittxt;
	private JTextField addtxt;
	private JTextField emp_id;
	private JTable table;
	
	
	
	
	private  String tableName = "EMP_INFO";
    private Connection conn = null;
    private Statement stmt = null;
    
    
    ResultSet rs = null;
    PreparedStatement r=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateForm frame = new UpdateForm();
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
	public UpdateForm() {
		
		
		
		tbl_fill();
		
		setTitle("Update");
		
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 622);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			}
		});
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("x");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				
				
			}
		});
		
		JLabel emp_up = new JLabel("EMPLOYEE UPDATE");
		emp_up.setForeground(new Color(47, 79, 79));
		emp_up.setFont(new Font("Tahoma", Font.BOLD, 31));
		emp_up.setBounds(375, 27, 322, 50);
		contentPane.add(emp_up);
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 29, 78, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(Color.ORANGE);
		label.setBounds(0, 0, 1045, 95);
		contentPane.add(label);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setForeground(new Color(240, 248, 255));
		lblEmployeeId.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEmployeeId.setBackground(new Color(248, 248, 255));
		lblEmployeeId.setBounds(130, 183, 188, 35);
		contentPane.add(lblEmployeeId);
		
		JLabel lbladd = new JLabel("Employee Adress");
		lbladd.setForeground(new Color(240, 248, 255));
		lbladd.setFont(new Font("Verdana", Font.BOLD, 18));
		lbladd.setBackground(new Color(248, 248, 255));
		lbladd.setBounds(79, 231, 188, 38);
		contentPane.add(lbladd);
		
		JLabel lblEmployeeTile = new JLabel("Employee Title :");
		lblEmployeeTile.setForeground(new Color(240, 248, 255));
		lblEmployeeTile.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEmployeeTile.setBackground(new Color(248, 248, 255));
		lblEmployeeTile.setBounds(98, 328, 172, 35);
		contentPane.add(lblEmployeeTile);
		
		JLabel lblEmployeeStatus = new JLabel("Employee Status :");
		lblEmployeeStatus.setForeground(new Color(240, 248, 255));
		lblEmployeeStatus.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEmployeeStatus.setBackground(new Color(248, 248, 255));
		lblEmployeeStatus.setBounds(79, 372, 188, 30);
		contentPane.add(lblEmployeeStatus);
		
		JLabel lblEmployee = new JLabel("Employee Hour Rate :");
		lblEmployee.setForeground(new Color(240, 248, 255));
		lblEmployee.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEmployee.setBackground(new Color(248, 248, 255));
		lblEmployee.setBounds(41, 417, 230, 28);
		contentPane.add(lblEmployee);
		
		hourratetxt = new JTextField();
		hourratetxt.setForeground(new Color(240, 255, 255));
		hourratetxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		hourratetxt.setColumns(10);
		hourratetxt.setBackground(Color.LIGHT_GRAY);
		hourratetxt.setBounds(282, 416, 149, 35);
		contentPane.add(hourratetxt);
		
		statustxt = new JTextField();
		statustxt.setForeground(new Color(240, 255, 255));
		statustxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statustxt.setColumns(10);
		statustxt.setBackground(Color.LIGHT_GRAY);
		statustxt.setBounds(282, 373, 149, 34);
		contentPane.add(statustxt);
		
		tittxt = new JTextField();
		tittxt.setForeground(new Color(240, 255, 255));
		tittxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tittxt.setColumns(10);
		tittxt.setBackground(Color.LIGHT_GRAY);
		tittxt.setBounds(282, 330, 149, 35);
		contentPane.add(tittxt);
		
		addtxt = new JTextField();
		addtxt.setForeground(new Color(240, 255, 255));
		addtxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addtxt.setColumns(10);
		addtxt.setBackground(Color.LIGHT_GRAY);
		addtxt.setBounds(282, 235, 149, 82);
		contentPane.add(addtxt);
		
		emp_id = new JTextField();
		emp_id.setForeground(new Color(240, 255, 255));
		emp_id.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emp_id.setColumns(10);
		emp_id.setBackground(Color.LIGHT_GRAY);
		emp_id.setBounds(282, 183, 149, 35);
		contentPane.add(emp_id);
		
		JScrollPane TBL_EMP = new JScrollPane();
		TBL_EMP.setBounds(460, 138, 573, 424);
		contentPane.add(TBL_EMP);
		
		table = new JTable();
		TBL_EMP.setViewportView(table);
		
		JButton up_btn = new JButton("Update");
		up_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(e.getSource() == up_btn) {
				
				update ();
				
				
			}
				
				
			}
		});
		up_btn.setFont(new Font("Tahoma", Font.PLAIN, 21));
		up_btn.setBounds(286, 479, 145, 83);
		contentPane.add(up_btn);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomePage ho =new HomePage();
				ho.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon("C:\\Users\\hamha\\eclipse-workspace\\CoTeDePayRolll\\Images\\126492.png"));
		label_1.setBackground(new Color(255, 215, 0));
		label_1.setBounds(49, 487, 128, 75);
		contentPane.add(label_1);
		
	}
	
	
	
	
	
	private void tbl_fill() {
		
		
		
		
		try {
			
			String sql = "select * from EMP_INFO";

	        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	        conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//hamha//eclipse-workspace//CoTeDePayRolll//CoTeDe.accdb");
			r= conn.prepareStatement(sql);
			
			
			
			
			
			rs = r.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		
			
		}catch(Exception e) {
			
			e.getStackTrace();
			
			
			
			
		}
		
		
		
		
		
}
	
	
	
	
	
	private void update () {
		
		
	
		
		
		
		
		String emp_add = addtxt.getText();
		String emp_tit =tittxt.getText();
		String emp_Status = statustxt.getText();
		String emp_h_rate = hourratetxt.getText();
		
				
		
		try {
			
			String sql =  "UPDATE EMP_INFO set emp_add =? ,emp_tit =?,emp_Status =?, emp_h_rate = ? where emp_id = ?";
			

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//hamha//eclipse-workspace//CoTeDePayRolll//CoTeDe.accdb");
			
        r =conn.prepareStatement(sql);
			 
			 r.setString(1, emp_add);
			 r.setString(2, emp_tit);
			 r.setString(3, emp_Status);
			 r.setString(4, emp_h_rate);
			 r.setString(5, emp_id.getText() );
			r.executeUpdate();
			JOptionPane.showMessageDialog(null, "UPDATED SUCCESSFULLY");
			
		}catch(Exception e) {
			
			
			e.getStackTrace();
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

