package PayRoll;

public class Emp_Info {
	
	
	

	private double totalWorkHours ;
	
	private double totalVacation ;
	
	private double totalHolyday ;
	
	private double totalAdminHours ;
	private double GT ;
	
	private String EmpNm ;
	
	
	
	
	
	
	public Emp_Info(){};
	
	
	
	public Emp_Info( double TWH, double TV, double TH , double TAH,String emp_name )  {
		
		super();
		
		this.setEmpNm(emp_name);
		
		this.setTotalWorkHours(TWH);
		this.setTotalVacation(TV);
		this.setTotalHolyday(TH);
		this.setTotalAdminHours(TAH);
		
		
		
		
		
	}

	
	public String getEmpNm() {
		return EmpNm;
	}
	public String setEmpNm(String EmpNm) {
		return this.EmpNm = EmpNm;
	}


	public double getTotalWorkHours() {
		return totalWorkHours;
	}


	public void setTotalWorkHours(double totalWorkHours) {
		this.totalWorkHours = totalWorkHours;
	}


	public double getTotalVacation() {
		return totalVacation;
	}


	public void setTotalVacation(double totalVacation) {
		this.totalVacation = totalVacation;
	}


	public double getTotalHolyday() {
		return totalHolyday;
	}


	public void setTotalHolyday(double totalHolyday) {
		this.totalHolyday = totalHolyday;
	}


	public double getTotalAdminHours() {
		return totalAdminHours;
	}


	public void setTotalAdminHours(double totalAdminHours) {
		this.totalAdminHours = totalAdminHours;
	}



	public double getGT() {
		return GT;
	}



	public void setGT(double gT) {
		GT = gT;
	}


	
	
	
	
	
	
	
	

}
