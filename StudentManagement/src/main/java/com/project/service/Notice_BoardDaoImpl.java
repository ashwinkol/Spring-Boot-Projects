package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.entity.Notice_Board;
import com.project.repository.Notice_BoardDao;

@Service
public class Notice_BoardDaoImpl {

	@Autowired
	private Notice_BoardDao NoticeDao;

	public String addNotice(@RequestBody Notice_Board notice) {
		NoticeDao.save(notice);

		return "Notice Added";
	}
}
