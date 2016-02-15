package processApp.struct.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import processApp.struct.Step;
import processApp.struct.Process;

public class Dao
{

	public boolean saveProcess(Process P)
	{
		boolean res=true;
		EntityTransaction t=null;
		try
		{
			t=em.getTransaction();
			
			t.begin();
			em.persist(P);
			t.commit();
		}
		catch(Exception ex)
		{
			t.setRollbackOnly();
			res=false;
		}
		return res;
		}

	public boolean saveStep(Step S)
	{
		boolean res=true;
		try
		{
			EntityTransaction t=em.getTransaction();
			t.begin();
			em.persist(S);
			t.commit();
		}
		catch(Exception ex)
		{
			res=false;
		}
		return res;
	}
	public boolean deleteProcess(Process P)
	{
		boolean res=true;
		EntityTransaction t=null;
		try
		{
			t=em.getTransaction();
			
			t.begin();
			em.remove(P);
			t.commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			t.setRollbackOnly();
			res=false;
		}
		return res;
	}

	public boolean deleteStep(Step S)
	{
		boolean res=true;
		try
		{
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(S);
			t.commit();
		}
		catch(Exception ex)
		{
			res=false;
		}
		return res;
	}
	public Process getProcess(int id)
	{
		return em.find(Process.class, id);
	}
	public Step getStep(int id)
	{
		return em.find(Step.class, id);
	}
	
	public Dao()
	{
		open();
	}
	public void open()
	{
		emf=Persistence.createEntityManagerFactory("processApp");
		em=emf.createEntityManager();
	}
	public void close(){
		em.close();
		emf.close();

	}

	private EntityManagerFactory emf;
	private EntityManager em;
}
