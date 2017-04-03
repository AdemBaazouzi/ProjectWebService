package dauphine.webServices.dao;

import java.util.List;

/**
 *
 * @author 
 */
public interface IDao<T> {
	boolean create(T o);

	boolean update(T o);

	boolean delete(T o);

	List<T> getAll();

	T getById(int id);

	List<T> getByName(String login, String pwd);
}
// 