public class Student {
    
    private String sID;
    private int grade;

    public Student() {
        sID = "";
        grade = -1;
    }

    public Student (String sID, int grade) {
        this.sID = sID;
        this.grade = grade;
    }

    public String getSID() {
        return sID;
    }

    public void setSID (String sID) {
        this.sID = sID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade (int grade) {
        this.grade = grade;
    }

    public String toString() {
        return sID + " : " + String.valueOf(grade);
    }

    public boolean equals (Student other) {
        return this.sID.equals(other.getSID());
    }








}