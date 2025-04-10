import Assignment.Student;
import Assignment.StudentManagement;
import Helper.readCSV;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = readCSV.readStudents("student.csv");
        try {
            students = readCSV.readStudents("student.csv");
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc file student.csv: " + e.getMessage());
            students = new ArrayList<>();
        }

        while (true) {
            System.out.println("\n===== MENU QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Sắp xếp theo điểm (Merge Sort)");
            System.out.println("3. Thêm sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Chỉnh sửa sinh viên");
            System.out.println("6. Tìm kiếm sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    StudentManagement.displayStudents(students);
                    if (students.isEmpty()) {
                        System.out.println("Danh sách sinh viên trống.");
                    } else {
                        StudentManagement.displayStudents(students);
                    }
                    break;
                case "2":
                    StudentManagement.mergeSort(students, 0, students.size() - 1);
                    System.out.println("Đã sắp xếp theo điểm.");
                    break;
                case "3":
                    StudentManagement.addStudent(students, scanner);
                    readCSV.writeStudents("student.csv", students);
                    break;
                case "4":
                    StudentManagement.removeStudent(students, scanner);
                    readCSV.writeStudents("student.csv", students);
                    break;
                case "5":
                    StudentManagement.editStudent(students, scanner);
                    readCSV.writeStudents("student.csv", students);
                    break;
                case "6":
                    StudentManagement.searchStudent(students, scanner);
                    break;
                case "0":
                    System.out.println("Tạm biệt!");
                    scanner.close(); // Đóng Scanner
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
