package com.haowei.online.exam.dao;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.po.ExamChooseInfo;
import org.springframework.stereotype.Repository;

import com.haowei.online.exam.po.ExamChooseInfo;

/**
  *
  * <p>Title: ExamChooseInfoMapper</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-25
  * @time: 上午10:33:21
  * @version: 1.0
  */

@Repository
public interface ExamChooseInfoMapper {

	public ExamChooseInfo getChooseWithIds(Map<String, Object> map);
	
	public int updateChooseWithIds(ExamChooseInfo examChoose);
	
	public int addChoose(Map<String, Object> map);
	
	public List<ExamChooseInfo> getChooseInfoWithSumScore(Map<String, Object> map);
	
	public List<ExamChooseInfo> getChooseInfoWithExamSubject(Map<String, Object> map);
}
