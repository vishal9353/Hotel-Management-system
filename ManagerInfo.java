import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.*;


public class ManagerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    ManagerInfo(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);


        JLabel l1=new JLabel("Name");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(130,10,100,20);
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(250,10,100,20);
        add(l3);

        JLabel l4=new JLabel("Job");
        l4.setBounds(380,10,100,20);
        add(l4);

        JLabel l5=new JLabel("Salary");
        l5.setBounds(500,10,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(630,10,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Email");
        l7.setBounds(770,10,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Adhar No");
        l8.setBounds(880,10,100,20);
        add(l8);

        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);


        try{
            Conn conn=new Conn();
            String query="select * from employee where job= 'Managers'";
            ResultSet rs=conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(420, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setBounds(200,100,1000,600);
        setVisible(true);
       

    }

    public void actionPerformed(ActionEvent ae){
       
            setVisible(false);
            new Reception();

        
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}
