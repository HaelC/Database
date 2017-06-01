package experi.entity;

public class Rate {
	
	private String pat_id;
	private String rate_docID;
	private int rate_score;
	private String rate_date;
	
	public Rate() {
		super();
	}
	
	public Rate(String pat_id, String rate_docID, int rate_score, String rate_date) {
		super();
		this.pat_id = pat_id;
		this.rate_docID = rate_docID;
		this.rate_score = rate_score;
		this.rate_date = rate_date;
	}
	
	public String getPat_id() {
		return pat_id;
	}
	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}
	public String getRate_docID() {
		return rate_docID;
	}
	public void setRate_docID(String rate_docID) {
		this.rate_docID = rate_docID;
	}
	public int getRate_score() {
		return rate_score;
	}
	public void setRate_score(int rate_score) {
		this.rate_score = rate_score;
	}
	public String getRate_date() {
		return rate_date;
	}
	public void setRate_date(String rate_date) {
		this.rate_date = rate_date;
	}
}