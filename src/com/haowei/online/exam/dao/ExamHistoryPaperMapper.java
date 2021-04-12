package com.haowei.online.exam.dao;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.po.ExamHistoryInfo;
import com.haowei.online.exam.po.ExamHistoryPaper;
import org.springframework.stereotype.Repository;

/**
  *
  * <p>Title: ExamHistoryPaperMapper</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-29
  * @time: 下午4:44:07
  * @version: 1.0
  */

@Repository
public interface ExamHistoryPaperMapper {

	//查询考试历史信息，针对前台学生查询
	public List<ExamHistoryPaper> getExamHistoryToStudent(int studentId);
	
	public int isAddExamHistory(Map<String, Object> map);
	
	public int getHistoryInfoWithIds(Map<String, Object> map);
	
	//查询考试历史信息，针对后台教师查询
	public List<ExamHistoryInfo> getExamHistoryToTeacher();
}
