import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import net.proteanit.sql.*;


public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Department(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);


        JLabel l1=new JLabel("Department");
        l1.setBounds(100,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Budget");
        l2.setBounds(300,10,100,20);
        add(l2);


        table=new JTable();
        table.setBounds(0,50,400,350);
        add(table);


        try{
            Conn conn=new Conn();
            String query="select * from department";
            ResultSet rs=conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(280,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setBounds(200,100,700,480);
        setVisible(true);
       

    }

    public void actionPerformed(ActionEvent ae){
       
            setVisible(false);
            new Reception();

        
    }

    public static void main(String[] args) {
        new Department();
    }
}
