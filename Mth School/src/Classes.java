import java.util.Objects;

public class Classes {
    ;

    private int classid;

    private String subjectname;
    private String firstname;

    private String lastname;

    private String birthCno;

    public Classes() {
        //super();
        // this(classid,subject_name, firstname, lastname, birthCno);
    }

    public Classes(int classid, String subjectname, String firstname,String lastname, String birthCno) {
        this.classid = classid;
        this.subjectname = subjectname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthCno = birthCno;

    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.birthCno = birthCno;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname=firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthCno(){
        return birthCno;
    }

    public void setBirthCno(String birthCno){
        this.birthCno = birthCno;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes Classes= (Classes)  o;
        return classid == Classes.classid;
    }

    @Override
    public int hashCode() {

        return Objects.hash(classid);
    }

    @Override
    public String toString() {
        return "classid=" + classid+ "subjectname="+ subjectname + " firstname=" + firstname + " lastname=" + lastname  + "birthCno="+ birthCno ;

    }
}

