package com.ps.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ps.dao.DaoException;

@Aspect
@Component
public class MyCustomAspect {
	
	@Around("execution( * com.ps.dao.ProductDao.get*(Double, Double))")
	public Object checkAndSwapInputs(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		Double min = (Double) args[0];
		Double max = (Double) args[1];
		if(min>max) {
			args = new Object[] {max, min};
		}
		// now going to the target function
		Object obj = pjp.proceed(args);
		// came back from the target function
		
		return obj;
	}

	@AfterThrowing(value = "execution(* com.ps..*Dao.*(..))", throwing = "ex")
	public void exceptionConverter(Exception ex) throws Throwable {
		throw new DaoException(ex);
	}

}
