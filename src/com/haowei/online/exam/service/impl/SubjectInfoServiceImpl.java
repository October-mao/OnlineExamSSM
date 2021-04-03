package com.haowei.online.exam.service.impl;

import java.util.List;
import java.util.Map;

import com.haowei.online.exam.dao.SubjectInfoMapper;
import com.haowei.online.exam.po.SubjectInfo;
import com.haowei.online.exam.service.SubjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haowei.online.exam.dao.SubjectInfoMapper;

/**
  *
  * <p>Title: SubjectInfoServiceImpl</p>
  * <p>Description: </p>
  * @author: taohan
  * @date: 2018-8-17
  * @time: 下午4:32:18
  * @version: 1.0
  */

@Service
public class SubjectInfoServiceImpl implements SubjectInfoService {

	@Autowired
	private SubjectInfoMapper subjectInfoMapper;
	
	public List<SubjectInfo> getSubjects(Map<String, Object> map) {
		return subjectInfoMapper.getSubjects(map);
	}
	
	public SubjectInfo getSubjectWithId(int subjectId) {
		return subjectInfoMapper.getSubjectWithId(subjectId);
	}

	public int getSubjectTotal() {
		return subjectInfoMapper.getSubjectTotal();
	}

	public int isAddSubject(SubjectInfo subject) {
		return subjectInfoMapper.isAddSubject(subject);
	}

	public int isUpdateSubject(SubjectInfo subject) {
		return subjectInfoMapper.isUpdateSubject(subject);
	}

	public int isDelSubject(int subjectId) {
		return subjectInfoMapper.isDelSubject(subjectId);
	}

	/**
	 * 批量添加试题
	 */
	public int isAddSubjects(Map<String, Object> subjects) {
		return subjectInfoMapper.isAddSubjects(subjects);
	}

}
