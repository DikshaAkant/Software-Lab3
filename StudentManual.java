public class StudentManual {

    static class StudentMan {
    
        int id;
        String name;
        int marks;

        StudentMan(int id, String name, int marks){
            this.id=id;
            this.name = name;
            this.marks = marks;
        }

        public int getId(){
            return id;
        }

        public void setID(int id){
            this.id = id;
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

    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        StudentMan s1 = new StudentMan(1, "Rasika", 45);
        StudentMan s2 = new StudentMan(2, "Atharva", 44);
        StudentMan s3 = new StudentMan(3, "Payal", 47);

        System.out.println(s1.id + " " + s1.name + " " + s1.marks);
        System.out.println(s2.id + " " + s2.name + " " + s2.marks);
        System.out.println(s3.id + " " + s3.name + " " + s3.marks);

        long end = System.nanoTime();
        long duration = (end - start)/1000;

        System.out.println("Duration: " + duration + " ms");

    }
}
