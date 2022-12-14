package ar.mil.cideso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import ar.mil.cideso.modelo.Groups;
import ar.mil.cideso.servicio.AdminService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class GroupController {

	@Autowired
	AdminService adminService;

	@GetMapping("/group/{group_id}")
	public ResponseEntity<Groups> getGroup(
		@PathVariable(value = "group_id") Long groupId,
		@RequestHeader Map<String, String> headers
	) {
		String token = headers.get("authorization");
		try {
			Groups group = adminService.findGroup(groupId, token);
			return new ResponseEntity<Groups>(group, HttpStatus.OK);
		} catch(IOException e) {
			return new ResponseEntity<Groups>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/groups")
	public ResponseEntity<List<Groups>> getGroups(
		@RequestHeader Map<String, String> headers
	) {
		try {
			String token = headers.get("authorization");
			List<Groups> groups = adminService.getGroups(token);
			return new ResponseEntity<List<Groups>>(groups, HttpStatus.OK);
		} catch(IOException e) {
			return new ResponseEntity<List<Groups>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/group")
	public ResponseEntity<Groups> createLocation(
			@RequestBody Groups group,
			@RequestHeader Map<String, String> headers
	) {
		try {
			String token = headers.get("authorization");
			Long id = adminService.createGroup(group.getName(), token);
			group.setId(id);
			return new ResponseEntity<Groups>(group, HttpStatus.OK);
		} catch(IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Groups>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

