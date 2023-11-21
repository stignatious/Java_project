package com.javaProjects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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
        panel2.setBackground(Color.BLUE);
        f.add(panel).setBounds(0, 0, 400, 1000);
        f.add(panel1).setBounds(200, 0, 800, 400);
        f.add(panel2).setBounds(200, 100, 500, 400);
        panel.setLayout(new GridLayout(16, 2));
        JLabel output = new JLabel("The Image of the Car selected will pop here");
        output.setBounds(700, 0, 300, 50);
        panel1.add(output);
        Font myFont = new Font("Serif", Font.BOLD, 15);
        output.setFont(myFont);
        JLabel myThirdLab = new JLabel("the Information of the car you have selected will pop up here");
        myThirdLab.setFont(myFont);
        panel2.add(myThirdLab);
        myThirdLab.setBounds(600, 600, 200, 50);
        JButton my_button = new JButton("submit");
        JLabel my_icon_label = new JLabel();
        JLabel carName = new JLabel("enter the name of the car");
        carName.setBounds(110, 10, 200, 30);
        //JTextField my_carName = new JTextField();
        JComboBox<String> my_carName = new JComboBox<>();
        //my_carName.setBounds(110, 50, 200, 50);
        JLabel carModel = new JLabel("enter the car model");
        carModel.setBounds(110, 100, 200, 30);
        //JTextField my_carModel =  new JTextField();
        String[] carType = {"SUV", "Covertible", "Toyota", "Isuzu", "Mitsubishi", "Lexus", "Honda"};
        JComboBox<String> my_carModel = new JComboBox<>(carType);
        my_carModel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String  inputSelected = (String) my_carModel.getSelectedItem();
                my_carName.removeAllItems();
                if("Toyota".equals(inputSelected)){
                    my_carName.addItem("hyundai");
                    my_carName.addItem("Landcruiser");
                    my_carName.addItem("Harrier");
                    my_carName.addItem("Probox");
                    my_carName.addItem("vitz");
                    my_carName.addItem("Alphard");
                } else if ("Isuzu".equals(inputSelected)) {
                    my_carName.addItem("DMAX");
                    my_carName.addItem("OFFROAD");
                    my_carName.addItem("Wide Load Truck");
                } else if ("Lexus".equals(inputSelected)) {
                    my_carName.addItem("LX 570");
                    my_carName.addItem("LX 1250");
                    my_carName.addItem("SUV");
                }
            }
        });
        my_carModel.setBounds(110, 150, 200, 30);
        JLabel carOwner = new JLabel("enter the name of the car owner\n");
        carOwner.setBounds(110, 200, 350, 30);
        JTextField the_carOwner = new JTextField();
        the_carOwner.setBounds(110, 250, 200, 30);
        JLabel carPrice = new JLabel("\nPrice of the car");
        carPrice.setBounds(110,400, 400, 30);
        Integer[] originalPrice = {2000000, 3000000, 400000, 500000};
        JComboBox<Integer> the_carPrice;
        the_carPrice = new JComboBox<>(originalPrice);
        //JTextField the_carPrice = new JTextField();
        the_carPrice.setBounds(110,350, 200, 30);
        my_button.setBounds(110, 400, 150, 30);
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
                String comboValue = Objects.requireNonNull(my_carName.getSelectedItem()).toString();
                String carModelValue = (String) my_carModel.getSelectedItem();
                String carOwnerValue = the_carOwner.getText();
                int myCarPriceValue = Integer.parseInt("" + the_carPrice.getSelectedItem());
                JOptionPane.showMessageDialog(panel2, "The car selected :" + comboValue + "\n Model of the car :" + carModelValue + "\n The owner of the car : " + carOwnerValue + "\n Price of the car :" + myCarPriceValue);
            }
        });
        my_icon_label.setBounds(700, 300, 200, 50);
        panel1.add(my_icon_label);
        panel.add(my_button);
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
        SwingUtilities.invokeLater(() -> new JavaProject());
    }
}
