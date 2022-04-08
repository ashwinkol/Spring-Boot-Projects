package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.entity.Notice_Board;
import com.project.entity.Response;
import com.project.repository.Notice_BoardDao;

@Service
public class Notice_BoardDaoImpl {

	@Autowired
	private Notice_BoardDao NoticeDao;

	public String addNotice(@RequestBody Notice_Board notice) {
		NoticeDao.save(notice);

		return "Notice Added";
	}
	
	public ResponseEntity<?> deleteNotice(int id){
		NoticeDao.deleteById(id);
		return Response.success("Notice Deleted Sucsessfully");
	}
	
	public List<Notice_Board> getNoticeBoard() {
		List<Notice_Board> NoticeBoardData = NoticeDao.findAll();
		return NoticeBoardData;
	}
}
