package com.haowei.online.exam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haowei.online.exam.po.TeacherInfo;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
  *
  * <p>Title: LoginInterceptor</p>
  * <p>Description: 登录拦截器</p>
  * @author: haowei
  * @date: 2020-12-17
  * @time: 下午3:02:43
  * @version: 1.0
  */
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = Logger.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //URL：除了登入请求外，其他的URL都进行拦截控制
        if (url.contains("/teacherlogin")){
            return true;
        }
        //获取session
        HttpSession session = request.getSession();
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("loginTeacher");
        //判断Session是否有用户数据，如果有返回true，继续向下执行
        if (teacherInfo!=null){
            return true;
        }else {
            logger.info("检测到未登录访问后台内容操作");
			//如果没有登录，跳转至登录页面
			response.sendRedirect("admin/login.jsp");
			return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


//	private Logger logger = Logger.getLogger(LoginInterceptor.class);
//
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//
//		HttpSession session = request.getSession();
//		if (session.getAttribute("loginTeacher") != null) {
//			return true;
//		} else {
//			logger.info("检测到未登录访问后台内容操作");
//			//如果没有登录，跳转至登录页面
//			response.sendRedirect("admin/login.jsp");
//			return false;
//		}
//	}
}
