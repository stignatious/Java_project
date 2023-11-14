package com.javaProjects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JavaProject extends JFrame
{
    JavaProject()
    {
        JFrame f = new JFrame("first");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.CYAN);
        f.setSize(1000,1000);
        f.setResizable(false);
        f.setVisible(true);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setBackground(Color.CYAN);
        panel1.setBackground(Color.YELLOW);
        panel2.setBackground(Color.DARK_GRAY);
        f.add(panel).setBounds(0, 0, 400, 1000);
        f.add(panel1).setBounds(200, 0, 800, 400);
        f.add(panel2).setBounds(200, 100, 500, 400);
        JButton my_button = new JButton("submit");
        JLabel my_icon_label = new JLabel();
        /*String country[] = {"Kenya", "Uganda", "Ethiopia", "Eritrea", "Tanzania"};*/
        /*JComboBox<String> comboBox1 = new JComboBox<>(country);*/
        /*panel.add(comboBox1);*/
        JLabel carName = new JLabel("enter the name of the car");
        carName.setBounds(110, 10, 200, 50);
        JTextField my_carName = new JTextField();
        my_carName.setBounds(110, 50, 200, 50);
        JLabel carModel = new JLabel("enter the car model");
        carModel.setBounds(110, 100, 200, 50);
        JTextField my_carModel =  new JTextField();
        my_carModel.setBounds(110, 150, 200, 50);
        JLabel carOwner = new JLabel("enter the name of the car owner");
        carOwner.setBounds(110, 200, 300, 50);
        JTextField the_carOwner = new JTextField();
        the_carOwner.setBounds(110, 250, 200, 50);
        JLabel carPrice = new JLabel("Price of the car");
        carPrice.setBounds(110,300, 350, 50);
        JTextField the_carPrice = new JTextField();
        the_carPrice.setBounds(110,350, 200, 50);
        my_button.setBounds(110, 400, 150, 50);
        panel.add(carName);
        panel.add(carModel);
        panel.add(carOwner);
        panel.add(carPrice);
        panel.add(my_carName);
        panel.add(my_carModel);
        panel.add(the_carOwner);
        panel.add(the_carPrice);
        my_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ImageIcon icon = myWindowImage("images.jpeg");
                my_icon_label.setIcon(icon);
                JavaProject m = new JavaProject();
                m.myDisplay();
            }
        });
        panel1.add(my_icon_label);
        panel.add(my_button);
    }

    private void myDisplay() {
        System.out.println("my name is Anthony");
    }

    static Component display(){
        System.out.println("the car that i have bought is volvo");
        return null;
    }
    public ImageIcon myWindowImage(String my_image_location)
    {
        java.net.URL myImage = getClass().getResource(my_image_location);
        if (myImage != null){
            return new ImageIcon(myImage);
        }
        else{
            System.err.println("the image is not recognized"+ my_image_location);
            return null;
        }
    }
    public static void main(String[] args) {
        new JavaProject();
    }
}
