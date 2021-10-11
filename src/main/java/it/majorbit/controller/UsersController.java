package it.majorbit.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.majorbit.util.UserStorage;

@RestController
@CrossOrigin
public class UsersController {
	@GetMapping("/registration/{username}")
	public ResponseEntity<Object> register(@PathVariable String username) {
		System.out.println("Richiesta di registrazione dell' utente: " + username);

		try {
			UserStorage.getInstance().setUsers(username);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}

		return ResponseEntity.status(HttpStatus.OK).body("Utente registrato con successo");
	}

	@GetMapping("/fetchAllUsers")
	public ResponseEntity<Set<String>> fetchAll() {
		return ResponseEntity.status(HttpStatus.OK).body(UserStorage.getInstance().getUsers());
	}
}
