public class Student {
    private int ID;
    private String name;
    private int marks;

    // No-argument constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(int ID, String name, int marks) {
        this.ID = ID;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        Student s1 = new Student(101, "Alice", 95);
        Student s2 = new Student(102, "Bob", 88);
        Student s3 = new Student(103, "Charlie", 76);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        long end = System.nanoTime();
        long microseconds = (end - start) / 1000;

        System.out.println("Execution time: " + microseconds + " microseconds");
    }
}

