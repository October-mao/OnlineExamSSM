package com.haowei.online.exam.service.impl;

import java.util.List;

import com.haowei.online.exam.dao.StudentExamInfoMapper;
import com.haowei.online.exam.po.StudentExamInfo;
import com.haowei.online.exam.service.StudentExamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  *
  * <p>Title: StudentExamInfoServiceImpl</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2021-01-19
  * @time: 上午10:09:21
  * @version: 1.0
  */

@Service
public class StudentExamInfoServiceImpl implements StudentExamInfoService {

	@Autowired
	private StudentExamInfoMapper studentExamInfoMapper;
	
	public List<StudentExamInfo> getStudentExamCountByClassId(int classId) {
		return studentExamInfoMapper.getStudentExamCountByClassId(classId);
	}

	public List<StudentExamInfo> getStudentExamInfo(int studentId) {
		return studentExamInfoMapper.getStudentExamInfo(studentId);
	}

	public List<StudentExamInfo> getAllStudentAvgScoreCount(int classId) {
		return studentExamInfoMapper.getAllStudentAvgScoreCount(classId);
	}

}
