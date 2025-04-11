package Helper;

import Assignment.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readCSV {
    public static List<Student> csvToArray(String filePath) {
        List<Student> students = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        // Implement logic to read CSV file and populate the students list
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                // Tách từng dòng thành mảng các phần tử
                // String[] student = line.split(cvsSplitBy);
                // System.out.println(Arrays.toString(student));
                Student student = new Student(line.split(cvsSplitBy));
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // e.printStackTrace();  

                }
            }
        }

        return students;
    }

}