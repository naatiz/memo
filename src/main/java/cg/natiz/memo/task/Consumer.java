package cg.natiz.memo.task;

import java.io.Serializable;
/**
 * 
 * @author natiz
 *
 * @param <T> data to be consumed
 */
public interface Consumer<T extends Serializable> extends Serializable {	
	
	/**
	 * Consume data which may be processed if needed
	 * @param data data to be consumed
	 * @throws Exception generic exception if the execution fails
	 */
	public void consume(final T data) throws Exception;
}
