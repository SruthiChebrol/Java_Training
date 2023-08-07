package com.example.user.management.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
@Component
public class IdGenerator {

	private AtomicLong currentId;

	public AtomicLong getCurrentId() {
		return currentId;
	}

	public void setCurrentId(AtomicLong currentId) {
		this.currentId = currentId;
	}

	public IdGenerator() {
		this.currentId = new AtomicLong(getLastStoredId());
	}
	 public long generateId() {
	        return currentId.incrementAndGet();
	    }

	 private long getLastStoredId() {
	        try {
	            File file = new File("data/id.txt");
	            if (!file.exists()) {
	                file.createNewFile();
	                return 0L;
	            }

	            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	                String lastIdStr = reader.readLine();
	                if (lastIdStr != null && !lastIdStr.isEmpty()) {
	                    return Long.parseLong(lastIdStr);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return 0L;
	    }

	    // method the StoreLastId
	    public void storeLastId() {
	        try {
	            File file = new File("data/id.txt");
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	                writer.write(String.valueOf(currentId.get()));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	}
