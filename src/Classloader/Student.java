package Classloader;

public class Student extends Person {
    public String desc;
    private  static int score =100;

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static int setScore(int score) {
       return Student.score = score;
    }

    private String getDesc() {
        return desc;
    }

    private static int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "desc='" + desc + '\'' +
                ", score=" + score +
                '}';
    }

}
