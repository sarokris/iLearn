/**
 * Edit
 */
package com.example.pojo;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Admin
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstarctAuditEntity {
	
	@CreatedBy
	@Column(name="created_by",nullable=false,updatable=false,length=50)
	private String createdBy;
	
	@CreatedDate
	@Column(name="created_time",nullable=false,updatable=false)
	private ZonedDateTime createdTime;
	
	@LastModifiedBy
	@Column(name="last_modified_by",updatable=false,length=50)
	private String lastModifiedBy;
	
	@LastModifiedDate
	@Column(name="last_modified_time",updatable=false)
	private ZonedDateTime lastModifiedDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public ZonedDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(ZonedDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public ZonedDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	} 

}
