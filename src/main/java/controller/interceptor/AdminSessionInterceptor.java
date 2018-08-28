package controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminSessionInterceptor implements HandlerInterceptor{

	/**
	 * �ڽ���Handler����ִ��֮ǰִ�б�����
	 * 
	 * @return true:ִ����һ����������ֱ��������������ִ���꣬��ִ�б����ص�Controller
	 *         false:�ӵ�ǰ������������ִ��������������afterCompletion(),���˳���������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		if(request.getSession().getAttribute("admin")!=null) {
			return true;
		}
		// ���ajax ������
		if(request.getHeader("x-requested-with") != null) {
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			response.setHeader("url", basePath+"/admin/login");
		} else {
			request.getRequestDispatcher("/admin/login").forward(request, response);
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO �Զ����ɵķ������
		
	}
}
