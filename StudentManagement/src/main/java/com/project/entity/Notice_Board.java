package com.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notice_Board")
public class Notice_Board {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int NoticeId;
	@Column
	private int Course_Name;
	@Column
	private String Title;
	@Column
	private String Description;
	@Column
	private Date Notice_Date;
	
	public Notice_Board() {
		
	}

	public int getNoticeId() {
		return NoticeId;
	}

	public void setNoticeId(int noticeId) {
		NoticeId = noticeId;
	}

	public int getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(int course_Name) {
		Course_Name = course_Name;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getNotice_Date() {
		return Notice_Date;
	}

	public void setNotice_Date(Date notice_Date) {
		Notice_Date = notice_Date;
	}

	@Override
	public String toString() {
		return "Notice_Board [NoticeId=" + NoticeId + ", Course_Name=" + Course_Name + ", Title=" + Title
				+ ", Description=" + Description + ", Notice_Date=" + Notice_Date + "]";
	}
	
	
}
