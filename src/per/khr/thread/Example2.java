package per.khr.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Example2 {
	
//	------------------------------------------------------------
//	ThreadPoolExecutor 생성자에는 뭐가 있는 지 알아보자...
	
//	1. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue workQueue)
//	2. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue workQueue, RejectedExecutionHandler handler)
//	3. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue workQueue, ThreadFactory threadFactory)
//	4. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
//	등이 있다...
//	기본적으로 corePoolSize는 쓰레드 풀의 기본 사이즈로 몇 개의 스레드를 풀에 가지고 있을 것인지에...관한 값이라고 생각하면 되시고
//	maximumPoolSize는 쓰레드 풀이 가질 수 있는 최대한의 스레드 갯수라고 생각하면 될 것이다.. 참고로 max size를 넘어서면 RejectedExecutionException이 발생한다..
//	keepAliveTime은 스레드가 얼마나 유지될 것 인지에 관한 것이고...
//	timuUnit은 TimeUnit.SECONDS 이런 식으로 keepAliveTime에 관한 시간 단위이고...
//	workQueue는 corePoolSize를 넘어서는 스레드를 queueing 처리하기 위해 사용 된다...
	
	
//	------------------------------------------------------------
	BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(1);
	ThreadPoolExecutor tpe = new ThreadPoolExecutor(100, 150, 100, TimeUnit.SECONDS, blockingQueue);
	
	Example2() {}
	
//	(1)
	public void runTask() {
		tpe.execute(() -> {
	         System.out.println("현재 쓰레드는 ..." + Thread.currentThread().getName());
	    });
	}
	
//	(2)
	public void runTask2() {
		Runnable runTask = new Task();
		
		for(int i = 0; i < 100; i++) {
			tpe.execute(runTask);
		}
		
	}
	
//	(2-1)
	class Task implements Runnable {
		@Override
		public void run() {
			for(int i = 0; i < 5; i++) {
				System.out.println("현재 스레드는 ..." + Thread.currentThread().getName());
			}
		}
	}
}
