package com.haowei.online.exam.service;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.po.StudentInfo;
import org.springframework.stereotype.Repository;

/**
  *
  * <p>Title: StudentInfoService</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-16
  * @time: 上午10:19:51
  * @version: 1.0
  */

@Repository
public interface StudentInfoService {

	public List<StudentInfo> getStudents(Map<String, Object> map);

	public StudentInfo getStudentById(int studentId);

	public int isUpdateStudent(StudentInfo student);

	public int isDelStudent(int studentId);
	
	public int isAddStudent(StudentInfo student);
	
	public int getStudentTotal();
	
	public StudentInfo getStudentByAccountAndPwd(String studentAccount);
	
	public int isResetPwdWithStu(StudentInfo studentInfo);
	
	public List<StudentInfo> getStudentsByClassId(int classId);
}
