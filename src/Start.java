import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management App");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to DELETE Student");
            System.out.println("Press 3 to DISPLAY Student");
            System.out.println("Press 4 to EXIT App");

            int choice = Integer.parseInt(br.readLine());

            if (choice==1){
                //add student
                System.out.println("Enter Student Name:");
                String name = br.readLine();

                System.out.println("Enter Student Phone:");
                String phone = br.readLine();

                System.out.println("Enter Student City:");
                String city = br.readLine();

                //creating Student object to store student
                Student st = new Student(name, phone, city);

                boolean flag = StudentDao.insertIntoDB(st);

                if (flag) System.out.println("Successfully added:");
                else System.out.println("Failed to add:");
                System.out.println(st);



            } else if (choice==2) {
                //delete student
                System.out.println("Enter Student ID to delete:");
                int studentId = Integer.parseInt(br.readLine());

                boolean flag = StudentDao.deleteStudent(studentId);

                if (flag) System.out.println("Successfully deleted.");
                else System.out.println("Failed to delete!");

            } else if (choice==3) {
                //display student
                StudentDao.showAllStudents();

            } else if (choice==4){
                //exit
                break;
            } else {
                continue;
            }
        }

        System.out.println("Thank You for using this application");

    }
}
