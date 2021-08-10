package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Pokemon;
import com.revature.util.HibernateUtil;

public class PokemonHibernate implements PokemonDao {

	@Override
	public Pokemon add(Pokemon p) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.persist(p);
			tx.commit();
		}
		return p;
	}

	@Override
	public Pokemon getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pokemon> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Pokemon t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pokemon t) {
		// TODO Auto-generated method stub
		
	}

}
