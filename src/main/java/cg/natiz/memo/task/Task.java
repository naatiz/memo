package cg.natiz.memo.task;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @author natiz
 * 
 * @param <T1>
 *            provided data type
 * @param <T2>
 *            processed data type
 */
@SuppressWarnings("serial")
public class Task<T1 extends Serializable, T2 extends Serializable> implements
		Serializable {
	/**
	 * Tasklet list 
	 */
	//private BlockingQueue<Tasklet<T1, T2>> tasklets = new ArrayBlockingQueue<Tasklet<T1, T2>>(20);
	private List<Tasklet<T1, T2>> tasklets = new CopyOnWriteArrayList<Tasklet<T1, T2>>();

	/**
	 * Execute the list of tasklets 
	 * 
	 * @throws Exception
	 *             generic exception if the execution fails
	 */
	public void execute() throws Exception {
		for(Tasklet<T1, T2> tasklet: tasklets){
			tasklet.execute();
		}
	}

	public Task<T1, T2> add(Tasklet<T1, T2> tasklet) {
		this.tasklets.add(tasklet);
		return this;
	}

	public Task<T1, T2> addAll(List<Tasklet<T1, T2>> tasklets) {
		this.tasklets.addAll(tasklets);
		return this;
	}
}
