package PayRoll;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.docx4j.Docx4J;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Component;

public class  PasteUpForm extends JFrame implements ActionListener{
	

	private static  String PayRoll = "C://Users//hamha//Desktop//PayRoll.docx";

	private JPanel contentPane;
	
	private JComboBox ComboName ;
	
	
	private String total;
	
	
	 private  String tableName = "EMP_INFO";
	    private Connection conn = null;
	    private Statement stmt = null;
	    
	    
	    ResultSet rs = null;
	    PreparedStatement r=null;
	    private JTextField txtworkhours;
	    private JTextField txtvacation;
	    private JTextField txtholyday;
	    private JTextField txtadminhours;
	    private JTextField txtPayRollName;
	

	    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasteUpForm frame = new PasteUpForm();
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
	public PasteUpForm() {	

		 initcomponents();
		 
//		 CompanyInfo() ;
		 
		
		 ComboName();
		 

	}
	
	
//	private void CompanyInfo() {
//		
//		
//		try {
//		
//			
//
//	        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//		        conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//hamha//eclipse-workspace//CoTeDePayRolll//CoTeDe.accdb");
//		    	stmt =conn.createStatement();
//		    	
//				String sql = "select * from  com_info  ";
//				rs = stmt.executeQuery(sql);
//			
//		
//			
//			CompInfo co = new CompInfo();
//			
//			co.setComp_Name(rs.getString("Comp_Name"));
//			co.setComp_Add(rs.getString("Comp_Add"));
//			co.setComp_ID(rs.getString("Comp_ID"));
//			
//	
//			
//			
//			
//		}catch(Exception e) {
//			
//			
//			System.out.println("the problem is in the company information ");
//			
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// putting Names in combobox Method
	
	private void ComboName() {

	try {	
		 DBConnection db = new DBConnection();
		 db.openConnection();
		

//        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//        conn = DriverManager.getConnection("jdbc:ucanaccess://C://Users//hamha//eclipse-workspace//CoTeDePayRolll//CoTeDe.accdb");
		 stmt =conn.createStatement();
    	
		String sql = "select * from "+tableName ;
		rs = stmt.executeQuery(sql);
		
		
		
		// removing all the combo items 
		int itemCount = ComboName.getItemCount();

	    for(int i=0;i<itemCount;i++){
	    	ComboName.removeItemAt(0);
	     }
		
		
			
		while(rs.next()) {
		
			
			String name =rs.getString("emp_name");
			ComboName.addItem(name);
				
		
			}
			
		
		db.CloseConnection();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	ComboName.setSelectedIndex(-1);
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	private void initcomponents() {

		setTitle("Paste Up");
		
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 507);
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
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 46, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(Color.ORANGE);
		label.setBounds(0, 0, 792, 87);
		contentPane.add(label);
		
		 ComboName = new JComboBox();
		 ComboName.setBackground(Color.LIGHT_GRAY);
		ComboName.setBounds(329, 118, 149, 35);
		contentPane.add(ComboName);
		
		JLabel lblNewLabel = new JLabel("Employee Name :");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBackground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(143, 115, 188, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblTWH = new JLabel("Total Work Hours :");
		lblTWH.setForeground(new Color(240, 248, 255));
		lblTWH.setBackground(new Color(248, 248, 255));
		lblTWH.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTWH.setBounds(126, 162, 188, 38);
		contentPane.add(lblTWH);
		
		txtworkhours = new JTextField();
		txtworkhours.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
				
	                }}}
		);
		txtworkhours.setForeground(new Color(240, 255, 255));
		txtworkhours.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtworkhours.setBackground(Color.LIGHT_GRAY);
		txtworkhours.setBounds(329, 166, 149, 35);
		contentPane.add(txtworkhours);
		txtworkhours.setColumns(10);
		
		JLabel lblTotalVacation = new JLabel("Total Vacation :");
		lblTotalVacation.setForeground(new Color(240, 248, 255));
		lblTotalVacation.setBackground(new Color(248, 248, 255));
		lblTotalVacation.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTotalVacation.setBounds(158, 213, 207, 35);
		contentPane.add(lblTotalVacation);
		
		JLabel lblTotalHoliday = new JLabel("Total Holiday :");
		lblTotalHoliday.setForeground(new Color(240, 248, 255));
		lblTotalHoliday.setBackground(new Color(248, 248, 255));
		lblTotalHoliday.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTotalHoliday.setBounds(168, 261, 149, 30);
		contentPane.add(lblTotalHoliday);
		
		JLabel lblTotalWorkTotal = new JLabel(" Total AdminHours :");
		lblTotalWorkTotal.setForeground(new Color(240, 248, 255));
		lblTotalWorkTotal.setBackground(new Color(248, 248, 255));
		lblTotalWorkTotal.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTotalWorkTotal.setBounds(116, 304, 227, 28);
		contentPane.add(lblTotalWorkTotal);
		
		JLabel lblGrandTotal = new JLabel("Grand Total :");
		lblGrandTotal.setForeground(new Color(240, 248, 255));
		lblGrandTotal.setBackground(new Color(248, 248, 255));
		lblGrandTotal.setFont(new Font("Verdana", Font.BOLD, 18));
		lblGrandTotal.setBounds(182, 383, 149, 35);
		contentPane.add(lblGrandTotal);
		
		txtvacation = new JTextField();
		txtvacation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
			}}
		});
		txtvacation.setForeground(new Color(240, 255, 255));
		txtvacation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtvacation.setBackground(Color.LIGHT_GRAY);
		txtvacation.setColumns(10);
		txtvacation.setBounds(329, 212, 149, 35);
		contentPane.add(txtvacation);
		
		txtholyday = new JTextField();
		txtholyday.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
			}
			}
		});
		txtholyday.setForeground(new Color(240, 255, 255));
		txtholyday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtholyday.setBackground(Color.LIGHT_GRAY);
		txtholyday.setColumns(10);
		txtholyday.setBounds(329, 258, 149, 34);
		contentPane.add(txtholyday);
		
		txtadminhours = new JTextField();
		txtadminhours.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                    
                    
                    
                   
			}
			}
		});
		txtadminhours.setForeground(new Color(240, 255, 255));
		txtadminhours.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtadminhours.setBackground(Color.LIGHT_GRAY);
		txtadminhours.setColumns(10);
		txtadminhours.setBounds(329, 303, 149, 35);
		contentPane.add(txtadminhours);
		
		JButton btnNewButton = new JButton("Print PayRoll");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
				if(valed() == true) {

					try {

				    	

						Emp_Info wh = new Emp_Info();

						String emp_name = (String) ComboName.getSelectedItem();
						wh.setTotalWorkHours( Double.parseDouble(txtadminhours.getText())) ;
						wh.setTotalHolyday( Double.parseDouble(txtholyday.getText()));
						wh.setTotalVacation(Double.parseDouble(txtvacation.getText()));
						wh.setTotalWorkHours(Double.parseDouble(txtworkhours.getText()));  
						wh.setEmpNm(emp_name);
						
						wh.setGT(Double.parseDouble(total));
						
						
						
						
						
						
					
						CompInfo co = new CompInfo();
						
						
						InputStream templateInputStream = new FileInputStream(PayRoll);
						
						
						
						WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateInputStream);
						MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
						VariablePrepare.prepare(wordMLPackage);
						
						
						HashMap<String, String> variables = new HashMap<>();
						
						System.out.println(co.getComp_Add());
						variables.put("bean.comp",co.getComp_Name());
						variables.put("bean.compID ",co.getComp_ID());
						variables.put("bean.compadd ",co.getComp_Add());
						
						
						
						
						variables.put("bean.workHours",Double.toString(wh.getTotalWorkHours()));
						variables.put("bean.AdminHours",Double.toString(wh.getTotalAdminHours()));
						variables.put("bean.HolyDayHours",Double.toString(wh.getTotalHolyday()));
						variables.put("bean.vacationHours",Double.toString(wh.getTotalVacation()));
						variables.put("bean.GT",Double.toString(wh.getGT()));
						variables.put("bean.Name",wh.getEmpNm());
						
						
						
						
						
						
						
						documentPart.variableReplace(variables);
						
						
						
						
						
						File f2 = new File("C://Users//hamha//Desktop//"+txtPayRollName.getText()+".docx");
						
						Docx4J.save(wordMLPackage, f2);
						Desktop.getDesktop().open(f2);

						
					
					
						
						
						
					}catch(Exception x) {
						
						
						JOptionPane.showMessageDialog(null, "the error is in the pasteup btn");
				
					
					}
					
				}
				else  {
					
					
					JOptionPane.showMessageDialog(null, "Please Write A Name For The File !!!!");
					
				}
				

			
				
				}
				

			}
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

			
			
			
			
				
				
			
			
		);
		
		
		
		
		
		btnNewButton.setBounds(576, 113, 136, 45);
		contentPane.add(btnNewButton);
		
		JButton btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emp_Info wh = new Emp_Info();
				
				ComboName.setSelectedIndex(-1); ;
				txtworkhours.setText("") ;
				
				txtvacation.setText("");
				txtholyday.setText("");
				txtadminhours.setText("");
			}
		});
		btnclear.setBounds(576, 174, 136, 45);
		contentPane.add(btnclear);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(255, 215, 0));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				HomePage ho =new HomePage();
				ho.setVisible(true);
				
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hamha\\eclipse-workspace\\CoTeDePayRolll\\Images\\126492.png"));
		lblNewLabel_2.setBounds(12, 372, 128, 75);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblGTotal = new JLabel("");
		lblGTotal.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblGTotal.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGTotal.setOpaque(true);
		lblGTotal.setBackground(new Color(248, 248, 255));
		lblGTotal.setBounds(355, 383, 94, 38);
		contentPane.add(lblGTotal);
		
		JLabel lblNewLabel_4 = new JLabel("$");
		lblNewLabel_4.setForeground(new Color(255, 255, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4.setBounds(461, 383, 24, 35);
		contentPane.add(lblNewLabel_4);
		
		JButton btnsum = new JButton("Sum Of Hours");
		btnsum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if( IsValidBlanks() == true) {
					
				int totHWorked = Integer.parseInt(txtworkhours.getText());
				int totHVacation = Integer.parseInt(txtvacation.getText());
				int totHolydays = Integer.parseInt(txtholyday.getText());
				int totAdminHours = Integer.parseInt(txtadminhours.getText());
				
				 total = String.valueOf(totHWorked+ totHVacation+ totHolydays + totAdminHours);
				lblGTotal.setText(total);
				}else {
					
					JOptionPane.showMessageDialog(null,"please fill the empty blanks","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnsum.setBounds(576, 232, 136, 45);
		contentPane.add(btnsum);
		
		txtPayRollName = new JTextField();
		txtPayRollName.setForeground(Color.BLACK);
		txtPayRollName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPayRollName.setColumns(10);
		txtPayRollName.setBackground(Color.ORANGE);
		txtPayRollName.setBounds(576, 385, 149, 35);
		contentPane.add(txtPayRollName);
		
		JLabel lblFileName = new JLabel("File Name ");
		lblFileName.setForeground(new Color(240, 248, 255));
		lblFileName.setFont(new Font("Verdana", Font.BOLD, 18));
		lblFileName.setBackground(new Color(248, 248, 255));
		lblFileName.setBounds(592, 343, 188, 35);
		contentPane.add(lblFileName);
		
		
		
		
		
	}
	
	private boolean IsValidBlanks() {
		boolean val = true;
		
	try {
		
		
		
		int totHWorked = Integer.parseInt(txtworkhours.getText());
		int totHVacation = Integer.parseInt(txtvacation.getText());
		int totHolydays = Integer.parseInt(txtholyday.getText());
		int totAdminHours = Integer.parseInt(txtadminhours.getText());
		
		
		
		
		
		
	}catch(Exception e) {
		
		val =false;
		
		
		
	}

return val;

	
	}
	
	
	
	
	
	
	private boolean valed() {
		
		boolean val = true;
		
		
		
		
		
		String name = txtPayRollName.getText().trim();
		String ss = txtPayRollName.getText().trim();
		if(name.isEmpty() ) {
		   
		    val = false;
		    
		} else{
		 val =true;
		}
//	try {
//		
//		
//		txtPayRollName.getText().trim().equals(null) ;
//		txtPayRollName.getText().trim().equals("") ;
//		
//		
//		
//		
//	}
//	catch(Exception e) {
//		
//		val =false;
//		
//		
//		
//	}
		
	return val;
	}
}
