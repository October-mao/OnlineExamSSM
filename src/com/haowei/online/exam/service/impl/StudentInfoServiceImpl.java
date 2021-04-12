package com.haowei.online.exam.service.impl;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.dao.StudentInfoMapper;
import com.haowei.online.exam.po.StudentInfo;
import com.haowei.online.exam.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haowei.online.exam.dao.StudentInfoMapper;
import com.haowei.online.exam.po.StudentInfo;
import com.haowei.online.exam.service.StudentInfoService;

/**
  *
  * <p>Title: StudentInfoServiceImpl</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-16
  * @time: 上午10:20:39
  * @version: 1.0
  */

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	private StudentInfoMapper studentInfoMapper;
	
	public List<StudentInfo> getStudents(Map<String, Object> map) {
		return studentInfoMapper.getStudents(map);
	}

	public StudentInfo getStudentById(int studentId) {
		return studentInfoMapper.getStudentById(studentId);
	}

	public int isUpdateStudent(StudentInfo student) {
		return studentInfoMapper.isUpdateStudent(student);
	}

	public int isDelStudent(int studentId) {
		return studentInfoMapper.isDelStudent(studentId);
	}

	public int isAddStudent(StudentInfo student) {
		return studentInfoMapper.isAddStudent(student);
	}

	public int getStudentTotal() {
		return studentInfoMapper.getStudentTotal();
	}

	public StudentInfo getStudentByAccountAndPwd(String studentAccount) {
		return studentInfoMapper.getStudentByAccountAndPwd(studentAccount);
	}

	public int isResetPwdWithStu(StudentInfo studentInfo) {
		return studentInfoMapper.isResetPwdWithStu(studentInfo);
	}

	public List<StudentInfo> getStudentsByClassId(int classId) {
		return studentInfoMapper.getStudentsByClassId(classId);
	}

}
