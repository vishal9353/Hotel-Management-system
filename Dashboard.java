  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
     Dashboard(){
       
         setLayout(null);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
         Image i2=i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(0,0,1550,1000);
         add(image);

        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,40));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addemploye=new JMenuItem("Add Employee");
        addemploye.addActionListener(this);
        admin.add(addemploye);

        JMenuItem addrooms=new JMenuItem("Add Rooms");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem addriver=new JMenuItem("Add Driver");
        addriver.addActionListener(this);
        admin.add(addriver);

        setBounds(0,0,1366,900);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getActionCommand().equals("Add Employee")){
         new AddEmploye();
      }
      else if(ae.getActionCommand().equals("Add Rooms")){
         new AddRooms();
      }
      else if(ae.getActionCommand().equals("Add Driver")){
         new AddDriver();
      }
      else if(ae.getActionCommand().equals("RECEPTION")){
         new Reception();
      }
      
    }

    public static void main(String[] args) {
       new Dashboard();
    }
}



