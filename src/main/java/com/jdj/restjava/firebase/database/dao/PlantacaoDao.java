package com.jdj.restjava.firebase.database.dao;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jdj.restjava.model.Plantacao;

public class PlantacaoDao {

	private final FirebaseDatabase database = FirebaseDatabase.getInstance();

	private DatabaseReference reference = database.getReference("users/user/plantacao");

	public void createPlantacao(Plantacao plantacao) {
		String uid = reference.child("user").push().getKey();
		Map<String, Object> plantacaoPost = plantacao.toMap();
		Map<String, Object> childUpdate = new HashMap<>();
		childUpdate.put("/plantacao/"+uid, plantacaoPost);
		
		reference.updateChildren(childUpdate);
	}

	public void updatePlantacao() {

	}

	public void insertDados() {

	}

}
