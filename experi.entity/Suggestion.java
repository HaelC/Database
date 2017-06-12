package experi.entity;

public class Suggestion {
	
	private String pat_id;
	private String sug_main;
	private String sug_time;
	
	public Suggestion() {
		super();
	}
	
	public Suggestion(String pat_id, String sug_main, String sug_time) {
		this.pat_id = pat_id;
		this.sug_main = sug_main;
		this.sug_time = sug_time;
	}
	
	public String getPat_id() {
		return pat_id;
	}
	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}
	public String getSug_main() {
		return sug_main;
	}
	public void setSug_main(String sug_main) {
		this.sug_main = sug_main;
	}
	public String getSug_time() {
		return sug_time;
	}
	public void setSug_time(String sug_time) {
		this.sug_time = sug_time;
	}
}