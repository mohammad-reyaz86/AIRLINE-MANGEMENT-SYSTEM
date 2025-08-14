
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton submit,reset,close;
    JTextField tfusername;
    JPasswordField pfpassword;
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername=new JLabel("username");
        lblusername.setBounds(20,20,100,20);
        add(lblusername);

        
        tfusername=new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);

        
        JLabel lblpassword=new JLabel("password");
        lblpassword.setBounds(20,60,100,20);
        add(lblpassword);

        
        pfpassword = new JPasswordField();
        pfpassword.setBounds(130,60,200,20);
        add(pfpassword);


        reset=new JButton("Reset");
        reset.setBounds(60,120,100,20);
        add(reset);
        reset.addActionListener(this);


        submit=new JButton("submit");
        submit.setBounds(190,120,100,20);
        add(submit);
        submit.addActionListener(this);


        close=new JButton("close");
        close.setBounds(130,160,100,20);
        add(close);
        close.addActionListener(this);

        setSize(400,250);
        setLocation(500,250);
        setVisible(true); 

    }
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String username=tfusername.getText();
            String password=pfpassword.getText();
            
            try{
                Conn c=new Conn();
                String query="select * from login where username ='"+username+"' and password='"+password+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid  username or password");
                    setVisible(false);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==close){
            setVisible(false);
        }else if(ae.getSource()==reset){
            tfusername.setText("");
            pfpassword.setText("");
        }     
    }
    public static void main(String args[]){
        new Login();
    }
}

