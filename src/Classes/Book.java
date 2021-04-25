package Classes;

public class Book 
{
	private int bno;
	private String bname;
	private String bsort;
	private String bstate;
	
	public Book() {
		
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBsort() {
		return bsort;
	}

	public void setBstor(String bsort) {
		this.bsort = bsort;
	}

	public String getBstate() {
		return bstate;
	}

	public void setBstate(String bstate) {
		this.bstate = bstate;
	}

	@Override
	public String toString() {
		return "Book [bno=" + bno + ", bname=" + bname
				+ ", bsort=" + bsort + ", bstate=" + bstate + "]";
	}

	public Book(int bno, String bname, String bsort, String bstate) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.bsort = bsort;
		this.bstate = bstate;
	}
	
}
