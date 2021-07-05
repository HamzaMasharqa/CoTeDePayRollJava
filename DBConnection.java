package PayRoll;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DBConnection {

	
	 private String dbURL= "jdbc:ucanaccess://C://Users//hamha//eclipse-workspace//CoTeDePayRolll//CoTeDe.accdb";
	
	 private String tableName = "EMP_INFO";
	    private Connection conn = null;
	    private PreparedStatement stmt = null;
	    
		ResultSet rs = null;
		PreparedStatement ps = null;
		
	    public DBConnection() {};
	    
	
	    
	    //Open Connection Function 
	    
	    public void openConnection(){
	        try{
	            
	            
	            
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            conn = DriverManager.getConnection(dbURL);
	           
	        }
	        catch(Exception e){
	        JOptionPane.showMessageDialog(null, "Connection failed to open", "Error", 
	                JOptionPane.ERROR_MESSAGE);
	        System.out.println(e.getMessage());
	        
	        
	        }
	    }
	
	    
	    
	    
	  //Close Connection Function 
	    
	    public void CloseConnection() {
	    	try {
	    		
	    	
	    	conn.close();
	    	conn = null;
	    	
	    	
	    	
	    	}catch(Exception e) {
	    		
	    		
	    	JOptionPane.showMessageDialog(null, "Connection Failed To Close !!!!","Error",JOptionPane.ERROR_MESSAGE);	
	    	
	    	
	    		
	    		
	    		
	    	}
	    	
	    	
	    	
	    }
	   
		
	

}
