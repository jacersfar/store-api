package org.eclipse.services;

import java.util.List;

public interface IService <T> {
	public List<T> find();
	public T findById(long id);
	public T add (T object);
	public T update(T object);
	public T delete(T object);
}
