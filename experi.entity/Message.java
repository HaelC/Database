package experi.entity;

public class Message {
	
	private String doc_id;
	private String pat_id;
	private String mes_text;
	private String mes_time;
	private int mes_sentByDoc;
	
	public Message() {
		super();
	}
	
	public Message(String doc_id, String pat_id, String mes_text, String mes_time, int mes_sentByDoc) {
		this.doc_id = doc_id;
		this.pat_id = pat_id;
		this.mes_text = mes_text;
		this.mes_time = mes_time;
		this.mes_sentByDoc = mes_sentByDoc;
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
	public String getMes_text() {
		return mes_text;
	}
	public void setMes_text(String mes_text) {
		this.mes_text = mes_text;
	}
	public String getMes_time() {
		return mes_time;
	}
	public void setMes_time(String mes_time) {
		this.mes_time = mes_time;
	}
	public int getMes_sentByDoc() {
		return mes_sentByDoc;
	}
	public void setMes_sentByDoc(int mes_sentByDoc) {
		this.mes_sentByDoc = mes_sentByDoc;
	}
}
