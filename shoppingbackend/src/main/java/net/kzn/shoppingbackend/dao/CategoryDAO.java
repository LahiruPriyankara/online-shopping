package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbacken.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
