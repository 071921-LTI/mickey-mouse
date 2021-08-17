package com.revature;

import com.revature.daos.PokemonDao;
import com.revature.daos.PokemonHibernate;
import com.revature.daos.TrainerDao;
import com.revature.daos.TrainerHibernate;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;

public class Driver {

	static TrainerDao td = new TrainerHibernate();
	static PokemonDao pd = new PokemonHibernate();
	public static void main(String[] args) {
		
		Trainer t = new Trainer("Kevin");
		System.out.println(t);
		
		System.out.println(td.add(t));
		
		System.out.println("get: " + td.getById(1));
		
		System.out.println("getAll" + td.getAll());
		
		System.out.println("t: " + t);
		
		t.setName("Hello");
		
		td.update(t);
		
		System.out.println("get: " + td.getById(1));
		
		//td.delete(t);
		
		
		System.out.println("getAll" + td.getAll());
		
		
		Pokemon p = new Pokemon("newguy", t, 0);
		
		System.out.println(pd.add(p));
		System.out.println(pd.getById(1));
		
	}

}
