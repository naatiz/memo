package cg.natiz.memo.prognosis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

@SuppressWarnings("serial")
public class Generator implements Serializable {

	private static ThreadLocalRandom randomizer;

	@PostConstruct
	public void init() {
		Generator.randomizer = ThreadLocalRandom.current();
	}

	/**
	 * Integer list which contains size randomized elements peeked from a
	 * range [0, maxNumber[
	 * 
	 * @param size
	 *            size of the list to be returned
	 * @param maxNumber
	 *            max integer number to be returned in the list 
	 * @return randomized integer list
	 */
	public List<Integer> generate(int size, int maxNumber) {
		if (size > maxNumber) {
			throw new IndexOutOfBoundsException(
					"Size argument must less than maxNumber");
		}

		int indexOf = 0;
		List<Integer> temp = new ArrayList<Integer>(maxNumber);
		while (indexOf < maxNumber) {
			temp.add(indexOf);
			indexOf++;
		}

		indexOf = 0;
		List<Integer> fraction = new ArrayList<Integer>(size);
		while (indexOf < size) {
			fraction.add(temp.remove(Generator.randomizer.nextInt(temp.size())));
			indexOf++;
		}
		return fraction;
	}
}
