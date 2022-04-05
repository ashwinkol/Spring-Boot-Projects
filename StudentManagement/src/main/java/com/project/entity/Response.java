package com.project.entity;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;

public class Response {
	public static ResponseEntity<?> success(Object data) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("status", "success");
		if (data != null) {
			map.put("data", data);
		}
		return ResponseEntity.ok(map);

	}

	public static ResponseEntity<?> error(Object err) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("status", "error");
		if (err != null) {
			map.put("data", err);
		}
		return ResponseEntity.ok(map);

	}
}
