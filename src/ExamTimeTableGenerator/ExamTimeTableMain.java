package ExamTimeTableGenerator;

import java.io.IOException;
import java.util.Scanner;

public class ExamTimeTableMain {
    public static void main(String[] args) {
        Style style = new Style();
        ExamTimeTableGenerator timeTableGenerator = new ExamTimeTableGenerator();
        Scanner scanner = new Scanner(System.in);

        int choice;

        Exam exam1 = new Exam("Java", "2024-02-10", "09:00 AM", "Room 101", "Mr.Vanda", 2, "Monday");
        Exam exam2 = new Exam("C Sharp", "2024-02-12", "10:30 AM", "Room 201", "Mr.Dara", 3, "Wednesday");
        Exam exam3 = new Exam("Statistics Analysis", "2024-02-15", "02:00 PM", "Room 301", "Mr.Vanna", 1, "Friday");

        timeTableGenerator.addExam(exam1);
        timeTableGenerator.addExam(exam2);
        timeTableGenerator.addExam(exam3);

        do {
            style.line();
            System.out.println("\tExam Time Table Generator Menu");
            style.line();
            System.out.println("\t\t1. Add new exam.");
            System.out.println("\t\t2. Remove an exam.");
            System.out.println("\t\t3. Update exam.");
            System.out.println("\t\t4. Generate time table.");
            System.out.println("\t\t5. Clear screen.");
            System.out.println("\t\t6. Sort.");
            System.out.println("\t\t7. Exit." );
            style.line();

            System.out.print("\tEnter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            style.line();

            switch (choice) {
                case 1: {
                    timeTableGenerator.insertNewExam();
                    break;
                }
                case 2: {
                    boolean examRemoved = false;

                    System.out.print("\tEnter the subject of the exam to remove : ");
                    String subjectToRemove = scanner.nextLine();

                    for (Exam exam : timeTableGenerator.exams) {
                        if (exam.getSubject().equalsIgnoreCase(subjectToRemove)) {
                            timeTableGenerator.removeExam(exam);
                            System.out.println("\tExam removed successfully!");
                            examRemoved = true;
                            break;
                        }
                    }

                    if (!examRemoved) {
                        System.out.println("Exam not found in the timetable.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter the subject of the exam to update: ");
                    String subjectToUpdate = scanner.nextLine();
                    boolean examUpdated = false;
                    for (Exam exam : timeTableGenerator.exams) {
                        if (exam.getSubject().equalsIgnoreCase(subjectToUpdate)) {
                            timeTableGenerator.removeExam(exam);
                            timeTableGenerator.insertNewExam();
                            System.out.println("Exam updated successfully!");
                            examUpdated = true;
                            break;
                        }
                    }

                    if (!examUpdated)
                        System.out.println("Exam not found in the timetable.");

                    break;
                }
                case 4: {
                    timeTableGenerator.generateTimeTable();
                    break;
                }
                case 5:
                {
                    System.out.print("\u001b[H\u001b[2J");
                    break;
                }
                case 6: {
                    timeTableGenerator.sort();
                    break;
                }
                case 7: {
                    System.out.println("Thank you for using the Exam Time Table Generator!");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
                }
            }
        } while (choice != 7);

        scanner.close();
    }
}