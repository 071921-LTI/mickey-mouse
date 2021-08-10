package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.util.HibernateUtil;

public class PokemonHibernate implements PokemonDao {

	@Override
	public Pokemon add(Pokemon p) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		}
		return p;
	}

	@Override
	public Pokemon getById(int id) {
		Pokemon p = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			p = s.get(Pokemon.class, id);
		}
		return p;
	}

	@Override
	public List<Pokemon> getAll() {
		List<Pokemon> pokemons = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			// Use the classname that been mapped, not the table name
			pokemons = s.createQuery("FROM Trainer", Pokemon.class).list();
		}
		return pokemons;
	}

	@Override
	public void update(Pokemon p) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(p);
			tx.commit();
		}
		
	}

	@Override
	public void delete(Pokemon p) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(p);
			tx.commit();
		}			
	}
	
}
