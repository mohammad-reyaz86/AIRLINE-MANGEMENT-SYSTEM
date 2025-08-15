package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class FlightInfo extends JFrame {
    
        public FlightInfo(){
            
            getContentPane().setBackground(Color.white);
            setLayout(null);
            
            JTable table=new JTable();
            
            try{
                Conn conn=new Conn();
                
                ResultSet rs=conn.s.executeQuery("select * from flight");
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            JScrollPane jsp=new JScrollPane(table);//to add scroll bar
            jsp.setBounds(0, 0,800,500);
            add(jsp);
            setSize(800,500);
            setLocation(300,100);
            setVisible(true);
                
    }
  public static void main(String args[]){
      new FlightInfo(); 
   }     
}