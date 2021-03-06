package com.haowei.online.exam.dao;

import java.util.List;

import com.haowei.online.exam.po.GradeInfo;
import org.springframework.stereotype.Repository;

import com.haowei.online.exam.po.GradeInfo;

/**
  *
  * <p>Title: GradeInfoMapper</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-14
  * @time: 上午9:55:46
  * @version: 1.0
  */

@Repository
public interface GradeInfoMapper {

	//获取所有年级
	public List<GradeInfo> getGrades();
	
	//根据编号获取年级
	public GradeInfo getGradeById(int gradeId);
	
	//添加年级
	public int isAddGrade(GradeInfo grade);
	
	//删除年级
	public int isDelGrade(int gradeId);
	
	//修改年级
	public int isUpdateGrade(GradeInfo grade);
}
