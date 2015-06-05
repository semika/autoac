/**
 * 
 */
package com.semika.autoac.web.interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Semika Siriwardana
 *
 */
public class ExceptionFlowInterceptor implements Interceptor{

	private static final long serialVersionUID = -8977185678472311516L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = null;
		try{
			 result = invocation.invoke();
		} catch(Exception e) {
			e.printStackTrace();
			ValueStack vs = invocation.getStack();
			if (e.getMessage() == null) {
				vs.setValue("errorMessage", "Internal system faliure.Please contact system administrator.");
			} else {
				vs.setValue("errorMessage", e.getMessage());
			}
			vs.setValue("status", "fail");
			result = "json";
		}
		
		return result;
	}

}
