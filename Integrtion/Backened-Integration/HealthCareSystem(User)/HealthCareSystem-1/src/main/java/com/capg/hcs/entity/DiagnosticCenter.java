package com.capg.hcs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*****************************************************************************************************
 * @author        Anjali Sharma
 * Description    It is a Entity calss that 
 *                specifies that the class  is mapped to a database
 *                table with suitable columns.
 * Version        1.0
 * Created Date   06-MAY-2020 
 *
 ****************************************************************************************************/
@Entity
@Table(name = "DiagnosticCenter")
public class DiagnosticCenter {

	@Id
	@Column(name = "center_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer centerId;

	@Column(name = "centerName")
	private String centerName;
	
	@Column(name = "centerLocation")
	private String centerLocation;
	

	
	public String getCenterLocation() {
		return centerLocation;
	}

	public void setCenterLocation(String centerLocation) {
		this.centerLocation = centerLocation;
	}

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Test.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "center_no", referencedColumnName = "center_id")

	
	public List<Test> listOftests;

	
	  @OneToMany(fetch = FetchType.EAGER,targetEntity = Appointment.class)
	  
	  @Fetch(value = FetchMode.SUBSELECT)
	  
	  @JoinColumn(name = "center_id", referencedColumnName = "center_id") private
	  List<Appointment> appointment;
	 
	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<Test> getListOftests() {
		return listOftests;
	}

	public void setListOftests(List<Test> listOftests) {
		this.listOftests = listOftests;
	}

	
	  public List<Appointment> getAppointment() { return appointment; }
	  
	  public void setAppointment(List<Appointment> appointment) { this.appointment
	  = appointment; }
	 

	

	public DiagnosticCenter(Integer centerId, String centerName, String centerLocation, List<Test> listOftests,
			List<Appointment> appointment) 
			{
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.centerLocation=centerLocation;
		this.listOftests = listOftests;
		
		this.appointment = appointment;
	}

	public DiagnosticCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
