package com.jdj.restjava.conexao;

import java.io.IOException;

import com.jdj.restjava.firebase.database.FireConn;
import com.jdj.restjava.firebase.database.dao.UsuarioDao;
import com.jdj.restjava.model.Person;
import com.jdj.restjava.model.Usuario;

public class FireTest {

	public static void main(String[] args) {

		FireConn conn = new FireConn();
		try {
			conn.test();

			Usuario usuario = new Usuario();
			usuario.setLastName("Teste1");
			usuario.setUsername("TP");
			usuario.setFirstName("Paulo");
			usuario.setEmail("paulo@gmail.com");
			usuario.setPswd("123456789");
			usuario.setCellphone("984664359");
			
			UsuarioDao dao = new UsuarioDao();
			dao.singUp(usuario);
			
			FireUser user = new FireUser();
//			user.criaUsuario(person);

//			user.Login(usuario.getEmail());

			FireData fireData = new FireData();

//			fireData.getUpdate();

//			fireData.savePerson(usuario);

//			fireData.updatePerson(person);

//			fireData.pushPersonComment();

		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
