import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddEmploye extends JFrame implements ActionListener {

    JTextField tfname,tfage,tfsalary,tfpone,tfemail,tfadhar;
    JRadioButton rmale,rfemale;
    JComboBox cbjob;
    JButton submit;

    AddEmploye(){
        setLayout(null);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200, 30,150,30);
        add(tfname);

        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200, 80,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);

        rmale=new JRadioButton("Male");
        rmale.setBounds(200,130,70,30);
        rmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale=new JRadioButton("Female");
        rfemale.setBounds(280,130,70,30);
        rfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);

        String str[]={"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff", "Room Services","chefs","Waiter/Waitress","Managers","Accountent"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblslary=new JLabel("SALARY");
        lblslary.setBounds(60,230,120,30);
        lblslary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblslary);

        tfsalary=new JTextField();
        tfsalary.setBounds(200, 230,150,30);
        add(tfsalary);

        JLabel lblpone=new JLabel("PHONE");
        lblpone.setBounds(60,280,120,30);
        lblpone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblpone);

        tfpone=new JTextField();
        tfpone.setBounds(200, 280,150,30);
        add(tfpone);

        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(200, 330,150,30);
        add(tfemail);

        JLabel lbladhar=new JLabel("ADHAR NO");
        lbladhar.setBounds(60,380,120,30);
        lbladhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbladhar);

        tfadhar=new JTextField();
        tfadhar.setBounds(200, 380,150,30);
        add(tfadhar);

        submit=new JButton("SUBMIT");
        submit.setBounds(200,430,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,380);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfpone.getText();
        String email=tfemail.getText();
        String adhar=tfadhar.getText();

        String gender=null;

        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be null");
            return;
        }
        
        if(rmale.isSelected()){
            gender="Male";
        }
        else if(rfemale.isSelected()){
            gender="Female";
        }

        String job=(String)cbjob.getSelectedItem();

        try {
            Conn conn=new Conn();

            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhar+"')";
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employee added Successfully");
            setVisible(false);

        } catch (Exception e) {
           e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        new AddEmploye();
    }
}
