package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzn.shoppingbacken.dto.Category;
import net.kzn.shoppingbackend.dao.CategoryDAO;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Telivision");
		category.setDescription("This is the description about the telivision");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		category = new Category();

		// adding second category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is the description about the mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		category = new Category();

		// adding third category
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is the description about the laptop");
		category.setImageURL("CAT_2.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// enhanced for loop
		for(Category category:categories){
			if(category.getId() == id)return category;
		}
		return null;
	}

}
