
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {
    private static SessionFactory sessionFactory = null;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // Tutor tutor = new Tutor("123ASD", "Per", 32000);
        // Student stud1 = new Student("Kim");
        // Student stud2 = new Student("Dim");
        // Student stud3 = new Student("Pim");
        // session.save(stud1);
        // session.save(stud2);
        // session.save(stud3);
        // session.save(tutor);
        // tutor.addStudentToTeachingGroup(stud1);
        // tutor.addStudentToTeachingGroup(stud2);
        // tutor.addStudentToTeachingGroup(stud3);

        //Hämta lärare med id 99 (i min databas)
        Tutor tutor = (Tutor) session.get(Tutor.class, 99);

        //Skriv ut alla elever han undervisar
        for (Student student : tutor.getTeachingGroup()) {
            System.out.println(student);
        }


        tx.commit();
        session.close();

    }

}
