package per.khr.thread;

public class main {

	public static void main(String[] args) {
//		-----------------------------------------------
//						example 1
//		ExecutorService를 이용한 Thread 생성
		
//		# 정적 팩토리 메소드(Static Factory Method) 
//		1. Executors.newCachedThreadPool()
//		2. Executors.newFixedThreadPool(Num n) 
//		3. Executors.newSingleThreadExecutor()
		
		Example1 ex1 = new Example1();
		for(int i = 0; i < 3; i++) {
			ex1.runTask(); // 예시로 스레드 3개 생성해보자...
		}
		
		
//		# ThreadPoolExecutor
		
//		-----------------------------------------------
		
		
		
		
		
		
	}

}
