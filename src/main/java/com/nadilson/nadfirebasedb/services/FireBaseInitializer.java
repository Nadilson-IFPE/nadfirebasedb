package com.nadilson.nadfirebasedb.services;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.nadilson.nadfirebasedb.NadfirebasedbApplication;

@Service
public class FireBaseInitializer {

	@PostConstruct
	public void initialize() {
		try {
			ClassLoader classLoader = NadfirebasedbApplication.class.getClassLoader();

			FirebaseOptions.Builder firebaseOptionsBuilder = FirebaseOptions.builder();
			FileInputStream serviceAccount = new FileInputStream(
					classLoader.getResource("SEU_FIREBASE_ADMIN_SDK.json").getFile());

			FirebaseOptions options = firebaseOptionsBuilder
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("SUA_STRING_DE_CONEXÃO_AO_DATABASE").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
