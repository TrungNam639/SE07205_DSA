package Assignment;

public class Student {
    private String id;
    private String name;
    private double score;

    public Student(String id, String name, double score) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID không được để trống.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên không được để trống.");
        }
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Điểm phải nằm trong khoảng từ 0 đến 10.");
        }
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getScore() { return score; }

    public String getRank() {
        if (score < 5.0) return "Yếu";
        else if (score < 6.5) return "Trung bình";
        else if (score < 7.5) return "Khá";
        else if (score < 9.0) return "Giỏi";
        else return "Xuất sắc";
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Score: %.2f | Rank: %s", id, name, score, getRank());
    }
}
