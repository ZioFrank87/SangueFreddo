package it.majorbit.util;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

	private static UserStorage userStorage;
	private Set <String> users;

	private UserStorage() {
		users= new HashSet<String>();

	}

	public static UserStorage getInstance() {
		if (userStorage == null) {
			userStorage = new UserStorage();
		}

		return userStorage;
	}

	public Set<String> getUsers() {
		return users;
	}

	public void setUsers(String username) throws Exception {
		if (users.contains(username)) {
			throw new Exception ("Username già in uso");
		}
		users.add(username);
	}


	
	
	

}
