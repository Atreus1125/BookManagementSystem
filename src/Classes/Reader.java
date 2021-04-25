package Classes;

public class Reader 
{
	private int rno;
	private String rname;
	private String rsex;
	private String rdept;
	private String rpassword;
	
	public Reader() {
		
	}
	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRsex() {
		return rsex;
	}

	public void setRsex(String rsex) {
		this.rsex = rsex;
	}

	public String getRdept() {
		return rdept;
	}

	public void setRdept(String rdept) {
		this.rdept = rdept;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	@Override
	public String toString() {
		return "Reader [rno=" + rno + ", rname=" + rname
				+ ", rsex=" + rsex + ", rdept=" + rdept + ", rpassward="
				+ rpassword + "]";
	}

	public Reader(int rno, String rname, String rsex, String rdept,
			String rpassword) {
		super();
		this.rno = rno;
		this.rname = rname;
		this.rsex = rsex;
		this.rdept = rdept;
		this.rpassword = rpassword;
	}
	
}
