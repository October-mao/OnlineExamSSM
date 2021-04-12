package com.haowei.online.exam.handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haowei.online.exam.po.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.haowei.online.exam.po.*;
import com.haowei.online.exam.service.*;

/**
  *
  * <p>Title: StudentInfoHandler</p>
  * <p>Description: </p>
  * @author: haowei
  * @date: 2020-12-16
  * @time: 上午10:22:22
  * @version: 1.0
  */

@Controller
@SuppressWarnings("all")
public class StudentInfoHandler {

	@Autowired
	private StudentInfoService studentInfoService;
	@Autowired
	private ClassInfoService classInfoService;
	@Autowired
	private ExamSubjectMiddleInfoService examSubjectMiddleInfoService;
	@Autowired
	private ExamHistoryPaperService examHistoryPaperService;
	@Autowired
	private ExamChooseInfoService examChooseInfoService;
	@Autowired
	private ExamSubjectMiddleInfo esm;
	@Autowired
	private ClassInfo classInfo;
	@Autowired
	private ExamPaperInfo examPaper;
	@Autowired
	private GradeInfo grade;
	@Autowired
	private StudentInfo student;
	
	@Autowired
	private ExamPaperInfoService examPaperInfoService;

	private Logger logger = Logger.getLogger(StudentInfoHandler.class);

	/**
	 * 获取学生集合
	 * @param studentId 学生编号
	 * @param classId 班级编号
	 * @param gradeId 年级编号
	 * @param startPage 起始页 default=1
	 * @param pageShow 页容量 default=10
	 * @return
	 */
	@RequestMapping("/students")
	public ModelAndView getCourses(@RequestParam(value = "studentId", required = false) Integer studentId,
			@RequestParam(value = "classId", required = false) Integer classId,
			@RequestParam(value = "gradeId", required = false) Integer gradeId,
			@RequestParam(value="startPage", required=false, defaultValue="1") Integer startPage,
			@RequestParam(value="pageShow", required=false, defaultValue="10") Integer pageShow ) {
		logger.info("获取学生集合  classId="+classId+", gradeId="+gradeId+", startPage="+startPage+", pageShow="+pageShow);
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/students");

		//查询条件处理
		StudentInfo student = new StudentInfo();
		if (studentId != null)
			student.setStudentId(studentId);
		if (classId != null) {
			classInfo.setClassId(classId);
			student.setClassInfo(classInfo);
		}
		if (gradeId != null) {
			grade.setGradeId(gradeId);
			student.setGrade(grade);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		//计算当前查询起始数据索引
		int startIndex = (startPage-1) * pageShow;
		map.put("student", student);
		map.put("startIndex", startIndex);
		map.put("pageShow", pageShow);
		List<StudentInfo> students = studentInfoService.getStudents(map);
		model.addObject("students", students);
		
		//获取学生总量
		int studentTotal = studentInfoService.getStudentTotal();
		//计算总页数
		int pageTotal = 1;
		if (studentTotal % pageShow == 0)
			pageTotal = studentTotal / pageShow;
		else
			pageTotal = studentTotal / pageShow + 1;			
		model.addObject("pageTotal", pageTotal);
		model.addObject("pageNow", startPage);

		return model;
	}

	/**
	 * 根据编号获取学生信息
	 * @param studentId
	 * @return
	 */
	@RequestMapping("/student/{studentId}")
	public ModelAndView getCourseById(@PathVariable("studentId") Integer studentId) {
		logger.info("获取学生 " + studentId);
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/studentedit");

		StudentInfo student = studentInfoService.getStudentById(studentId);
		model.addObject("student", student);
		List<ClassInfo> classes = classInfoService.getClasses(null);
		model.addObject("classes", classes);

		return model;
	}

	/**
	 * 添加/修改学生信息
	 * @param studentId
	 * @param isUpdate 操作标识
	 * @param studentName
	 * @param studentAccount
	 * @param studentPwd
	 * @param classId
	 * @return
	 */
	@RequestMapping(value = "/student/student", method = RequestMethod.POST)
	public String isUpdateOrAddCourse(
			@RequestParam(value = "studentId", required = false) Integer studentId,
			@RequestParam(value = "isupdate", required = false) Integer isUpdate,
			@RequestParam(value = "studentName", required = false) String studentName,
			@RequestParam("studentAccount") String studentAccount,
			@RequestParam("studentPwd") String studentPwd,
			@RequestParam("classId") Integer classId) {

		StudentInfo student = new StudentInfo();
			student.setStudentId(studentId);
			student.setStudentName(studentName);
			student.setStudentAccount(studentAccount);
			student.setStudentPwd(studentPwd);
			classInfo.setClassId(classId);
			student.setClassInfo(classInfo);

		if (isUpdate != null) {
			logger.info("修改学生 " + student + " 的信息");
			int row = studentInfoService.isUpdateStudent(student);
		} else {
			logger.info("添加学生 " + student + " 的信息");
			int row = studentInfoService.isAddStudent(student);
		}

		return "redirect:/students";
	}

	/**
	 * 删除学生
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
	public String isDelTeacher(@PathVariable("studentId") Integer studentId) {
		logger.info("删除学生 " + studentId);

		int row = studentInfoService.isDelStudent(studentId);

		return "redirect:/students";
	}

	/**
	 * 预添加学生
	 * @return
	 */
	@RequestMapping("/preAddStudent")
	public ModelAndView preAddStudent() {
		logger.info("预添加学生信息");
		ModelAndView model = new ModelAndView();
		model.setViewName("/admin/studentedit");
		List<ClassInfo> classes = classInfoService.getClasses(null);
		model.addObject("classes", classes);

		return model;
	}
	
	/**
	 * 学生考试登录验证
	 * 
	 * 此处验证并不合理 登录验证实现如下：
	 *   前台学生登录传入账户，后台根据账户获取学生密码
	 *   返回学生密码，前台登录焦点离开密码框使用 JavaScript 判断
	 * 
	 * @param studentAccount 学生登录账户
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/validateLoginStudent")
	public void validateLoginStudent(@RequestParam("studentAccount") String studentAccount,
			HttpServletResponse response) throws IOException {
		logger.info("学生账户 "+studentAccount+"，尝试登录考试");
		
		//获取需要登录的学生对象
		StudentInfo student = studentInfoService.getStudentByAccountAndPwd(studentAccount);
		
		if (student == null) {
			logger.error("登录学生账户 "+studentAccount+" 不存在");
			response.getWriter().print("n");
		} else {
			logger.error("登录学生账户 "+studentAccount+" 存在");
			response.getWriter().print(student.getStudentPwd());
		}
	}
	
	/**
	 * 学生登录考试
	 * @param student 登录学生
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/studentLogin", method=RequestMethod.POST)
	public ModelAndView studentLogin(StudentInfo student, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		StudentInfo loginStudent = studentInfoService.getStudentByAccountAndPwd(student.getStudentAccount());
		logger.info("学生 "+loginStudent+" 有效登录");
		if(loginStudent == null || !student.getStudentPwd().equals(loginStudent.getStudentPwd())){
			model.setViewName("reception/suc");
			model.addObject("success", "密码错误");
			return model;
		}
		request.getSession().setAttribute("loginStudent", loginStudent);
		
		model.setViewName("reception/suc");
		model.addObject("success", "登录成功");
		
		return model;
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/exit")
	public String studentClearLogin(HttpSession session) {
		StudentInfo studnet = (StudentInfo) session.getAttribute("loginStudent");
		logger.info("学生 "+studnet.getStudentName()+", 编号 "+studnet.getStudentId()+" 退出登录");
		session.removeAttribute("loginStudent");
		
		return "redirect:index.jsp";
	}
	
	/**
	 * 学生注册 验证当前账户是否被占用
	 * @param studentAccount 注册账户
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/validateAccount")
	public void validateRegisterAccount(@RequestParam("studentAccount") String studentAccount,
			HttpServletResponse response) throws IOException {
		logger.info("验证学生账户 "+studentAccount+"，是否已被注册");
		
		StudentInfo student = studentInfoService.getStudentByAccountAndPwd(studentAccount);
		
		if (student == null) {
			logger.error("注册学生账户 "+studentAccount+" 可以注册");
			response.getWriter().print("t");
		} else {
			logger.error("注册学生账户 "+studentAccount+" 已被注册");
			response.getWriter().print("f");
		}
	}
	
	/**
	 * 学生注册
	 * @param studentName
	 * @param studentAccount
	 * @param studentPwd
	 * @param classId
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="/studentReg", method=RequestMethod.POST)
	public void studentRegister(
			@RequestParam("name") String studentName,
			@RequestParam("account") String studentAccount,
			@RequestParam("pwd") String studentPwd,
			@RequestParam("classId") Integer classId,
			HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView();
		student.setStudentName(studentName);
		student.setStudentAccount(studentAccount);
		student.setStudentPwd(studentPwd);
		classInfo.setClassId(classId);
		student.setClassInfo(classInfo);
		logger.info("学生注册 "+student);
		int row = studentInfoService.isAddStudent(student);
		
		response.getWriter().print("t");
	}
	
	/**
	 * 预注册
	 * @return
	 */
	@RequestMapping("/preStudentReg")
	public ModelAndView preStudentReg() {
		ModelAndView model = new ModelAndView();
		model.setViewName("reception/register");
		model.addObject("classs", classInfoService.getClasses(null));
		return model;
	}
	
	/**
	 * 学生进入考试
	 * @param classId 班级编号
	 * @param examPaperId 试卷编号
	 * @param studentId 考生编号
	 * @param examTime 考试时间
	 * @param beginTime 考试开始时间
	 * @param gradeId 年级编号
	 * @param session
	 * @return
	 */
	@RequestMapping("/begin")
	public ModelAndView beginExam(
			@RequestParam("classId") Integer classId,
			@RequestParam("examPaperId") Integer examPaperId,
			@RequestParam(value="studentId", required=false) Integer studentId,
			@RequestParam("examTime") Integer examTime,
			@RequestParam("beginTime") String beginTime,
			@RequestParam("gradeId") Integer gradeId,
			HttpSession session) {
		ModelAndView model = new ModelAndView();
		
		/*
		 * 查询该考试当前进入的试卷是否已经在历史记录中存在
		 * 如果存在，则不能再次进入考试； 反之进入考试
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentId", studentId);
		map.put("examPaperId", examPaperId);
		int count = examHistoryPaperService.getHistoryInfoWithIds(map);
		if(session.getAttribute("loginStudent") == null) {
			model.addObject("error", "请先登录后再操作");
			model.setViewName("error");
			return model;
		} else if (count >= 1) {
			model.addObject("error", "你已经考试过了");
			model.setViewName("error");
			return model;
		} else {			
			logger.info("学生 "+studentId+" 进入考试 班级 "+classId+" 试卷 "+examPaperId);
			model.setViewName("/reception/exam");
			
			ExamPaperInfo examPaper = new ExamPaperInfo();
			examPaper.setExamPaperId(examPaperId);
			esm.setExamPaper(examPaper);
			//获取试卷 试题集合
			List<ExamSubjectMiddleInfo> esms = examSubjectMiddleInfoService.getExamPaperWithSubject(esm);
			logger.info("考试试题总量 "+esms.size());
			
			//获取当前考生在当前试卷中已选答案记录
			Map<String, Object> choosedMap = new HashMap<String, Object>();
			choosedMap.put("studentId", studentId);
			choosedMap.put("examPaperId", examPaperId);
			List<ExamChooseInfo> chooses = examChooseInfoService.getChooseInfoWithSumScore(choosedMap); 
			if (chooses == null || chooses.size() == 0) {
				model.addObject("chooses", null);
			} else {
				model.addObject("chooses", chooses);				
			}
			
			
			model.addObject("esms", esms);
			model.addObject("sumSubject", esms.size());
			model.addObject("examPaperId", examPaperId);
			model.addObject("examTime", examTime);
			model.addObject("beginTime", beginTime);
			model.addObject("classId", classId);
			model.addObject("gradeId", gradeId);
			
			return model;
		}
	}
	
	
	/**
	 * 获取学生历史考试记录
	 * @param studentId 学生编号
	 * @return
	 */
	@RequestMapping("/history/{studentId}")
	public ModelAndView getExamHistoryInfo(@PathVariable("studentId") Integer studentId) {
		ModelAndView model = new ModelAndView();
		
		if (studentId == null) {
			logger.error("学生编号 为空");
			model.setViewName("error");
			return model;
		}
		logger.info("学生 "+studentId+" 获取考试历史记录");
		//获取历史考试信息记录集合
		List<ExamHistoryPaper> ehps = examHistoryPaperService.getExamHistoryToStudent(studentId);
		model.addObject("ehps", ehps);
		model.setViewName("/reception/examHistory");
		
		return model;
	}
	
	
	/**
	 * 考生提交考试
	 * @param studentId
	 * @param examPaperId
	 * @param classId
	 * @param gradeId
	 * @return
	 */
	@RequestMapping(value="/submit", method={RequestMethod.POST, RequestMethod.GET})
	public String examSubmit(
			@RequestParam("studentId") Integer studentId,
			@RequestParam("examPaperId") Integer examPaperId,
			@RequestParam("classId") Integer classId,
			@RequestParam("gradeId") Integer gradeId) {
		logger.info("学生 "+studentId+" 提交了试卷 "+examPaperId);
		
		//获取当前学生当前试卷所选择的全部答案
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentId", studentId);
		map.put("examPaperId", examPaperId);
		List<ExamChooseInfo> chooses = examChooseInfoService.getChooseInfoWithSumScore(map);
		logger.info("学生 "+studentId+" 共选择了 "+chooses.size()+" 道题");
		
		//总分记录
		int sumScore = 0;
		for (ExamChooseInfo choose : chooses) {
			SubjectInfo subject = choose.getSubject();
			String chooseResult = choose.getChooseResult();
			String rightResult = subject.getRightResult();
			
			if (chooseResult.equals(rightResult)) {	//答案正确
				sumScore += subject.getSubjectScore();
				logger.info("学生 "+studentId+" 第 "+subject.getSubjectId()+" 选择正确答案 "+chooseResult+" 当前总分 "+sumScore);
			} else {
				logger.info("学生 "+studentId+" 第 "+subject.getSubjectId()+" 答案选择错误 "+chooseResult+" 正确答案为 "+rightResult+" 当前总分 "+sumScore);				
			}
		}
		
		/*
		 * 首先判断当前记录是否已经添加过
		 * 防止当前学生点击提交后，系统倒计时再次进行提交
		 */
		int count = examHistoryPaperService.getHistoryInfoWithIds(map);
		
		if (count == 0) {
			//添加到历史记录
			map.put("examScore", sumScore);
			int row = examHistoryPaperService.isAddExamHistory(map);
			logger.info("学生 "+studentId+" 提交的试卷 "+examPaperId+" 已成功处理，并添加到历史记录中");
		}
		
		return "redirect:willexams?gradeId="+gradeId+"&classId="+classId+"&studentId="+studentId;
	}
	
	
	/**
	 * 学生回顾试卷  --  后台教师查看也调用此方法
	 * @param studentId
	 * @param examPaperId
	 * @param score
	 * @param examPaperName
	 * @param studentName  后台教师查看需传入学生姓名
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/review")
	public ModelAndView reViewExam(
			@RequestParam("studentId") Integer studentId,
			@RequestParam("examPaperId") Integer examPaperId,
			@RequestParam("score") Integer score,
			@RequestParam("examPaperName") String examPaperName,
			@RequestParam(value="studentName", required=false) String studentName) throws UnsupportedEncodingException {
		ModelAndView model = new ModelAndView();
		if (studentId == null) {
			model.addObject("error", "请先登录后再操作");
			model.setViewName("error");
			return model;
		} else {
			//获取当前试卷的试题集合  -- 前台判断需要
			examPaper.setExamPaperId(examPaperId);
			esm.setExamPaper(examPaper);
			List<ExamSubjectMiddleInfo> esms = examSubjectMiddleInfoService.getExamPaperWithSubject(esm);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("studentId", studentId);
			map.put("examPaperId", examPaperId);
			
			//获取当前回顾试卷 试题、选择答案 信息
			List<ExamChooseInfo> reviews = examChooseInfoService.getChooseInfoWithExamSubject(map);
			logger.info("学生 "+studentId+" 回顾试卷 "+examPaperId+" 试题数量 "+reviews.size());
			//设置试卷名称、试卷总分
			model.addObject("examPaperName", examPaperName);
			model.addObject("score", score);
			
			model.setViewName("reception/review");
			model.addObject("views", reviews);
			
			model.addObject("esms", esms);
			if (studentName != null) model.addObject("studentName", studentName);
			
			model.addObject("ExamedPaper", examPaperInfoService.getExamPaper(examPaperId));
			
			return model;
		}
	}
	
	/**
	 * 学生查看自己信息
	 * @param studentId
	 * @return
	 */
	@RequestMapping("/self/{studentId}")
	public ModelAndView selfInfo(@PathVariable("studentId") Integer studentId) {
		StudentInfo stu = studentInfoService.getStudentById(studentId);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/reception/self");
		model.addObject("self", stu);
		
		
		return model;
	}
	
	
	/**
	 * 学生修改密码
	 * @param pwd
	 * @param studentId
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/reset/{pwd}/{studentId}")
	public void isResetPwd(
			@PathVariable("pwd") String pwd,
			@PathVariable("studentId") Integer studentId,
			HttpServletResponse response) throws IOException {
		logger.info("学生 "+studentId+" 修改密码");
		student.setStudentId(studentId);
		student.setStudentPwd(pwd);
		
		int row = studentInfoService.isResetPwdWithStu(student);
		
		if (row > 0) {
			response.getWriter().print("t");
		} else {
			response.getWriter().print("f");			
		}
	}
}