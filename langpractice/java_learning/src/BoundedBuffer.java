
public class BoundedBuffer {
	private Object lock = new Object();
	/** lock to protect key location */
	private Object emptyLock = new Object();
	/** notifying whether the thread is empty */
	
	final Object[] items = new Object[100];
	int putptr, takeptr, count;
	
	public void put(Object x) throws InterruptedException {
		synchronized (lock) {
			while (count == items.length)
				lock.wait();
				/** wait for the thread, take to fetch the data */
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			synchronized (emptyLock) {
				/** wait if is empty */
				emptyLock.notify();
				/** notify the take thread */
			}
		}
	}
	
	public Object take() throws InterruptedException {
		synchronized (lock) {
			while (count == 0) {
				emptyLock.wait();
			}
		}
		Object x = items[takeptr];
		if (++takeptr == items.length)
			takeptr = 0;
		--count;
		lock.notify();
		/** notify the put thread */
		return x;
	}
}
