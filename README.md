# Multi-Thread-In-Java
How to use multi thread in java

### Executeservice vs ThreadPoolExecutor
```
사실 둘이 차이가 있는 게 아니라 Executors 객체 내부를 살펴보면 
newFixedThreadPool 와 newSingleThreadExecutor, CachedThreadPool 도 역시 내부적으로 
new ThreadPoolExecutor()로 인스턴스를 만들고 있는 걸 확인할 수 있다.. 
차이점이라고 한다면 직접 만드느냐 java 내부적으로 특정 형식으로 쓰레드풀을 만들어주느냐의 차이? 정도가 되겠다.
```

* newFixedThreadPool - new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
* newSingleThreadExecutor - new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue());
* CachedThreadPool - new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
