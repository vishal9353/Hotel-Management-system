import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener{

    JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    JButton add,cancel;

    AddDriver(){
        

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

       
        JLabel heading=new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,30);
        add(heading);

        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblname.setBounds(60,70,120,30);
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);

        JLabel lblage=new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblage.setBounds(60,110,120,30);
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblgender.setBounds(60,150,120,30);
        add(lblgender);

        String genderOption[]={"Male","Female"};
        gendercombo=new JComboBox(genderOption);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblcarcompany=new JLabel("Car Company");
        lblcarcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblcarcompany.setBounds(60,190,120,30);
        add(lblcarcompany);

        tfcompany=new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);


        JLabel lblmodel=new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblmodel.setBounds(60,230,120,30);
        add(lblmodel);

        tfmodel=new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);

        JLabel lblavailbl=new JLabel("Availability");
        lblavailbl.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailbl.setBounds(60,270,120,30);
        add(lblavailbl);

        String availbleOption[]={"Available","Busy"};
        availablecombo=new JComboBox(availbleOption);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        
        JLabel lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbllocation.setBounds(60,310,120,30);
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);

        add=new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);

        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);



        setBounds(300,200,980,470);     
        setVisible(true);

    }
   
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){

            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)gendercombo.getSelectedItem();
            String carcompany=tfcompany.getText();
            String carmodel=tfmodel.getText();
            String availability=(String)availablecombo.getSelectedItem();
            String location=tflocation.getText();
           

            try {
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+availability+"','"+location+"')";

                conn.s.executeUpdate(str);
               

                JOptionPane.showMessageDialog(null,"New Driver  Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }  


public static void main(String[] args) {
    new AddDriver();
}

}



