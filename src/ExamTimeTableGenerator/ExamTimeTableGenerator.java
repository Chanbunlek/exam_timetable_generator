package ExamTimeTableGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class ExamTimeTableGenerator {
    final List<Exam> exams;

    public ExamTimeTableGenerator() {
        exams = new ArrayList<>();
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public void removeExam(Exam exam) {
        exams.remove(exam);
    }



    public void generateTimeTable() {
        List<Exam> sortedExams = sortExams();
        List<Exam> timetable = new ArrayList<>();

        for (Exam exam : sortedExams) {
            boolean isConflict = false;
            for (Exam scheduledExam : timetable) {
                if (exam.getDate().equals(scheduledExam.getDate()) && exam.getTime().equals(scheduledExam.getTime())) {
                    isConflict = true;
                    break;
                }
            }

            if (!isConflict) {
                timetable.add(exam);
            }
        }

        displayTimeTable(timetable);
    }

    protected List<Exam> sortExams() {
        List<Exam> sortedExams = new ArrayList<>(exams);
        Collections.sort(sortedExams, Comparator.comparing(Exam::getDate).thenComparing(Exam::getTime));
        return sortedExams;
    }

    protected void displayTimeTable(List<Exam> timetable) {
        Style style = new Style();

        System.out.println("Exam Time Table");
        style.line();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "ID", "Subject", "Date", "Time", "Room", "Teacher Name", "Year of Student", "Day");
        style.line();

        for (Exam exam : timetable) {
            System.out.printf("%-20d%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", exam.getId(), exam.getSubject(), exam.getDate(), exam.getTime(), exam.getRoom(), exam.getTeacherName(), exam.getYearOfStudent(), exam.getDay());
            style.line();
        }
    }

    public void insertNewExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the subject of the new exam            : ");
        String subject = scanner.nextLine();

        System.out.print("Enter the date of the new exam (YYYY-MM-DD)  : ");
        String date = scanner.nextLine();

        System.out.print("Enter the time of the new exam (HH:MM AM/PM) : ");
        String time = scanner.nextLine();

        System.out.print("Enter the room of the new exam               : ");
        String room = scanner.nextLine();

        System.out.print("Enter the teacher name for the new exam      : ");
        String teacherName = scanner.nextLine();

        System.out.print("Enter the year of student for the new exam   : ");
        int yearOfStudent = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the day for the new exam               : ");
        String day = scanner.nextLine();

        boolean isTimeAndRoomAvailable = isTimeAndRoomAvailable(time, room);
        if (!isTimeAndRoomAvailable) {
            System.out.println("The time and room are already scheduled for another exam. Please choose a different time and room.");
            return;
        }

        Exam newExam = new Exam( exams.size(), subject, date, time, room, teacherName, yearOfStudent, day);
        addExam(newExam);
        System.out.println("New exam added successfully!");
    }

    public boolean isTimeAndRoomAvailable(String time, String room) {

        for (Exam exam : exams) {
            if (exam.getTime().equals(time) && exam.getRoom().equals(room)) {
                return false;
            }
        }
        return true;
    }
}