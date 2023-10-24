import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Viewer {
    private JTextField gendertextField;
    private JTextField agetextField;
    private JTextField firstnametextField;
    private JTextField birthCnotextField;
    private JTextField classidtextField;
    private JTextArea textArea1;
    private JButton assignclassbtn;
    private JButton addstudentbtn;
    private JButton listassignbtn;
    private JTextField lastnametextField;
    private JPanel panel1;
    private JTextField subjectnametextField;

    private final DBFrontend db;

    public Viewer() {

        JFrame frame = new JFrame();
        frame.setTitle("Viewer");
        frame.setSize(1600, 1400);
        frame.setLocation(0, 0);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.add(panel1);

        //frame.pack();;
        db = new DBFrontend();
        //adds student to the database
        addstudentbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String birthCno = birthCnotextField.getText();
                String firstname = firstnametextField.getText();
                String lastname = lastnametextField.getText();
                int age = Integer.parseInt(agetextField.getText());
                String gender = gendertextField.getText();



                Student student = new Student(birthCno,firstname,lastname, age,gender);

                int i = db.insertStudent(student);

                if (i > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added", "Alert", JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Unsuccessfully Added.", "Alert", JOptionPane.WARNING_MESSAGE);

            }
        });
        //assigns a student to a class
        assignclassbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int classid = Integer.parseInt(classidtextField.getText());
                String subjectname = subjectnametextField.getText();
                String firstname = firstnametextField.getText();
                String lastname = lastnametextField.getText();
                String birthCno = birthCnotextField.getText();

                Classes classes = new Classes(classid,subjectname, firstname, lastname, birthCno);

                int i = db.insertClasses(classes);

                if(i >0)
                    JOptionPane.showMessageDialog(null," Student Successfully Assigned.","Alert",JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Unsuccessful Student Assignment", "Alert", JOptionPane.WARNING_MESSAGE);



            }
        });
        //lists assigned students
        listassignbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(db.listClasses());
            }
        });
    }
    public static void main(String[] args){

        Viewer view = new Viewer();

    }
}


