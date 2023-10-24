import java.sql.*;

public class DBFrontend {
    Connection conn;
    ResultSet result;
    PreparedStatement pstm;


//connects to the database
    public DBFrontend() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mthschool","root","");
            System.out.println("connected");

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

// inserts a new student to the database
    public int insertStudent(Student student)
    {   int i =-1;
        try{  //System.out.println(" gashula"+ owner);

            pstm=conn.prepareStatement("insert into student(birthC_no, firstname, lastname, age, gender) values(?,?,?,?,?)");
            pstm.setString(1,student.getBirthCno());
            pstm.setString(2,student.getFirstname());
            pstm.setString(3,student.getLastname());
            pstm.setInt(4,student.getAge());
            pstm.setString(5,student.getGender());

            // System.out.println(i+" jaa");
            i=pstm.executeUpdate();
            //System.out.println(i+" records inserted");


        }catch(Exception e)
        {   e.printStackTrace();
            System.out.println(e);
        }
        finally {
            return i;
        }
    }

    //Lists all data in the class
    public String listClasses()
    {  String list = new String();

        try{
            pstm=conn.prepareStatement("select * from class ");
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                // System.out.println(rs.getInt(1)+" "+rs.getString(2));

                Classes classes = new Classes(rs.getInt("class_id"),rs.getString("subject_name"), rs.getString("firstname"),rs.getString("lastname"),rs.getString("birthC_no") );
                list = list +classes.toString()+"\n";
            }
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        finally{
            return list;
        }


    }

    //inserts data into  the class
    public int insertClasses(Classes classes)
    {   int i =-1;
        try{  //System.out.println(" gashula"+ owner);

            pstm=conn.prepareStatement("insert into class(class_id, subject_name,firstname, lastname,birthC_no) values(?,?,?,?,?)");
            pstm.setInt(1,classes.getClassid());
            pstm.setString(2,classes.getSubjectname());
            pstm.setString(3,classes.getFirstname());
            pstm.setString(4,classes.getLastname());
            pstm.setString(5,classes.getBirthCno());
            // System.out.println(i+" jaa");
            i=pstm.executeUpdate();
            //System.out.println(i+" records inserted");


        }catch(Exception e)
        {   e.printStackTrace();
            System.out.println(e);
        }
        finally {
            return i;
        }
    }





}


