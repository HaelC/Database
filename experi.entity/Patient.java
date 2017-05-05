package experi.entity;

public class Patient {

	private String pat_id;
	private String pat_name;
	private String pat_password;
	private String pat_age;
	private String pat_mobile;
	private String pat_sex;
	private String pat_height;
	private String pat_weight;
	private String pat_familialDisease;
	private String pat_historyDisease;
	private String doctor;//name
	public Patient() {
		super();
	}
	public Patient(String pat_id, String pat_name, String password,String pat_age, String doctor) {
		super();
		this.pat_id = pat_id;
		this.pat_name = pat_name;
		this.pat_password=password;
		this.pat_age = pat_age;
		this.doctor = doctor;

	}
	public Patient(String pat_id, String pat_name, String pat_password,String pat_mobile) {
		super();
		this.pat_id = pat_id;
		this.pat_name = pat_name;
		this.pat_password = pat_password;
		this.pat_mobile = pat_mobile;
	}
	public Patient(String pat_id, String pat_sex, String pat_age, String pat_height, String pat_weight, String pat_familialDisease, String pat_historyDisease) {
		super();
		this.pat_id = pat_id;
		this.pat_sex = pat_sex;
		this.pat_height = pat_height;
		this.pat_weight = pat_weight;
		this.pat_familialDisease = pat_familialDisease;
		this.pat_historyDisease = pat_historyDisease;
	}
	public String getPat_id() {
		return pat_id;
	}
	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	
	public String getPassword() {
		return pat_password;
	}
	public void setPassword(String pat_password) {
		this.pat_password = pat_password;
	}
	public String getPat_age() {
		return pat_age;
	}
	public void setPat_age(String pat_age) {
		this.pat_age = pat_age;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public String getPat_mobile() {
		return pat_mobile;
	}
	public void setPat_mobile(String pat_mobile) {
		this.pat_mobile = pat_mobile;
	}
	public String getPat_sex() {
		return pat_sex;
	}
	public void setPat_sex(String pat_sex) {
		this.pat_sex = pat_sex;
	}
	public String getPat_height() {
		return pat_height;
	}
	public void setPat_height(String pat_height) {
		this.pat_height = pat_height;
	}
	public String getPat_weight() {
		return pat_weight;
	}
	public void setPat_weight(String pat_weight) {
		this.pat_weight = pat_weight;
	}
	public String getPat_familialDisease() {
		return pat_familialDisease;
	}
	public void setPat_familiarDisease(String pat_familialDisease) {
		this.pat_familialDisease = pat_familialDisease;
	}
	public String getPat_historyDisease() {
		return pat_historyDisease;
	}
	public void setPat_historyDisease(String pat_historyDisease) {
		this.pat_historyDisease = pat_historyDisease;
	}
}
