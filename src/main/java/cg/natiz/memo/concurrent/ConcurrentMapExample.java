package cg.natiz.memo.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;

/**
 * Concurrent Map example !
 *
 */
public class ConcurrentMapExample {

	public static void main(String[] args) throws Exception {

		ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
		map.put("foo", "bar");
		map.put("han", "solo");
		map.put("r2", "d2");
		map.put("c3", "p0");

		map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));

		String aValue = map.putIfAbsent("c3", "p1");
		System.out.println(aValue); // p0

		aValue = map.getOrDefault("hi", "there");
		System.out.println(aValue); // there

		map.replaceAll((key, value) -> "r2".equals(key) ? "d3" : value);
		System.out.println(map.get("r2")); // d3

		map.compute("foo", (key, value) -> value + value);
		System.out.println(map.get("foo")); // barbar

		map.merge("foo", "boo", (oldVal, newVal) -> newVal + " was " + oldVal);
		System.out.println(map.get("foo")); // boo was foo

		System.out.println(ForkJoinPool.getCommonPoolParallelism()); // 3

		@SuppressWarnings({ "unchecked", "rawtypes" })
		ConcurrentHashMap<String, String> hashmap = (ConcurrentHashMap) map;

		hashmap.forEach(1, (key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value,
				Thread.currentThread().getName()));
		// key: r2; value: d2; thread: main
		// key: foo; value: bar; thread: ForkJoinPool.commonPool-worker-1
		// key: han; value: solo; thread: ForkJoinPool.commonPool-worker-2
		// key: c3; value: p0; thread: main

		String result = hashmap.search(1, (key, value) -> {
			System.out.println(Thread.currentThread().getName());
			if ("foo".equals(key)) {
				return value;
			}
			return null;
		});
		System.out.println("Result: " + result);

		// ForkJoinPool.commonPool-worker-2
		// main
		// ForkJoinPool.commonPool-worker-3
		// Result: bar

		result = hashmap.searchValues(1, value -> {
			System.out.println(Thread.currentThread().getName());
			if (value.length() > 3) {
				return value;
			}
			return null;
		});

		System.out.println("Result: " + result);

		// ForkJoinPool.commonPool-worker-2
		// main
		// main
		// ForkJoinPool.commonPool-worker-1
		// Result: solo

		result = hashmap.reduce(1, (key, value) -> {
			System.out.println("Transform: " + Thread.currentThread().getName());
			return key + "=" + value;
		}, (s1, s2) -> {
			System.out.println("Reduce: " + Thread.currentThread().getName());
			return s1 + ", " + s2;
		});

		System.out.println("Result: " + result);

		// Transform: ForkJoinPool.commonPool-worker-2
		// Transform: main
		// Transform: ForkJoinPool.commonPool-worker-3
		// Reduce: ForkJoinPool.commonPool-worker-3
		// Transform: main
		// Reduce: main
		// Reduce: main
		// Result: r2=d2, c3=p0, han=solo, foo=bar
	}
}
