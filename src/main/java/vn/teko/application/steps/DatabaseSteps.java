package vn.teko.application.steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import net.thucydides.core.annotations.Step;
import vn.teko.jira.Configuration;

public class DatabaseSteps {

	public EntityManagerFactory getEntityManagerFactory() {
		 Map<String, String> persistenceMap = getDataBaseProperties();
		 EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory(Configuration.getJdbcPersistenceUnit(), persistenceMap);
		return managerFactory;
	}
	// @Step
	public Object findObjectById(Class<?> classname, int id) {		
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager manager = managerFactory.createEntityManager();

		manager.getTransaction().begin();
		Object obj = manager.find(classname, id);

		manager.close();
		managerFactory.close();

		return obj;
	}

//	@Step
	public List<Object> findObjectListByIds(Class<?> classname, List<Integer> idList) {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager manager = managerFactory.createEntityManager();

		manager.getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<Object> objectList = (List<Object>) manager.unwrap(Session.class).byMultipleIds(classname)
				.multiLoad(idList);

		manager.close();
		managerFactory.close();

		return objectList;
	}

	@Step
	public void deleteObjectById(Class<?> classname, int id) {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();

		Object objectToRemove = manager.getReference(classname, id);

		if (objectToRemove != null) {
			manager.remove(objectToRemove);
			manager.getTransaction().commit();
		}
		manager.close();
		managerFactory.close();
	}

	@Step
	public void deleteObjectsByIds(Class<?> classname, List<Integer> ids) {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<Object> objectList = (List<Object>) manager.unwrap(Session.class).byMultipleIds(classname).multiLoad(ids);
//		System.out.println("Object list = " + objectList.size());
		for (Object object : objectList) {
			manager.remove(object);
		}
		manager.getTransaction().commit();

		manager.close();
		managerFactory.close();
	}

	public void update(Object object) {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager manager = managerFactory.createEntityManager();
		manager.getTransaction().begin();
		
		manager.merge(object);
		
		manager.getTransaction().commit();
		manager.close();
		managerFactory.close();
	}

	public int getMaxValueFromColumn(String entityClass) {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager em = managerFactory.createEntityManager();
		Query query = em.createQuery("SELECT MAX(entityClass.id) FROM " + entityClass + " entityClass");
		Integer maxId = (Integer) query.getSingleResult();
		System.out.println("Max id = " + maxId);
		em.close();
		managerFactory.close();
		
		return maxId;
	}

	public int getRandomBrandId() {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager em = managerFactory.createEntityManager();
        int id = (int) em.createNamedQuery("BrandModel.selectRandomId").getSingleResult();
        
        return id;
	}
	
	public int getRandomMasterCategoryId() {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager em = managerFactory.createEntityManager();
        int id = (int) em.createNamedQuery("MasterCategoryModel.selectRandomId").getSingleResult();
        
        return id;
	}	
	
	public int getRandomUnitId() {
		EntityManagerFactory managerFactory = getEntityManagerFactory();
		EntityManager em = managerFactory.createEntityManager();
        int id = (int) em.createNamedQuery("UnitModel.selectRandomId").getSingleResult();
        
        return id;
	}	
	
	public Map<String, String> getDataBaseProperties() {
		Map<String, String> persistenceMap = new HashMap<String, String>();

		persistenceMap.put("javax.persistence.jdbc.url", Configuration.getJdbcUrl());
		persistenceMap.put("javax.persistence.jdbc.user", Configuration.getJdbcUser());
		persistenceMap.put("javax.persistence.jdbc.password", Configuration.getJdbcPassword());
		persistenceMap.put("javax.persistence.jdbc.driver", Configuration.getJdbcDriver());
		persistenceMap.put("hibernate.show_sql", "false");
		persistenceMap.put("hibernate.format_sql", "true");

		return persistenceMap;
	}

}
