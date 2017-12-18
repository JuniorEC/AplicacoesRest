package com.jdj.restjava.firebase.database.dao;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jdj.restjava.model.Usuario;

public class UsuarioDao {

	private final FirebaseDatabase database = FirebaseDatabase.getInstance();

	private DatabaseReference reference = database.getReference("users/user");

	public void singUp(Usuario usuario) {
		String uid = reference.child("user").push().getKey();
		Map<String, Object> usuarioPost = usuario.toMap();
		Map<String, Object> childUpdate = new HashMap<>();
		childUpdate.put("/user/"+uid, usuarioPost);
		
		reference.updateChildren(childUpdate);
		
	}

	public void singIn() {

	}

	public void createUsuarioDados() {

	}

	public void updateDados() {

	}

	public void sendConfimationMensage() {

	}

}
