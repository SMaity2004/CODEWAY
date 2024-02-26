import java.util.ArrayList;
import java.util.List;
import java.util.*;
class Course 
{
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    public Course(String code, String title, String description, int capacity, String schedule) 
    {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() 
    {
        return code;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getDescription() 
    {
        return description;
    }

    public int getCapacity() 
    {
        return capacity;
    }

    public String getSchedule() 
    {
        return schedule;
    }
}

class Student 
{
    private int id;
    private String name;
    private List<Course> courses;
    public Student(int id, String name) 
    {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public List<Course> getCourses() 
    {
        return courses;
    }

    public void registerCourse(Course course) 
    {
        courses.add(course);
    }

    public void dropCourse(Course course) 
    {
        courses.remove(course);
    }
}

public class CourseManagementSystem 
{
    private List<Course> courses;
    private List<Student> students;

    public CourseManagementSystem() 
    {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) 
    {
        courses.add(course);
    }

    public void addStudent(Student student) 
    {
        students.add(student);
    }

    public void displayAvailableCourses() 
    {
        System.out.println("Available Courses:");
        for (Course course : courses) 
        {
            int availableSlots = course.getCapacity() - getRegisteredStudentsCount(course);
            if (availableSlots > 0) 
            {
                System.out.println(course.getCode() + " - " + course.getTitle() + ": " + course.getDescription() + " [Timings: " + course.getSchedule() + "]" + " (Available Slots: " + availableSlots + ")");               
            } 
            else 
            {
                System.out.println(course.getCode() + " - " + course.getTitle() + ": " + course.getDescription() + " [Timings: " + course.getSchedule() + "]" + "(Course Full)");
            }
        }
    }

    public void registerStudentForCourse(Student student, Course course) 
    {
        int availableSlots = course.getCapacity() - getRegisteredStudentsCount(course);
        if (availableSlots > 0) 
        {
            student.registerCourse(course);
            System.out.println(student.getName() + " registered for course: " + course.getTitle());
        } 
        else 
        {
            System.out.println("Sorry, " + course.getTitle() + " is already full. Registration failed.");
        }
    }

    public void dropCourseForStudent(Student student, Course course) 
    {
        student.dropCourse(course);
        System.out.println(student.getName() + " dropped course: " + course.getTitle());
    }

    private int getRegisteredStudentsCount(Course course) 
    {
        int count = 0;
        for (Student student : students) 
        {
            if (student.getCourses().contains(course)) 
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) 
    {
        CourseManagementSystem cms = new CourseManagementSystem();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Course Management System");
        cms.addCourse(new Course("CS101", "Java Programming", "Complete Guide on Java programming language", 30, "Monday-10:00 AM"));
        cms.addCourse(new Course("CS102", "Python Programming", "Complete Guide on Python programming language", 25, "Tuesday-10:00 AM"));
        cms.addCourse(new Course("CS103", "Machine Learning", "Complete Guide on Machine Learning", 25, "Wednesday-2:00 PM"));
        cms.addCourse(new Course("CS104", "Data Science", "Complete Guide on Data Science", 30, "Thursday-10:00 AM"));
        cms.addCourse(new Course("CS105", "Android Development", "Complete Guide on Android Development", 25, "Friday-2:00 PM"));
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. Register new student");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) 
            {
                case 1:
                    cms.displayAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the course code you want to register for: ");
                    String courseCode = sc.nextLine();
                    Student student = cms.students.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
                    Course course = cms.courses.stream().filter(c -> c.getCode().equals(courseCode)).findFirst().orElse(null);
                    if (student != null && course != null) 
                    {
                        cms.registerStudentForCourse(student, course);
                    } 
                    else 
                    {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int studentIdDrop = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the course code you want to drop: ");
                    String courseCodeDrop = sc.nextLine();
                    Student studentDrop = cms.students.stream().filter(s -> s.getId() == studentIdDrop).findFirst().orElse(null);
                    Course courseDrop = cms.courses.stream().filter(c -> c.getCode().equals(courseCodeDrop)).findFirst().orElse(null);
                    if (studentDrop != null && courseDrop != null) 
                    {
                        cms.dropCourseForStudent(studentDrop, courseDrop);
                    } 
                    else 
                    {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    cms.addStudent(new Student(id, name));
                    System.out.println(name+" has been successfully registered.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
