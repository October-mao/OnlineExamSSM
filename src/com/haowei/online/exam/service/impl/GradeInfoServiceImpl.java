package com.haowei.online.exam.service.impl;

import java.util.List;

import com.haowei.online.exam.dao.GradeInfoMapper;
import com.haowei.online.exam.po.GradeInfo;
import com.haowei.online.exam.service.GradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haowei.online.exam.dao.GradeInfoMapper;
import com.haowei.online.exam.po.GradeInfo;
import com.haowei.online.exam.service.GradeInfoService;

/**
  *
  * <p>Title: GradeInfoServiceImpl</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-14
  * @time: 上午9:57:27
  * @version: 1.0
  */

@Service
public class GradeInfoServiceImpl implements GradeInfoService {

	@Autowired
	private GradeInfoMapper gradeInfoMapper;
	
	public List<GradeInfo> getGrades() {
		return gradeInfoMapper.getGrades();
	}

	public int isAddGrade(GradeInfo grade) {
		return gradeInfoMapper.isAddGrade(grade);
	}

	public int isDelGrade(int gradeId) {
		return gradeInfoMapper.isDelGrade(gradeId);
	}

	public int isUpdateGrade(GradeInfo grade) {
		return gradeInfoMapper.isUpdateGrade(grade);
	}

	public GradeInfo getGradeById(int gradeId) {
		return gradeInfoMapper.getGradeById(gradeId);
	}

}
