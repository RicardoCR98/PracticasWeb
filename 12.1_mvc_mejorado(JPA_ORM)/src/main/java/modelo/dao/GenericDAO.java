package modelo.dao;

import java.util.List;

public interface GenericDAO <T, ID>{
	public T getById(ID id);
	public List<T> getAll();
	public void create(T entity);
	public void update(T entity);
	public void delete(T entity);
	public void deleteById(ID id);
	
}
