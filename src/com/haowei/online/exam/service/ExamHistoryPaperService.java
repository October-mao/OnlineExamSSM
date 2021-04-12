package com.haowei.online.exam.service;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.po.ExamHistoryInfo;
import com.haowei.online.exam.po.ExamHistoryPaper;
import org.springframework.stereotype.Repository;

import com.haowei.online.exam.po.ExamHistoryInfo;
import com.haowei.online.exam.po.ExamHistoryPaper;

/**
  *
  * <p>Title: ExamHistoryPaperService</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-29
  * @time: 下午4:45:27
  * @version: 1.0
  */

@Repository
public interface ExamHistoryPaperService {

	//查询考试历史信息，针对前台学生查询
	public List<ExamHistoryPaper> getExamHistoryToStudent(int studentId);
	
	public int isAddExamHistory(Map<String, Object> map);
	
	public int getHistoryInfoWithIds(Map<String, Object> map);
	
	public List<ExamHistoryInfo> getExamHistoryToTeacher();
}
