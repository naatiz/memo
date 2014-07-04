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
@SuppressWarnings("serial")
public class Tasklet<T1 extends Serializable, T2 extends Serializable> implements
		Serializable {

	/**
	 * Provide the input U type data
	 */
	private Provider<T1> provider;

	/**
	 * Consumer the output V type data processed by the transformer
	 */
	private Consumer<T2> consumer;

	/**
	 * Transform the input U type data to output V type data
	 */
	private Transformer<T1, T2> transformer;

	/**
	 * Execute the task by allowing the consumer to get access to processed
	 * 
	 * @throws Exception
	 *             generic exception if the execution fails
	 */
	public void execute() throws Exception {
		if (provider == null) {
			StringBuilder sb = new StringBuilder("DeliveryOfficer or Transformer");
			sb.append(" or Consumer object not found");
			throw new IllegalStateException(sb.toString());
		}
		consumer.consume(transformer.transform(provider.provide()));
	}

	public Tasklet<T1, T2> addTranformer(final Transformer<T1, T2> transformer) {
		this.transformer = transformer;
		return this;
	}

	public Tasklet<T1, T2> addProvider(final Provider<T1> provider) {
		this.provider = provider;
		return this;
	}

	public Tasklet<T1, T2> addConsumer(final Consumer<T2> consumer) {
		this.consumer = consumer;
		return this;
	}
}
