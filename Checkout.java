import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Checkout extends JFrame implements ActionListener{

    Choice customer;
    JLabel lblroomnumbner,lblcheckin,lblcheckout;
    JButton checkout,back;
    
    
    Checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblheading=new JLabel("Checkout");
        lblheading.setBounds(100,20,100,30);
        lblheading.setForeground(Color.BLUE);
        lblheading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblheading);

        JLabel lblid=new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        add(customer);

        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(360,80,20,20);
        add(image);

        JLabel lblroom=new JLabel("Room number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

        lblroomnumbner=new JLabel("");
        lblroomnumbner.setBounds(200,130,100,30);
        add(lblroomnumbner);

        JLabel lblcheckintime=new JLabel("Checkin Time");
        lblcheckintime.setBounds(30,180,100,30);
        add(lblcheckintime);

        lblcheckin=new JLabel("");
        lblcheckin.setBounds(200,180,100,30);
        add(lblcheckin);

        JLabel lblcheckouttime=new JLabel("CheckOut Time");
        lblcheckouttime.setBounds(30,230,100,30);
        add(lblcheckouttime);

        Date date=new Date();
        lblcheckout=new JLabel("" +date);
        lblcheckout.setBounds(200,230,170,30);
        add(lblcheckout);

        checkout = new JButton("Checkout");
        checkout.setBounds(30, 280, 120, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(200, 280, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try {

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add((rs.getString("number")));
                lblroomnumbner.setText(rs.getString("room"));
                lblcheckin.setText(rs.getString("checkintime"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(380,50,400,250);
        add(image2);


        setBounds(300,200,800,400);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){

            Conn c=new Conn();

            String query1="delete from customer where number='"+customer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnumber='"+lblroomnumbner.getText()+"'";

            try {
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Checkout Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new Checkout();
    }
}
