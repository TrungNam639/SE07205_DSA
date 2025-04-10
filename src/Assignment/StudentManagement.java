package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    // Merge Sort
    public static void mergeSort(ArrayList<Student> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private static void merge(ArrayList<Student> list, int left, int mid, int right) {
        ArrayList<Student> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (list.get(i).getScore() < list.get(j).getScore()) {
                temp.add(list.get(i++));
            } else {
                temp.add(list.get(j++));
            }
        }

        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    // Thêm sinh viên
    public static void addStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.println("ID đã tồn tại. Vui lòng nhập lại.");
                return;
            }
        }
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập điểm: ");
        double score;
        try {
            score = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Điểm không hợp lệ. Vui lòng nhập lại.");
            return;
        }

        students.add(new Student(id, name, score));
        System.out.println("Đã thêm sinh viên.");
    }

    // Xóa sinh viên
    public static void removeStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Nhập ID sinh viên cần xóa: ");
        String id = scanner.nextLine();
        boolean removed = students.removeIf(s -> s.getId().equalsIgnoreCase(id));
        System.out.println(removed ? "Đã xóa sinh viên." : "Không tìm thấy sinh viên.");
    }

    // Chỉnh sửa sinh viên
    public static void editStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Nhập ID sinh viên cần sửa: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.print("Nhập tên mới: ");
                String name = scanner.nextLine();
                System.out.print("Nhập điểm mới: ");
                double score = Double.parseDouble(scanner.nextLine());
                students.remove(s);
                students.add(new Student(id, name, score));
                System.out.println("Đã cập nhật sinh viên.");
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên.");
    }

    // Tìm kiếm sinh viên
    public static void searchStudent(ArrayList<Student> students, Scanner scanner) {
        System.out.print("Nhập ID hoặc tên sinh viên cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        students.stream()
        .filter(s -> s.getId().toLowerCase().contains(keyword) || s.getName().toLowerCase().contains(keyword))
        .forEach(System.out::println);

        if (students.stream().noneMatch(s -> s.getId().toLowerCase().contains(keyword) || s.getName().toLowerCase().contains(keyword))) {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }

    // Hiển thị danh sách
    public static void displayStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
