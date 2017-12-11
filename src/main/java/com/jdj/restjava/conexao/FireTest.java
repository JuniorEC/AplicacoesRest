package com.jdj.restjava.conexao;

import java.io.IOException;

import com.jdj.restjava.model.Person;

public class FireTest {

	public static void main(String[] args) {

		FireConn conn = new FireConn();
		try {
			conn.test();

			Person person = new Person();

			person.setNome("João");
			person.setEmail("Joao.junior.1141@gmail.com");
			person.setPwd("1993280166Dhuly");
			person.setFone("984664359");

			FireUser user = new FireUser();
			user.criaUsuario(person);

			user.Login(person.getEmail());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
