package askconsultant.message.dao;

import static askconsultant.common.MessageHelper.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askconsultant.dao.MessageDAO;
import com.askconsultant.model.Message;

public class TestMessageDAO {
//	private EntityManagerFactory emf;
//	private EntityManager em;
//	private MessageDAO messageDAO;
//	
//	@Before 
//	public void initTestCase(){
//		emf = Persistence.createEntityManagerFactory("MessagePU");
//		em = emf.createEntityManager();
//		messageDAO = new MessageDAO();
////		messageDAO.em = em;
//	}
//	
//	@After
//	public void closeEntityManager(){
//		em.close();
//		emf.close();
//	}
//	
//	@Test
//	public void testAddMesssageAndDisplay(){
//		try{
//			em.getTransaction().begin();
//			Message message = messageDAO.addMesssage(legalSmithNow());
//			assertNotNull(message);
//			em.getTransaction().commit();
//			Message findByID = messageDAO.findByID(message.getId());
//			assertNotNull(findByID);
//			em.clear();
//		}catch (Exception e) {
//			fail("This should not have happened");
//			e.printStackTrace();
//			em.getTransaction().rollback();
//		}
//	}
//	
//	@Test public void listAllMessages(){
//		try{
//			em.getTransaction().begin();
//			messageDAO.addMesssage(legalNewUserYesterday());
//			messageDAO.addMesssage(legalSmithNow());
//			em.getTransaction().commit();
//			List<Message> listAllMessages = messageDAO.listAllMessages();
//			assertNotNull(listAllMessages);
//			em.clear();
//		}catch (Exception e) {
//			fail("This should not have happened");
//			e.printStackTrace();
//			em.getTransaction().rollback();
//		}
//	}
//	
	
	
	
}