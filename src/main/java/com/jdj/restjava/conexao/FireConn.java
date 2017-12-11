package com.jdj.restjava.conexao;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;

public class FireConn {

	public void test() throws IOException {
		FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
				.setDatabaseUrl("https://sisbjd-d5da6.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);

	}


}
