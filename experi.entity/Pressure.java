package experi.entity;

import java.sql.Timestamp;

public class Pressure {
	
	private String pressure_id;
	private String pat_id;
	private String pressure_Systolic;
	private String pressure_Diastolic;
	private Timestamp pressure_RecordTime;
	
	public Pressure() {
		super();
	}
	
	public Pressure(String pressure_id, String pat_id, String pressure_Systolic, String pressure_Diastolic, Timestamp pressure_RecordTime) {
		this.pressure_id = pressure_id;
		this.pat_id = pat_id;
		this.pressure_Systolic = pressure_Systolic;
		this.pressure_Diastolic = pressure_Diastolic;
		this.pressure_RecordTime = pressure_RecordTime;
	}
	
	public String getPressure_id() {
		return pressure_id;
	}
	public void setPressure_id(String pressure_id) {
		this.pressure_id = pressure_id;
	}
	public String getPat_id() {
		return pat_id;
	}
	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}
	public String getPressure_Systolic() {
		return pressure_Systolic;
	}
	public void setPressure_Systolic(String pressure_Systolic) {
		this.pressure_Systolic = pressure_Systolic;
	}
	public String getPressure_Diastolic() {
		return pressure_Diastolic;
	}
	public void setPressure_Diastolic(String pressure_Diastolic) {
		this.pressure_Diastolic = pressure_Diastolic;
	}
	public Timestamp getPressure_RecordTime() {
		return pressure_RecordTime;
	}
	public void setPressure_RecordTime(Timestamp pressure_Record_Time) {
		this.pressure_RecordTime = pressure_Record_Time;
	}
}