package com.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Time_Table;
@Repository
@Transactional
public interface Time_TableDao extends JpaRepository<Time_Table, Integer>{

	@Query(value = "select id,Day,Date,ZoomId,zoomPassword,Name as Course from Time_Table inner join Course on Time_Table.Course = Course.CourseId",nativeQuery = true)
	public List<Time_Table> getTimeTable();
	
	@Modifying
	@Query("delete from Time_Table where id = ?1")
	public void deleteTimeTable(int id);
	
}
 