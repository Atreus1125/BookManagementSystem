package Classes;

public class Borrow 
{
	private int id;
	private int rno;
	private int bno;
	private String bdate;
	private String rdate;
	
	public Borrow() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", rno=" + rno + ", bno=" + bno
				+ ", bdate=" + bdate + ", rdate=" + rdate + "]";
	}

	public Borrow(int id, int rno, int bno, String bdate, String rdate) {
		super();
		this.id = id;
		this.rno = rno;
		this.bno = bno;
		this.bdate = bdate;
		this.rdate = rdate;
	}
}
