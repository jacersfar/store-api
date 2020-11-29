package org.eclipse.IDAO;

import java.util.List;

public interface IDAO<T> {
	public T findById(long id);
	public List<T> find();
	public void add(T object);
	public void delete(T object);
	public void update(T object);
}
