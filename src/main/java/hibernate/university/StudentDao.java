package hibernate.university;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class StudentDao {

    public static void saveStudent(Student student) {
        Transaction ts = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            ts = session.getTransaction();

            session.save(student);

            ts.commit();
        } catch (Exception e) {
            if (ts != null)
                ts.rollback();
        }
    }

    public static void updateStudent(int id, String newName) {
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
    }
}
