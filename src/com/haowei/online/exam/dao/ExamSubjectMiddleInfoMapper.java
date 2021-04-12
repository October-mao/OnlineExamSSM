package com.haowei.online.exam.dao;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.po.ExamSubjectMiddleInfo;
import org.springframework.stereotype.Repository;

/**
  *
  * <p>Title: ExamSubjectMiddleInfoMapper</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-20
  * @time: 下午4:15:55
  * @version: 1.0
  */

@Repository
public interface ExamSubjectMiddleInfoMapper {

	public List<ExamSubjectMiddleInfo> getExamPaperWithSubject(ExamSubjectMiddleInfo esm);
	
	public int isAddESM(Map<String, Object> map);
	
	public int removeSubjectWithExamPaper(Map<String, Object> map);
	
	public Integer getEsmByExamIdWithSubjectId(ExamSubjectMiddleInfo esm);
}
