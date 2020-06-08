package ImageHoster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ImageHoster.model.Comment;

@Repository
public class CommentRespository {

	// Get an instance of EntityManagerFactory from persistence unit with name as
	// 'imageHoster'
	@PersistenceUnit(unitName = "imageHoster")
	private EntityManagerFactory emf;

	/**
	 * @param comment
	 * @return comment
	 * below method interacts with the database adds the new comment
	 * to the database and if their comes an error the transaction is rolled
	 * back and code breaks with the exception else after successful commit it return to the service
	 */
	public Comment addComment(Comment comment) {
		// TODO Auto-generated method stub

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			em.persist(comment);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		return comment;

	}

}
