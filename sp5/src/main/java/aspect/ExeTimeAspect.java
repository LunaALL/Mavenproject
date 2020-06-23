package aspect;



import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect {
	
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint jp) throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = jp.proceed();
			return result;
		}finally {
			long finish=System.nanoTime();
			Signature sig =jp.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
					jp.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(jp.getArgs()),
					(finish - start));
		}
		
	}

}
