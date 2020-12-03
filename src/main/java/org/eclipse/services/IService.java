package org.eclipse.services;

import java.util.List;

public interface IService <T> {
	public List<T> find();
	public T findById(long id);
	public void add (T object);
	public void update(T object);
	public void delete(T object);
}
