package com.swap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swap.model.Meetup;
import com.swap.model.User;

@Transactional
@Repository(value = "MeetupDao")
public class MeetupDaoImpl implements MeetupDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Meetup findByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Meetup meetup = new Meetup();
		String hql = "from Meetup where presenter=?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, name);
			meetup = (Meetup) query.uniqueResult();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return meetup;

	}

	public void saveMeetup(Meetup meetup) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (meetup != null) {
			try {
				session.save(meetup);
				transaction.commit();
				session.close();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}
		}

	}

	public void updateMeetup(Meetup meetup) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		if (meetup != null) {
			try {
				session.update(meetup);
				transaction.commit();
				session.close();
			} catch (Exception e) {
				transaction.rollback();
				session.close();
			}
		}

	}

	public void deleteMeetupById(long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Meetup meetup = (Meetup)session.get(Meetup.class,id);
		session.delete(meetup);
		transaction.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<Meetup> findAllMeetups() {
		List<Meetup> MeetupList = new ArrayList<Meetup>();
		Session session = sessionFactory.openSession();

		MeetupList = session.createCriteria(Meetup.class).list();

		session.close();
		return MeetupList;
	}

	public Meetup findById(long id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Meetup meetup = new Meetup();
		try {
			meetup = (Meetup) session.get(Meetup.class, id);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			session.close();
		}
		return meetup;

	}

}
