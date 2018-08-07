package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WritingAspect {
	
	/*
	 * 접근 지정자 : public
	 * 리턴 type  : void
	 * 메소드명    : write 로 시작하는 메소드
	 * 메소드에 전달되는 인자 : 없음.
	 * 
	 * 위와 같은 모양의 메소드가 실행되기 이전에 적용되는 Advice
	 */
	@Before("execution(public void write*())")
	public void preparePen() {
		System.out.println("[ 글을 쓰기 위해 펜을 준비해요 ]");
	}
	
	/*
	 *	접근 지정자 : 없음
	 *  리턴 type  : 상관없음
	 *  메소드명     : write 로 시작
	 *  메소드에 전달되는 인자 : 없음
	 *  
	 *  위와 같은 메소드가 실행된 이후에 적용되는 Advice
	 */
	@After("execution(* write*())")
	public void endPen() {
		System.out.println("[ 글을 다 작성하고 펜을 닫아요 ]");
	}
	
	@Around("execution(* write*(java.lang.String))")
	public void aroundWrite(ProceedingJoinPoint joinPoint) throws Throwable{
		// point cut 이전에 실행될 작업
		System.out.println("[ 준비 작업을 해요 ]");
		
		// aop 가 적용된 메소드에 전달된 인자를 Object[] 로 얻어내기
		Object[] args = joinPoint.getArgs();
		
		for (Object e : joinPoint.getArgs()) {
			// 만일 우리가 찾는 type 이면 (이 예제에서는 String type)
			if(e == null) {
				e = "정태희";
			} else if(e instanceof String) {
				// 원하는 작업을 한다
				System.out.println("aop 에서 미리 조사함");
				System.out.println("전달된 name: " + e);
			} 
		}
		
		// aop 가 적용된 메소드 수행하기
		Object result = joinPoint.proceed();
		
		// point cut 이후에 실행될 작업
		System.out.println("[ 마무리 작업을 해요 ]");
	}
	
	@Around("execution(String write*(int))")
	public Object aroundWrite2(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		int num = (int)args[0];
		
		// 전달된 인자가 1개이고 type 이 정수 인게 확실하기 때문에...
		System.out.println("인자로 전달된 숫자: " + num);
		
		// AOP 가 적용된 메소드를 호출하고 그 메소드가 리턴해주는 객체를 Object type 으로 받기
		Object obj = joinPoint.proceed();

		String result = (String)obj;
		System.out.println("리턴된 문자열: " + result);
		
		// 원한다면 다른 정보를 리턴해 줄수도 있다.
		result = "에이콘";
		
		return result;
	}
}
