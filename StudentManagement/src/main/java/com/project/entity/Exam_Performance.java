package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Exam_Performance")
public class Exam_Performance {
	@Id
	@Column
	private int Roll_No;
	@Column
	private int Subject_Id;
	@Column
	private int Internal_Marks;
	@Column
	private int Lab_Marks;
	@Column
	private int Total;
	@Column
	private String Status;
	
	public Exam_Performance() {
		
	}

	public Exam_Performance(int roll_No, int subject_Id, int internal_Marks, int lab_Marks, int total, String status) {
		super();
		Roll_No = roll_No;
		Subject_Id = subject_Id;
		Internal_Marks = internal_Marks;
		Lab_Marks = lab_Marks;
		Total = total;
		Status = status;
	}
	
	

	public int getRoll_No() {
		return Roll_No;
	}

	public void setRoll_No(int roll_No) {
		Roll_No = roll_No;
	}

	public int getSubject_Id() {
		return Subject_Id;
	}

	public void setSubject_Id(int subject_Id) {
		Subject_Id = subject_Id;
	}

	public int getInternal_Marks() {
		return Internal_Marks;
	}

	public void setInternal_Marks(int internal_Marks) {
		Internal_Marks = internal_Marks;
	}

	public int getLab_Marks() {
		return Lab_Marks;
	}

	public void setLab_Marks(int lab_Marks) {
		Lab_Marks = lab_Marks;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Exam_Performance [Roll_No=" + Roll_No + ", Subject_Id=" + Subject_Id + ", Internal_Marks="
				+ Internal_Marks + ", Lab_Marks=" + Lab_Marks + ", Total=" + Total + ", Status=" + Status + "]";
	}
	
	
}
