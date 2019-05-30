package hibernate.university;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudent(Student student) {
        Transaction ts = null;
        HibernateUtils hu = new HibernateUtils();
        try (Session session = hu.getSessionFactory().openSession()) {
            ts = session.getTransaction();

            session.save(student);

            ts.commit();
        } catch (Exception e) {
            if (ts != null)
                ts.rollback();
        }
    }

    /*public static void updateStudent(int id, String newName) {
        Transaction ts = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            ts = session.getTransaction();

            Query q = session.createQuery("from student where id = " + id, Student.class);

            Student updatable = (Student) q.getSingleResult();

            updatable.setFirstName(newName);

            session.save(updatable);

            ts.commit();
        } catch (Exception e) {
            if (ts != null)
                ts.rollback();
        }
    }

    public static void deleteStudent(int id) {
        Transaction ts = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            ts = session.getTransaction();

            Query q = session.createQuery("from student where id = " + id, Student.class);

            Student deletable = (Student) q.getSingleResult();

            session.delete(deletable);
            //updatable.setFirstName(newName);

            //session.save(updatable);

            ts.commit();
        } catch (Exception e) {
            if (ts != null)
                ts.rollback();
        }
    }*/
}
