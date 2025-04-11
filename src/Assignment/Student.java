package Assignment;

public class Student {
    private String id;
    private String name;
    private double mark;
    private String rank; // Trường dữ liệu suy diễn

    public Student(String id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.rank = calculateRank(); // Calculate rank based on mark
    }

    public Student(String[] student) {
        this.id = student[0];
        this.name = student[1];
        this.mark = Double.parseDouble(student[2]);
        this.rank = calculateRank(); // Calculate rank based on mark
    }

    private String calculateRank() {
        if (mark >= 0 && mark <= 5) {
            return "fail";
        } else if (mark > 5 && mark <= 7) {
            return "pass";
        } else if (mark > 7 && mark <= 9) {
            return "good";
        } else if (mark > 9 && mark <= 10) {
            return "excellent";
        } else {
            return "invalid";
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public String getRank() {
        return rank;
    }

    public void getStudent() {
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Mark: " + this.getMark());
    }

    // Getters and setters for other fields (optional)
}