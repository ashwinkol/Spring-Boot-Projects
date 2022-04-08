package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Time_Table;
@Repository
public interface Time_TableDao extends JpaRepository<Time_Table, Integer>{

	@Query(value = "select Day,Date,ZoomId,zoomPassword,Name as Course from Time_Table inner join Course on Time_Table.Course = Course.CourseId",nativeQuery = true)
	public List<Time_Table> getTimeTable();
	
}
