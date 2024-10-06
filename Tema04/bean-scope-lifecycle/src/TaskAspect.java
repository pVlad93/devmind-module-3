import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TaskAspect {
    @Pointcut("execution(public void run())")
    private void runMethodPointcut() {}

    @Before("runMethodPointcut()")
    public void beforeCall(JoinPoint joinPoint) {
        System.out.println("Before running method " + joinPoint.getSignature().toShortString());
    }
}
