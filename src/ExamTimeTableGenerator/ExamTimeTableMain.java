package ExamTimeTableGenerator;

import java.util.Scanner;

public class ExamTimeTableMain {
    public static void main(String[] args) {
        ExamTimeTableGenerator timeTableGenerator = new ExamTimeTableGenerator();

        Exam exam1 = new Exam("Java", "2024-02-10", "09:00 AM", "Room 101", "Mr.Vanda", 2, "Monday");
        Exam exam2 = new Exam("C Sharp", "2024-02-12", "10:30 AM", "Room 201", "Mr.Dara", 3, "Wednesday");
        Exam exam3 = new Exam("Statistics Analysis", "2024-02-15", "02:00 PM", "Room 301", "Mr.Vanna", 1, "Friday");

        timeTableGenerator.addExam(exam1);
        timeTableGenerator.addExam(exam2);
        timeTableGenerator.addExam(exam3);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------- Exam Time Table Generator Menu-------");
            System.out.println("1. Add New Exam");
            System.out.println("2. Remove Exam");
            System.out.println("3. Generate Time Table");
            System.out.println("4. Quit");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    timeTableGenerator.insertNewExam();
                    break;

                case 2:
                    System.out.print("Enter the subject of the exam to remove:");
                    String subject = scanner.nextLine();
                    boolean examRemoved = false;
                    for (Exam exam : timeTableGenerator.exams) {
                        if (exam.getSubject().equalsIgnoreCase(subject)) {
                            timeTableGenerator.removeExam(exam);
                            System.out.println("Exam removed successfully!");
                            examRemoved = true;
                            break;
                        }
                    }
                    if (!examRemoved) {
                        System.out.println("Exam not found in the timetable.");
                    }
                    break;
                case 3:
                    timeTableGenerator.generateTimeTable();
                    break;
                case 4:
                    System.out.println("Thank you for using the Exam Time Table Generator!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
            System.out.println();
        } while (choice != 4);
    }
}