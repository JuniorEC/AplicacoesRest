package com.jdj.restjava.conexao;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.tasks.Task;
import com.jdj.restjava.model.Person;

public class FireUser {

	public void Login(String email) {
		Task<UserRecord> task = FirebaseAuth.getInstance().getUserByEmail(email)
				.addOnCompleteListener(UserRecord -> {
					System.out.println("OK");
				}).addOnFailureListener(e -> {
					System.out.println("Not OK");
				});
	}

	public void criaUsuario(Person person) {

		CreateRequest request = new CreateRequest()
				.setEmail(person.getEmail())
				.setEmailVerified(false)
				.setPassword(person.getPwd())
				.setDisplayName(person.getNome())
				.setDisabled(false);

		Task<UserRecord> task = FirebaseAuth.getInstance().createUser(request)
				.addOnCompleteListener(userRecord -> {
					System.out.println("OK");
				}).addOnFailureListener(e -> {
					System.out.println("Not OK");
				});

	}

}
