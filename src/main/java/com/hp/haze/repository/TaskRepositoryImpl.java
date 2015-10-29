package com.hp.haze.repository;

//Repository
public class TaskRepositoryImpl implements TaskRepositoryCustom {
	/**
	@Autowired

	private EntityManager session;
	
	@Override
	public void add(Task task) {
		;

	}

	@Override
	public void edit(Task task) {
		//session.getCurrentSession().update(task);

	}

	@Override
	public void delete(int id) {
		//session.getCurrentSession().delete(getTask(id));

	}

	@Override
	public Task getTask(int id) {
		return (Task)session.getCurrentSession().get(Task.class, id);
	}

	@Override
	public List getAllTask() {
		return session.getCurrentSession().createQuery("from Task").list();
	}

	public SessionFactory getSession() {
		return session;
	}

	public void setSession(SessionFactory session) {
		this.session = session;
	}
**/ 
}
