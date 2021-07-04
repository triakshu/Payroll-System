
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class password extends JFrame implements ActionListener{
JLabel l1,l2,l3;
JButton b1,b2;
JTextField t1;
JPasswordField t2,t3;
password()
{
super("Password");
setLayout(new BorderLayout());
        
t1 = new JTextField(20);
t2 = new JPasswordField(20);
t3 = new JPasswordField(20);
        
b1 = new JButton("Submit");
b2 = new JButton("Cancel");
        
b1.addActionListener(this);
b2.addActionListener(this);
        
JPanel p1,p2;
        
p1 = new JPanel();
p2 = new JPanel();
        
p1.add(new JLabel("Enter Your Email "));
p1.add(t1);
p1.add(new JLabel("Enter New Password "));
p1.add(t2);
p1.add(new JLabel("Re-Enter Password "));
p1.add(t3);
        
p2.add(b1);
p2.add(b2);
   
add(p1,BorderLayout.CENTER);
add(p2,BorderLayout.SOUTH);
        
setSize(400,250);
setLocation(600,400);	
setVisible(true);
}

@Override
public void actionPerformed(ActionEvent ae) {
JButton b=(JButton)ae.getSource();
try{
conn c1=new conn();
String m=t1.getText();
String query="Select email from login";    
ResultSet rs=c1.s.executeQuery(query);
            
if(rs.next()){
System.out.println("Email matches");
String u=t2.getText();
String v=t3.getText();
            
if(u.equals(v))
{
System.out.println("Password matches");
String q="Update login set password='"+u+"' where username='akshita'";
c1.s.executeUpdate(q);
System.out.println("Updated");            
JOptionPane.showMessageDialog(null,"Password Updated");
new login().setVisible(true);
setVisible(false);
}
else
{
JOptionPane.showMessageDialog(null,"Password Does Not Match");
}
}
else{
JOptionPane.showMessageDialog(null,"Invaid Mail");
setVisible(false);
}
}
           
catch(Exception e){
}
}
public static void main(String args[])
{
new password();
}
}











