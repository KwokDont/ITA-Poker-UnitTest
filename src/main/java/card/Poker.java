package card;

public class Poker {

    private String num;
    private char grade;

    public Poker(String num, char grade) {
        this.num = num;
        this.grade = grade;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
