package ExamTimeTableGenerator;

import java.util.Scanner;

public class ExamTimeTableMain {
    public static void main(String[] args) {
        Style style = new Style();
        ExamTimeTableGenerator timeTableGenerator = new ExamTimeTableGenerator();
        Scanner scanner = new Scanner(System.in);

        int choice;

        Exam exam1 = new Exam( 101, "Java", "2024-02-10", "09:00 AM", "Room 101", "Mr.Vanda", 2, "Monday");
        Exam exam2 = new Exam(102, "C Sharp", "2024-02-12", "8:30 AM", "Room 201", "Mr.Dara", 3, "Wednesday");
        Exam exam3 = new Exam(103, "Statistics Analysis", "2024-02-15", "02:00 PM", "Room 301", "Mr.Vanna", 1, "Friday");

        timeTableGenerator.addExam(exam1);
        timeTableGenerator.addExam(exam2);
        timeTableGenerator.addExam(exam3);

        do {
            style.line();
            System.out.println("\tExam Time Table Generator Menu");
            style.line();
            System.out.println("\t\t1. Input.");
            System.out.println("\t\t2. Generate time table.");
            System.out.println("\t\t3. Search");
            System.out.println("\t\t4. Update.");
            System.out.println("\t\t5. Delete.");
            System.out.println("\t\t6. Exit." );
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
                    timeTableGenerator.generateTimeTable();
                    break;
                }
                case 3: {
                    int id;
                    boolean isFound = false;

                    System.out.print( "Enter exam ID to search: " );
                    id = scanner.nextInt();


                    for (Exam exam : timeTableGenerator.exams) {
                        if (exam.getId() == id ) {
                            style.line();
                            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "ID", "Subject", "Date", "Time", "Room", "Teacher Name", "Year of Student", "Day");
                            style.line();
                            System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", exam.getId(), exam.getSubject(), exam.getDate(), exam.getTime(), exam.getRoom(), exam.getTeacherName(), exam.getYearOfStudent(), exam.getDay());
                            style.line();

                            isFound = true;
                            break;
                        }
                    }

                    if ( !isFound )
                        System.out.println( "Search not found!" );

                    break;
                }
                case 4: {
                    System.out.print("Enter the subject ID to update: ");
                    int subjectToUpdate = scanner.nextInt();
                    boolean examUpdated = false;
                    for (Exam exam : timeTableGenerator.exams) {
                        if (exam.getId() == subjectToUpdate ) {
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
                case 5: {
                    boolean examRemoved = false;

                    System.out.print("\tEnter the subject ID to remove : ");
                    int subjectToRemove = scanner.nextInt();

                    for (Exam exam : timeTableGenerator.exams) {
                        if (exam.getId() == subjectToRemove) {
                            timeTableGenerator.removeExam(exam);
                            System.out.println("\tExam removed successfully!");
                            examRemoved = true;
                            break;
                        }
                    }

                    if (!examRemoved)
                        System.out.println("Exam not found in the timetable.");

                    break;
                }
                case 6: {
                    System.out.println("Thank you for using the Exam Time Table Generator!");
                    break;
                }
                default: {
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
                }
            }
        } while (choice != 6);

        scanner.close();
    }
}