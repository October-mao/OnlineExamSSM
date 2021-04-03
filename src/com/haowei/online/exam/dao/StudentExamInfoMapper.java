package com.haowei.online.exam.dao;

import java.util.List;

import com.haowei.online.exam.po.StudentExamInfo;
import org.springframework.stereotype.Repository;

/**
  *
  * <p>Title: StudentExamInfoMapper</p>
  * <p>Description: </p>
  * @author: taohan
  * @date: 2018-9-19
  * @time: 上午10:07:04
  * @version: 1.0
  */

@Repository
public interface StudentExamInfoMapper {

	//后台教师根据查看某一班级下所有学生考试数量
	public List<StudentExamInfo> getStudentExamCountByClassId(int classId);
	
	//后台教师查看某一学生的考试信息
	public List<StudentExamInfo> getStudentExamInfo(int studentId);
	
	public List<StudentExamInfo> getAllStudentAvgScoreCount(int classId);
}
