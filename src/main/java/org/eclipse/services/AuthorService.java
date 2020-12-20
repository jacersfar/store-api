package org.eclipse.services;

import java.util.List;

import javax.transaction.Transactional;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements IService<Author>{
	@Autowired
	private IDAO<Author> authorDAO;

	@Override
	@Transactional
	public List<Author> find() {
		return this.authorDAO.find();
	}
	@Override
	@Transactional
	public Author findById(long id) {
		return this.authorDAO.findById(id);
	}
	@Override
	@Transactional
	public Author add(Author object) {
		return this.authorDAO.add(object);
	}
	@Override
	@Transactional
	public Author update(Author object) {
		return this.authorDAO.update(object);
	}
	@Override
	@Transactional
	public Author delete(Author object) {
		return this.authorDAO.delete(object);
	}
}
