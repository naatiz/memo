package cg.natiz.memo.task;

import java.io.Serializable;

/**
 * 
 * @author natiz
 * 
 * @param <T1>
 *            provided data type
 * @param <T2>
 *            processed data type
 */
public interface Transformer<T1 extends Serializable, T2 extends Serializable>
		extends Serializable {

	/**
	 * Transform data to an other type data depending on specific context
	 * 
	 * @param data
	 *            data to be processed
	 * @return processed data
	 * @throws Exception
	 *             generic exception if the process fails
	 */
	public T2 transform(final T1 data) throws Exception;

}
