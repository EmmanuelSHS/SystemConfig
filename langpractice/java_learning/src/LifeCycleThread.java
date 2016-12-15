/** 
 *  start manually
 *  start -> run -lock-> (successful) continue / (failed) blocked
 *  -wait-> wait status -notify()-> end wait -line13-> release lock
 *  -line14-> end run, return automatically 
 *  
 *  run() is not necessarily inside the this given thread
 */

public class LifeCycleThread extends Thread {
	private Object lock;
	public void run() {
		synchronized (lock) {
			/** continue other calculation */
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		LifeCycleThread t = new LifeCycleThread();
		t.start();
	}

}
