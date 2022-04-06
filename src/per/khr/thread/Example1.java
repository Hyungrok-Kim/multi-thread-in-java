package per.khr.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example1 {

	private ExecutorService executorService = null;

	public Example1() {
		this.executorService = Executors.newCachedThreadPool();
//		this.executorService = Executors.newFixedThreadPool(100);
//		this.executorService = Executors.newSingleThreadExecutor();
	}
	
	public void runTask() {
		Future future = executorService.submit(new Task()); // 물론 Future 객체로 스레드 결과를 받을 지 말 지는 본인 자유...
		
		try {
			System.out.println(future.get()); // future.get() 또는 future.isDone()을 쓰게 되면 Thread lock이 걸려버려 사실상 비동기 작업을 수행하지 않음
			System.out.println(future.isDone()); // 스레드가 정상적으로 종료되었는지 return 
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class Task implements Callable<Object> {

		@Override
		public Object call() throws Exception {
			System.out.println("넌 이름이 뭐니 : " + Thread.currentThread().getName());
			
			return null;
		}
		
	}
	
}

