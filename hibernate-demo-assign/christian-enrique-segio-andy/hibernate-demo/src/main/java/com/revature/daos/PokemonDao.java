package com.revature.daos;

import java.util.List;

import com.revature.models.Pokemon;

public interface PokemonDao {

	Pokemon add(Pokemon t);
	Pokemon getById(int id);
	List<Pokemon> getAll();
	void update(Pokemon t);
	void delete(Pokemon t);
}
