import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice customer;
    JTextField tfroom, tfname, tfchekintime, tfamountpayed, tfpendingamount;
    JButton check, update, back;

    UpdateCheck() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
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
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);

        tfchekintime = new JTextField();
        tfchekintime.setBounds(200, 200, 150, 25);
        add(tfchekintime);

        JLabel lblamountpayed = new JLabel("Amount Paid");
        lblamountpayed.setBounds(30, 240, 100, 20);
        add(lblamountpayed);

        tfamountpayed = new JTextField();
        tfamountpayed.setBounds(200, 240, 150, 25);
        add(tfamountpayed);

        JLabel lblpendingamount = new JLabel("Pending Amount");
        lblpendingamount.setBounds(30, 280, 100, 20);
        add(lblpendingamount);

        tfpendingamount = new JTextField();
        tfpendingamount.setBounds(200, 280, 150, 25);
        add(tfpendingamount);

        check = new JButton("Check");
        check.setBounds(30, 340, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(150, 340, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(300, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 900, 500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = customer.getSelectedItem();
            String query = "select * from customer where number='" + id + "'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfchekintime.setText(rs.getString("checkintime"));
                    tfamountpayed.setText(rs.getString("deposit"));
                }

                ResultSet rs2 = conn.s.executeQuery("select * from room where roomnumber='" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("price");
                    int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfamountpayed.getText());
                    tfpendingamount.setText("" + amountpaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {

            String number=customer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfchekintime.getText(); 
            String deposit=tfamountpayed.getText();

            try {
                    Conn conn=new Conn();
                    conn.s.executeUpdate("update customer set room='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposit+"' where number='"+number+"'");

                    JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                    
                    setVisible(false);
                    new UpdateCheck();

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
