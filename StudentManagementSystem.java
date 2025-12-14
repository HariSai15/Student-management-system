import java.util.*;

class Person {
    protected int id;
    protected String name;

    public Person(int id, String name){
    this.id = id;
    this.name = name;
    }

    public void displayDetails() {
        System.out.println("ID - "+id);
        System.out.println("Name - "+name);
    }
}

class Student extends Person {
    private String course;
    private int age;

    public Student(int id, String name, int age, String course) {
        super(id, name);
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Course - "+course);
        System.out.println("Age - "+age);
        System.out.println("----------------------");
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do{
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting System");
                default -> System.out.println("Invalid Choice");
            }
        } while(choice !=5);
    }

    public static boolean isIdExists(int id) {
        for(Student s : students) {
            if(s.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static void addStudent() {
        System.out.println("Enter id - ");
        int id = sc.nextInt();
        sc.nextLine();

        if(isIdExists(id)) {
            System.out.println("Student id is already exists");
            return;
        }
        System.out.println("Enter Name :");
        String name = sc.nextLine();

        System.out.println("Enter Age :");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter Course :");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student Added Sucessfully");
    }

    public static void viewStudents() {
        if(students.isEmpty()) {
            System.out.println("Students data not found");
        }else {
            for(Student s: students) {
                s.displayDetails();
            }
        }
    }

    public static void updateStudent() {
        System.out.println("Enter Student id :");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student s: students) {
            if(s.getId() == id) {
                System.out.println("Enter Age :");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter course :");
                String course = sc.nextLine();

                s.setAge(age);
                s.setCourse(course);

                System.out.println("Student details updated sucessfully");
                return;
            }
        }
        System.out.println("Student id not found");
    }

    public static void deleteStudent() {
        System.out.println("Enter id :");
        int id = sc.nextInt();
        sc.nextLine();

        for(int i =0;i<students.size();i++) {
            if(students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Student details Deleted Sucessfully.");
                return;
            }
        }
        System.out.println("Student id not found");
    }
}