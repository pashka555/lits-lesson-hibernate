package hibernate.university;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student first = new Student();
        first.setId(1);
        first.setFirstName("Pavlo");

        Book boring = new Book();
        boring.setName("About MCUs");

        Book lessBoring = new Book();
        lessBoring.setName("ALL ALL ALL About Java");

        first.setBook(Arrays.asList(boring));



        Student second = new Student();

        second.setBook(Arrays.asList(boring,lessBoring));

        second.setFirstName("Bodyo");

        StudentDao sdao = new StudentDao();

        sdao.saveStudent(first);
        //StudentDao.saveStudent(second);

        //StudentDao.updateStudent(2,"Bogdan");

        //StudentDao.deleteStudent(1);
    }
}
