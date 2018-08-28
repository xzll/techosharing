package controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor{

	/**
	 * 在进入Handler方法执行之前执行本方法
	 * 
	 * @return true:执行下一个拦截器，直到所有拦截器都执行完，再执行被拦截的Controller
	 *         false:从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		if(request.getSession().getAttribute("user")!=null) {
			return true;
		}
		// 针对ajax 请求处理
		if(request.getHeader("x-requested-with") != null) {
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			response.setHeader("url", basePath+"/login/sessionTimeout");
		} else {
			request.getRequestDispatcher("/login/sessionTimeout").forward(request, response);
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

}
