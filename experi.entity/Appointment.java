package experi.entity;

//import java.sql.Timestamp;

public class Appointment {
	private String doc_id;
	private String pat_id;
	private String apmt_date;
	private String apmt_note;
	
	public Appointment() {
		super();
	}
	
	public Appointment(String doc_id, String pat_id, String apmt_date, String apmt_note) {
		super();
		this.doc_id = doc_id;
		this.pat_id = pat_id;
		this.apmt_date = apmt_date;
		this.apmt_note = apmt_note;
	}
	
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getPat_id() {
		return pat_id;
	}
	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}
	public String getAppointmentDate() {
		return apmt_date;
	}
	public void setAppointmentDate(String apmt_date) {
		this.apmt_date = apmt_date;
	}
	public String getAppointmentNote() {
		return apmt_note;
	}
	public void setAppointmentNote(String apmt_note) {
		this.apmt_note = apmt_note;
	}
}