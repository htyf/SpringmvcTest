package zyf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截所有请求
 * @author yanfangzhang
 *
 */
public class FirstInterceptor implements HandlerInterceptor{

	/**
	 * 使用时机：在处理请求之前
	 * 应用场景：可以在该方法中放入一些初始化的操作，比如权限验证，日志管理等
	 * 注意：该方法的返回值是boolean类型，若返回值为true，则继续调用后面的拦截器和目标方法，
	 * 若返回为false，则不会调用后面的拦截器和目标方法，表示请求结束
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("Interceptor:preHandle");
		return true;
	}
	/**
	 * 使用时机：在调用目标方法之后，渲染视图之前被调用。具体来说，是在调用了Controller中定义的方法之后，但在DispatcherServlet 处理视图返回渲染结果之前被调用。
	 * 应用场景：根据使用的时机就可以知道，该方法可以对Controller处理之后ModelAndView进行操作
	 * 当有多个interceptor的时候，对于preHandler的调用顺序和postHandler的调用顺序是恰恰相反的。
	 * 举例来说，现在有一个FirstInterceptor和一个SecondInterceptor，单独调用FirstInterceptor的三个方法的顺序为：
	 * FirstInterceptor.preHandle->HandlerAdapter.handle->
	 * FirstInterceptor.postHanle->DispatcherServlet.render
	 * ->FirstInterceptor.afterCompletion。
	 * 对于两个interceptor的调用顺序大致如下：
	 * 可以总结出preHandler是先进先执行，而postHandler是先进后执行
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("Interceptor:postHandle");

	}
	/**
	 * 使用时机：渲染视图之后
	 * 应用场景：释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
		System.out.println("Interceptor:afterCompletion");

	}

}
