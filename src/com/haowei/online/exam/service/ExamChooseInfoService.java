package com.haowei.online.exam.service;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.po.ExamChooseInfo;
import org.springframework.stereotype.Repository;

/**
  *
  * <p>Title: ExamChooseInfoService</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-25
  * @time: 上午10:34:29
  * @version: 1.0
  */

@Repository
public interface ExamChooseInfoService {

	public ExamChooseInfo getChooseWithIds(Map<String, Object> map);

	public int updateChooseWithIds(ExamChooseInfo examChoose);
	
	public int addChoose(Map<String, Object> map);
	
	public List<ExamChooseInfo> getChooseInfoWithSumScore(Map<String, Object> map);
	
	public List<ExamChooseInfo> getChooseInfoWithExamSubject(Map<String, Object> map);
}
