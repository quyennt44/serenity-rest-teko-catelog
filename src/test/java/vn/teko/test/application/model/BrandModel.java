package vn.teko.test.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
@NamedNativeQuery(name="BrandModel.selectRandomId", query="SELECT id FROM brands ORDER BY RAND() LIMIT 1")
public class BrandModel {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_active")
	private int is_active;	
	
	@Column(name = "doc_request")
	private int doc_request;
	
	@Column(name = "approved_status")
	private int approved_status;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "internal_code")
	private String internal_code;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getIs_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	
	
	public int getDoc_request() {
		return doc_request;
	}
	public void setDoc_request(int doc_request) {
		this.doc_request = doc_request;
	}
	
	
	public int getApproved_status() {
		return approved_status;
	}
	public void setApproved_status(int approved_status) {
		this.approved_status = approved_status;
	}
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	

	public String getInternal_code() {
		return internal_code;
	}
	public void setInternal_code(String internal_code) {
		this.internal_code = internal_code;
	}
	
	
}
