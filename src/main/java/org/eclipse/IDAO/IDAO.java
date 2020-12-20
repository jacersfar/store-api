package org.eclipse.IDAO;

import java.util.List;

public interface IDAO<T> {
	public T findById(long id);
	public List<T> find();
	public T add(T object);
	public T delete(T object);
	public T update(T object);
}
