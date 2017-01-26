package cg.natiz.memo.task;

import java.io.Serializable;
/**
 * 
 * @author natiz
 *
 * @param <T> data to be provided
 */
public interface Provider<T extends Serializable> extends Serializable {	
	/**
	 * Provide data from any source
	 * @return data to be provided
	 * @throws Exception generic exception if the process fails
	 */
	public  T provide() throws Exception;
}
