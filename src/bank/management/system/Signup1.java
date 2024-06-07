package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Signup1 extends JFrame implements ActionListener {
    long random;
    JTextField namefield,fnamefield,emailTextField,addrfield,statefield,pinfield ;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser  datefield;
   
    Signup1(){
        
        setLayout(null);
        Random ran = new Random();
        random =  Math.abs((ran.nextLong() % 9000L)+1000L);
        
        
        JLabel formno = new JLabel("APPLICATION FORM NUMBER:"+ random );  //random form number
        formno.setFont(new Font("Raleway", Font.BOLD,28));
        formno.setBounds(150, 20,600,40);
        add(formno);
        
         JLabel details = new JLabel("PAGE 1: PERSONAL DETAILS" );  
        details.setFont(new Font("Raleway", Font.BOLD,22));
        details.setBounds(220, 80,500,40);
        add(details);
         
        JLabel name = new JLabel("Name:");  
        name.setFont(new Font("Raleway", Font.BOLD,18));
       name.setBounds(150,150,600,40);
        add(name);
        
       namefield = new JTextField();
        namefield.setFont(new Font("Raleway", Font.BOLD,14));
        namefield.setBounds(330,150,300,40);
        add(namefield);
        
        
        
         JLabel fname = new JLabel("Father's Name:");  
        fname.setFont(new Font("Raleway", Font.BOLD,18));
       fname.setBounds(150, 200,600,40);
        add(fname);
          fnamefield = new JTextField();
        fnamefield.setFont(new Font("Raleway", Font.BOLD,14));
        fnamefield.setBounds(330,200,300,40);
        add(fnamefield);
        
         JLabel dob = new JLabel("Date Of Birth:");  
        dob.setFont(new Font("Raleway", Font.BOLD,18));
       dob.setBounds(150, 250,600,40);
        add(dob);
        datefield= new JDateChooser();
        datefield.setBounds(330, 250, 200, 40);
        datefield.setForeground(Color.BLUE);
        add(datefield);
        
         JLabel gender = new JLabel("Gender:");  
        gender.setFont(new Font("Raleway", Font.BOLD,18));
       gender.setBounds(150, 300,600,40);
        add(gender);
        
         male= new JRadioButton("Male");
        male.setBounds(330, 300, 100, 40);
        male.setBackground(Color.white);
        add(male);
        
        female= new JRadioButton("Female");
        female.setBounds(450, 300, 100, 40);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);
        
        
         JLabel mail = new JLabel("e-mail:");  
        mail.setFont(new Font("Raleway", Font.BOLD,18));
       mail.setBounds(150, 350,600,40);
        add(mail);
       emailTextField = new JTextField();
       emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
      emailTextField.setBounds(330,350,300,40);
        add(emailTextField);
        
        
        JLabel marital = new JLabel("Marital Status:");  
        marital.setFont(new Font("Raleway", Font.BOLD,18));
       marital.setBounds(150, 400,600,40);
        add(marital);
       
        married= new JRadioButton("MARRIED");
        married.setBounds(330, 400, 100, 40);
        married.setBackground(Color.white);
        add(married);
        
         unmarried= new JRadioButton("UNMARRIED");
      unmarried.setBounds(450, 400, 100, 40);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other= new JRadioButton("OTHER");
        other.setBounds(550, 400, 100, 40);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup marriagegrp = new ButtonGroup();
        marriagegrp.add(married);
        marriagegrp.add(unmarried);
        marriagegrp.add(other);
      
        
        
        
        JLabel addr = new JLabel("Address:");  
        addr.setFont(new Font("Raleway", Font.BOLD,18));
       addr.setBounds(150, 450,600,40);
        add(addr);
        addrfield = new JTextField();
        addrfield.setFont(new Font("Raleway", Font.BOLD,14));
        addrfield.setBounds(330,450,300,40);
        add(addrfield);
        
        
        
        JLabel state = new JLabel("State:");  
        state.setFont(new Font("Raleway", Font.BOLD,18));
       state.setBounds(150, 500,200,40);
        add(state);
        statefield = new JTextField();
        statefield.setFont(new Font("Raleway", Font.BOLD,14));
        statefield.setBounds(330,500,300,40);
        add(statefield);
        
         JLabel pin = new JLabel("Pincode:");  
        pin.setFont(new Font("Raleway", Font.BOLD,18));
       pin.setBounds(150, 550,600,40);
        add(pin);
      pinfield = new JTextField();
        pinfield.setFont(new Font("Raleway", Font.BOLD,14));
        pinfield.setBounds(330,550,300,40);
        add(pinfield);
        
        
        next= new JButton("NEXT");
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(550, 620, 100, 40);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
        
        getContentPane().setBackground(Color.white);
         
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae){
        String formno= ""+ random;
        String name = namefield.getText();
        String fname = fnamefield.getText();
        String dob = ((JTextField) datefield.getDateEditor().getUiComponent()).getText();
        String gender = null;
            if (male.isSelected()) {
                gender = "male";
             } else if (female.isSelected()) {
                    gender = "female";
               }
    
    String email = emailTextField.getText();
    String marital = null;
    if (married.isSelected()) {
        marital = "Married";
    } else if (unmarried.isSelected()) {
        marital = "Unmarried";
    } else if (other.isSelected()) {
        marital = "Other";
    }
    
    String address = addrfield.getText();
    String pincode = pinfield.getText();
     String state= statefield.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "NAME REQUIRED");
            }else{
                Conn c = new Conn();
String query = "INSERT INTO signup VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
PreparedStatement pst = (PreparedStatement) c.prepareStatement(query);
pst.setString(1, formno);
pst.setString(2, name);
pst.setString(3, fname);
pst.setString(4, dob);
pst.setString(5, gender);
pst.setString(6, email);
pst.setString(7, marital);
pst.setString(8, address);
pst.setString(9, pincode);
pst.setString(10, state);

pst.executeUpdate();

                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        }catch(Exception e){
    System.out.println(e);
    }
    }
    public static void main(String args[]) {
        // TODO code application logic here
        new Signup1();
        
    }
    }

   