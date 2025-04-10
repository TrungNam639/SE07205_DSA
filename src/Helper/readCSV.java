package Helper;

import Assignment.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class readCSV {
    public static ArrayList<Student> readStudents(String filename) {
        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Bỏ dòng tiêu đề

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    double score = Double.parseDouble(parts[2]);
                    students.add(new Student(id, name, score));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void writeStudents(String string, ArrayList<Student> students) {
        throw new UnsupportedOperationException("Unimplemented method 'writeStudents'");
    }
}
