package PayRoll;

public class CompInfo {
	
	
	private String Comp_Name;
	private String comp_ID;
	private String Comp_Add;
	
	
	
	
	
	public CompInfo(){};
	


	public CompInfo(String CN,String CI ,String CA) {
		
		this.Comp_Add = CA;
		this.comp_ID =CI;
		this.Comp_Name = CN;
		
		
		
		
	}
	
	



	public String getComp_Add() {
		return Comp_Add;
	}





	public void setComp_Add(String comp_Add) {
		Comp_Add = comp_Add;
	}





	public String getComp_ID() {
		return comp_ID;
	}





	public void setComp_ID(String comp_ID) {
		this.comp_ID = comp_ID;
	}





	public String getComp_Name() {
		return Comp_Name;
	}





	public void setComp_Name(String comp_Name) {
		Comp_Name = comp_Name;
	};
	

}
