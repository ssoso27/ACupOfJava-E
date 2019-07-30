package mycat;

public class BangMyungVO {
	private Integer no;
	private String gul;
	private String theTime;
	
		public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getGul() {
		return gul;
	}
	public void setGul(String gul) {
		this.gul = gul;
	}
	public String getTheTime() {
		return theTime;
	}
	public void setTheTime(String theTime) {
		this.theTime = theTime;
	}
	@Override
	public String toString() {
		return "[no=" + no + ", gul=" + gul + ", theTime=" + theTime + "]";
	}
	
}
