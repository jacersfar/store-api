package org.eclipse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin extends User{
	@Column(name="name")
	private String name;
	@Column(name="admin")
	private boolean admin = true;
	public Admin() {
		super();
	}

	
	public Admin(long id, String email, String password) {
		super(id, email, password);
	}


	public Admin(long id, String email, String password, String name) {
		super(id, email, password);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", id=" + id + ", email=" + email + ", password=" + password + "]";
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	

}
