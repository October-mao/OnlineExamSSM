package com.haowei.online.exam.dao;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.po.ExamPlanInfo;
import org.springframework.stereotype.Repository;

/**
  *
  * <p>Title: ExamPlanInfoMapper</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-22
  * @time: 下午4:04:26
  * @version: 1.0
  */

@Repository
public interface ExamPlanInfoMapper {

	public List<ExamPlanInfo> getExamPlans(Map<String, Object> map);
	
	public int isAddExamPlan(ExamPlanInfo examPlan);

	public int isUpdateExamPlan(ExamPlanInfo examPlan);
	
	public ExamPlanInfo getExamPlanById(int examPlanId);
	
	//查询学生待考信息
	public List<ExamPlanInfo> getStudentWillExam(Map<String, Object> map);
	
	public int isRemoveExamPlan(int examPlanId);
}
