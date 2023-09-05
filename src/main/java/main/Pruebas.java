package main;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TbTipo;
import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println("===JPA CRUD====");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase0");
		EntityManager em = fabrica.createEntityManager();
		
		List<TbUsuario> lstUsuarios = em.createQuery("Select a From TbUsuario a", TbUsuario.class).getResultList();
		System.out.println("==============================================");
		
		/*Mostrar cantidad de usuarios*/
		System.out.println("nro de usuarios:" +lstUsuarios.size());
		System.out.println("==============================================");
		
		
		/*Búsqueda de usuario con id=2*/
		System.out.println("Buscar usuario con id=5");
		System.out.println("-----------------------");
		TbUsuario us = em.find(TbUsuario.class,5);
		System.out.println(us);
		System.out.println(us.getCodUsua());
		System.out.println(us.getNomUsua());
		System.out.println(us.getApeUsua());
		System.out.println("==============================================");
		//insertar
		System.out.println("Insertar nuevo usuario: Pepe Perez, de Tipo = 2 (cliente) y cla_usua=1001");
		System.out.println("-------------------------------------------------------------------------");
		
		
		
		em.getTransaction().begin();
	TbUsuario usuario = new TbUsuario();
		Date fecha = new Date();
		TbTipo tipo = em.find(TbTipo.class, 2);//Tipo Cliente: Buscar en la tabla TbTipo
		usuario.setCodUsua(6);
		usuario.setNomUsua("FERNANDO JOSE");
		usuario.setApeUsua("MORAN");
		usuario.setUsrUsua("mnn");
		usuario.setFnaUsua(fecha);
		usuario.setTbTipo(tipo);
		usuario.setEstUsua(1);
		em.persist(usuario);
		em.getTransaction().commit();
		System.out.println("==============================================");
		
		
	}

}
