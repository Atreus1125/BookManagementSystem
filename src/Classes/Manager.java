package Classes;

public class Manager 
{
	private int mno;
	private String mpassword;
	
	public Manager() {
		
	}
	
	public int getMno() {
		return mno;
	}
	
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	public String getMpassword() {
		return mpassword;
	}
	
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	
	@Override
	public String toString() {
		return "Manager [mno=" + mno + ", mpassword="
				+ mpassword + "]";
	}
	
	public Manager(int mno, String mpassword) {
		super();
		this.mno = mno;
		this.mpassword = mpassword;
	}
}
