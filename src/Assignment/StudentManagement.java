package Assignment;

import java.util.*;
import Helper.*;

public class StudentManagement {
    private List<Student> database;

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.menu();
    }

    public StudentManagement() {
        System.out.println("Reading data from CSV file... " + System.getProperty("user.dir"));
        database = readCSV.csvToArray(System.getProperty("user.dir") + "/student.csv");
        System.out.println("Number of students: " + database.size());
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Add student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Show student list");
            System.out.println("5. Search student by ID");
            System.out.println("6. Sort by score (descending)");
            System.out.println("0. Exit");
            System.out.print("Select function: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> updateStudent(sc);
                case 3 -> deleteStudent(sc);
                case 4 -> showAll();
                case 5 -> searchStudent(sc);
                case 6 -> sortByMark();
                case 0 -> {
                    System.out.println("Program exited.");
                    return;
                }
                default -> System.out.println("Invalid selection!");
            }
        }
    }

    private void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter mark: ");
        double mark = sc.nextDouble();
        sc.nextLine();
        database.add(new Student(id, name, mark));
        System.out.println("Student added successfully.");
    }

    private void updateStudent(Scanner sc) {
        System.out.print("Enter the ID to update: ");
        String id = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getId().equals(id)) {
                System.out.print("New name: ");
                String name = sc.nextLine();
                System.out.print("New mark: ");
                double mark = sc.nextDouble();
                sc.nextLine();
                database.set(i, new Student(id, name, mark));
                System.out.println("Updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with ID: " + id);
        }
    }

    private void deleteStudent(Scanner sc) {
        System.out.print("Enter the ID to delete: ");
        String id = sc.nextLine();
        boolean removed = database.removeIf(s -> s.getId().equals(id));
        if (removed) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("No student found.");
        }
    }

    public void showAll() {
        System.out.println("\nList of students:");
        System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Name", "Mark", "Rank");
        for (Student s : database) {
            System.out.printf("%-10s %-20s %-10.2f %-10s%n",
                    s.getId(), s.getName(), s.getMark(), s.getRank());
        }
    }

    private void searchStudent(Scanner sc) {
        System.out.print("Enter the ID you are looking for: ");
        String id = sc.nextLine();
        for (Student s : database) {
            if (s.getId().equals(id)) {
                System.out.printf("ID: %s, Name: %s, Mark: %.2f, Rank: %s%n",
                        s.getId(), s.getName(), s.getMark(), s.getRank());
                return;
            }
        }
        System.out.println("No student found.");
    }

    private void sortByMark() {
        database = mergeSort(database);
        System.out.println("Sorted by score (descending) using Merge Sort.");
    }

    private List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Student> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<Student> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMark() >= right.get(j).getMark()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
