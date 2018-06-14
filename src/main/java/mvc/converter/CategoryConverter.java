package mvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import mvc.dao.CategoryDao;
import mvc.entity.Category;

public class CategoryConverter implements Converter<String, Category> {

	@Autowired
	CategoryDao categoryDao;
	
	public Category convert(String arg0) {
		Category category = categoryDao.readCategory(Integer.parseInt(arg0));
		return category;
	}

}
