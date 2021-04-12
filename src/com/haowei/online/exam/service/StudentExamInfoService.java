package com.haowei.online.exam.service;

import java.util.List;

import com.haowei.online.exam.po.StudentExamInfo;
import org.springframework.stereotype.Repository;

/**
  *
  * <p>Title: StudentExamInfoService</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2021-01-19
  * @time: 上午10:08:46
  * @version: 1.0
  */

@Repository
public interface StudentExamInfoService {

	//后台教师根据查看某一班级下所有学生考试数量
	public List<StudentExamInfo> getStudentExamCountByClassId(int classId);
	
	//后台教师查看某一学生的考试信息
	public List<StudentExamInfo> getStudentExamInfo(int studentId);
	
	//后台教师查看指定班级中所有学生的平均成绩以及考试次数
	public List<StudentExamInfo> getAllStudentAvgScoreCount(int classId);
}
