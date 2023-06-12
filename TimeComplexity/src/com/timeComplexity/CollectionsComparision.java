package com.timeComplexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsComparision {
	
	private static long getMemoryUsage() {
		Runtime runTime = Runtime.getRuntime();
		return runTime.totalMemory() - runTime.freeMemory();
		
	}

	public static void main(String[] args) {
		
		List<Integer> linkedList = new LinkedList<Integer>();
		List<Integer> arrayList = new ArrayList<Integer>();
	
		
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();
		
		
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		long startTime, endTime;
		long memoryBefor, memoryAfter;
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		for(int i=0; i<100000;i++) {
			arrayList.add(i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("ArrayList Insertion Time : "+(endTime - startTime)+"ns");
		System.out.println("ArrayList memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		arrayList.get(1000);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("ArrayList getting Time : "+(endTime - startTime)+"ns");
		System.out.println("ArrayList memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		arrayList.remove(50000);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("ArrayList Deletion Time : "+(endTime - startTime)+"ns");
		System.out.println("ArrayList memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		for(int i=0; i<100000;i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("linkedList Insertion Time : "+(endTime - startTime)+"ns");
		System.out.println("linkedList memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		linkedList.get(3000);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("linkedList Getting Time : "+(endTime - startTime)+"ns");
		System.out.println("linkedList memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		linkedList.remove(50000);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("linkedList Deletion Time : "+(endTime - startTime)+"ns");
		System.out.println("linkedList memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		for(int i=0; i<100000;i++) {
			hashSet.add(i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("HashSet Insertion Time : "+(endTime - startTime)+"ns");
		System.out.println("HashSet memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		for(int i=0; i<100000;i++) {
			treeSet.add(i);
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("TreeSet Insertion Time : "+(endTime - startTime)+"ns");
		System.out.println("TreeSet memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		for(int i=0; i<100000;i++) {
			hashMap.put(i, "i");
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("HashMap Insertion Time : "+(endTime - startTime)+"ns");
		System.out.println("HashMap memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		hashMap.remove(1000);
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("HashMap Deletion Time : "+(endTime - startTime)+"ns");
		System.out.println("HashMap memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		for(int i=0; i<100000;i++) {
			treeMap.put(i, "i");
		}
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("treeMap Insertion Time : "+(endTime - startTime)+"ns");
		System.out.println("treeMap memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
		startTime = System.nanoTime();
		memoryBefor = getMemoryUsage();
		
			treeMap.remove(1000);
		
		endTime = System.nanoTime();
		memoryAfter = getMemoryUsage();
		System.out.println("=========================================");
		System.out.println("treeMap Deletion Time : "+(endTime - startTime)+"ns");
		System.out.println("treeMap memory usage : "+(memoryAfter - memoryBefor)+"bytes");
		System.out.println("=========================================");
		
	}

	

}
