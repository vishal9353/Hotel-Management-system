import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfroom, tfavailble, tfstatus;
    JButton check, update, back;

    UpdateRoom() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setBounds(20, 20, 250, 30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);

        customer = new Choice();
        customer.setBounds(200, 80, 150, 25);
        add(customer);

        try {

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                customer.add((rs.getString("number")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room No");
        lblroom.setBounds(30, 130, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 25);
        add(tfroom);

        JLabel lblavilable = new JLabel("Avilability");
        lblavilable.setBounds(30, 180, 100, 20);
        add(lblavilable);

        tfavailble = new JTextField();
        tfavailble.setBounds(200, 180, 150, 25);
        add(tfavailble);

        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30, 230, 100, 20);
        add(lblcheckin);

        tfstatus = new JTextField();
        tfstatus.setBounds(200, 230, 150, 25);
        add(tfstatus);


        check = new JButton("Check");
        check.setBounds(30, 300, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150, 300, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400, 50, 450, 300);
        add(image);

        setBounds(300, 200, 900, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = customer.getSelectedItem();
            String query = "select * from customer where number='" +id+ "'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while (rs.next()) {
                    
                    tfroom.setText(rs.getString("room"));
                   
                }

                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber='" + tfroom.getText() + "'");
                while (rs2.next()) {
                    tfavailble.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource() == update) {

            String number=customer.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavailble.getText();
            String status=tfstatus.getText();
           

            try {
                    Conn conn=new Conn();
                    conn.s.executeUpdate("update room set availability='"+available+"',cleaning_status='"+status+"' where roomnumber='"+room+"'");

                    JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                    
                    setVisible(false);
                    new UpdateRoom();

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
