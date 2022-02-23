package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getStudentCount() {
        return this.students.size();
    }

    //getStudent(String firstName, String lastName) method - returns the student with the given names.
    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;

    }

    public List<Student> getStudents() {

        return this.students;
    }

    public String registerStudent(Student student) {
        StringBuilder output = new StringBuilder();
        if (this.students.size() < capacity) {
            if (this.students.contains(student)) {
                output
                        .append("Student is already in the university");
            } else {
                this.students.add(student);
                output.append("Added student ")
                        .append(student.firstName)
                        .append(" ")
                        .append(student.lastName);
            }
        } else {
            output
                    .append("No seats in the university");
        }
        return output.toString();
        /*StringBuilder sb = new StringBuilder();
        if (capacity > this.students.size()) {//&& !students.contains(student)
            students.add(student);
            sb.append("Added student ").append(student.getFirstName())
                    .append(" ").append(student.getLastName());
        } else if (students.contains(student)) {
            sb.append("Student is already in the university");
        } else {
            sb.append("No seats in the university");
        }

        return sb.toString();*/

    }

    public int getCapacity() {
        return this.capacity;
    }

    public String dismissStudent(Student student) {

        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public String getStatistics() {
        StringBuilder sbOutput = new StringBuilder();
        for (Student student : students) {

            sbOutput.append("==Student: First Name = ").append(student.getFirstName())
                    .append(", Last Name = ").append(student.getLastName())
                    .append(", Best Subject = ").append(student.getBestSubject())
                  .append(System.lineSeparator());

        }
        return sbOutput.toString().trim();
    }
}
//•	getStudent(String firstName, String lastName) method - returns the student with the given names.
//•	getStatistics() – returns a String in the following format:
//o	"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
// ==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
//   (…)"
//•	dismissStudent(Student student) method – removes the student
//o	Returns "Student not found" if the student is not in the university
//•	getCapacity()
//•	getStudents()
//•	capacity: int
//•	students: List<Student> - holds all added students in the university
//•	registerStudent(Student student) method – adds an entity to the students if there is room for it
//o	Returns "Added student {firstName} {lastName}" if the student is successfully added
//o	Returns "Student is already in the university" if the student is already in the university
//o	Returns "No seats in the university" if the university is full