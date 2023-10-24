import java.util.Objects;

public class Student {

    private String birthCno;
    private String firstname;
    private String lastname;

    private int age;
    private String gender;

    private String classid;

    public Student() {
        //super();
        // this(ownerID, firstname, lastname, gender);
    }

    public Student(String birthCno, String firstname, String lastname,int age, String gender) {
        this.birthCno = birthCno;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;

    }


    public String getBirthCno() {
        return birthCno;
    }

    public void setBirthCno(String birthCno) {
        this.birthCno = birthCno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student Student = (Student) o;
        return birthCno == Student.birthCno;
    }

    @Override
    public int hashCode() {

        return Objects.hash(birthCno);
    }

    @Override
    public String toString() {
        return "birthCno=" + birthCno + " firstname=" + firstname + " lastname=" + lastname  + "age="+ age + " gender=" + gender;

    }
}

