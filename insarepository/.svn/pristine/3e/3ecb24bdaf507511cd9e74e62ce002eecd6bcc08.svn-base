package kr.co.insaPrj5.common.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommonAdvice {
	
	@Around("execution(* kr.co.insaPrj5..sf.*.*(..)) or execution(* kr.co.insaPrj5..applicationService.*.*(..)) or execution(* kr.co.insaPrj5..dao.*.*(..))")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		if (log.isDebugEnabled()) {
			log.debug(className + "." + methodName + "() 시작");
		}
		Object[] args = joinPoint.getArgs();
		if ((args != null) && (args.length > 0)) {
			for (int i = 0; i < args.length; i++) {
				log.debug("Argument[" + i + "] : " + args[i]);
			}
		}

		Object retVal = joinPoint.proceed();
		if (log.isDebugEnabled()) {
			log.debug(className + "." + methodName + "() 종료");
		}
		return retVal;
	}

	@AfterThrowing ("execution(* kr.co.insaPrj5..sf.*.*(..))")
	public void afterThrowing(DataAccessException ex) throws Throwable {
		if (log.isDebugEnabled()) {
			log.debug("Caught : " + ex.getClass().getName());
		}
		if (log.isErrorEnabled()) {
			log.warn(ex.getMessage());
		}
		throw ex;
	}
}