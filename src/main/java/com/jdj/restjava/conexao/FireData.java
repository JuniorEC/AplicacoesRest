package com.jdj.restjava.conexao;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.Log;
import com.jdj.restjava.model.Person;

public class FireData {

	private final FirebaseDatabase database = FirebaseDatabase.getInstance();

	private DatabaseReference reference = database.getReference("Cliente");

	public void savePerson(Object object) {

		DatabaseReference personRef = reference.child("Person");

		Map<String, Object> pessoa = new HashMap<String, Object>();

		pessoa.put("PauloEC", object);
		pessoa.put("JuniorEC", object);

		personRef.setValue(pessoa);

		System.out.println("OK");

	}

	public void updatePerson(Person person) {

		DatabaseReference personRef = reference.child("person/teste2");

		Map<String, Object> update = new HashMap<String, Object>();
		update.put("nome", "Paulo");

		personRef.updateChildren(update);

		System.out.println("OK");

	}

	public void pushPersonComment() {

		DatabaseReference postsRef = reference.child("posts");

		DatabaseReference newPostRef = postsRef.push();

		newPostRef.setValue("JuniorEC", "Announcing COBOL, a New Programming Language");

		// We can also chain the two calls together
		postsRef.push().setValue("alanisawesome", "The Turing Machine");

		String postId = newPostRef.getKey();

		System.out.println(postId);
	}

	public void searchDatabase(String child) {
		DatabaseReference referencia = database.getReference();
		referencia.addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				String value = snapshot.getValue(String.class);
				Log.d("TAG", value);
			}

			@Override
			public void onCancelled(DatabaseError error) {
				Log.w("TAG", error.toString());

			}
		});
	}

	public void getUpdate() {
		ChildEventListener childEventListener = new ChildEventListener() {

			@Override
			public void onChildRemoved(DataSnapshot snapshot) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
				Log.d("TAG", "Pessoa adicionada: " + snapshot.getKey());
				Person personAlterada = snapshot.getValue(Person.class);
				String pessoaKey = snapshot.getKey();

			}

			//Mosyta mensagem sempre que adicionado um novo dado
			@Override
			public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
				Log.d("TAG", "Pessoa adicionada: " + snapshot.getKey());
				Person person = snapshot.getValue(Person.class);
			}

			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub

			}
		};
		reference.addChildEventListener(childEventListener);
	}

}
