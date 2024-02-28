package ExamTimeTableGenerator;

public class Exam {
    private final int id;
    private final String subject;
    private final String date;
    private final String time;
    private final String room;
    private final String teacherName;
    private final int yearOfStudent;
    private final String day;

    public Exam(int id, String subject, String date, String time, String room, String teacherName, int yearOfStudent, String day) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.time = time;
        this.room = room;
        this.teacherName = teacherName;
        this.yearOfStudent = yearOfStudent;
        this.day = day;
    }

    public int getId() { return id;}

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getYearOfStudent() {
        return yearOfStudent;
    }

    public String getDay() {
        return day;
    }
}