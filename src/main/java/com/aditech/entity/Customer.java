package com.aditech.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer_deatails")
public class Customer implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	
	private String name;
	
	private String lName;
	
	private int MobNo;
	
	@Column(unique = true, length = 100, nullable = false)
	private String email;
	private String password;
	private Date Dob;
	@UpdateTimestamp
	@Column(updatable=false,name="created_At")
	private Date createAt;
	@CreationTimestamp
	@Column(name="updated_At")
	private Date updateAt;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return List.of();
	}
	@Override
	public String getUsername() {
		
		return email;
	}
	
	 public String getPassword() {
	        return password;
	    }
	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
