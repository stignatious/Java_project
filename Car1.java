import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Car1 {
    private String car_Model;
    private String car_Name;
    private double car_Price;
    private String car_Owner;

    public Car1(String car_Model, String car_Name, String car_Owner, double car_Price) {
        this.car_Model = car_Model;
        this.car_Name = car_Name;
        this.car_Owner = car_Owner;
        this.car_Price = car_Price;
    }

    public Car1() {
    }

    public String getCar_Model() {
        return car_Model;
    }

    public String getCar_Name() {
        return car_Name;
    }

    public String getCar_Owner() {
        return car_Owner;
    }

    public double getCar_Price() {
        return car_Price;
    }

    public class CarData extends JFrame {
        private ArrayList<Car1> cars = new ArrayList<>();
        private JComboBox<String> car_Modeldropdown;
        private JComboBox<String> car_Namedropdown;
        private JTextField car_Ownerfield;
        private JTextField car_pricefield;
        private JTextArea Car_data_Display;
        private JButton addcarCarButton;

        public CarData() {
            setTitle("GROUP 7 CAR DATA");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 400);

            // Let's initialize the components of the Gui
            car_Ownerfield = new JTextField(15);
            car_Modeldropdown = new JComboBox<>(new String[]{"Toyota","Mazda" , "Mitsubishi","Lexus","ISUZU", "Honda", "Mercedes"});
            car_Namedropdown = new JComboBox<>();
            car_pricefield = new JTextField(15);
            Car_data_Display = new JTextArea(15, 40);
            Car_data_Display.setEditable(false);

            // Creating an action Listener for the car model dropdown
            car_Modeldropdown.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selected_model = (String) car_Modeldropdown.getSelectedItem();
                    car_Namedropdown.removeAllItems();
                    if ("Toyota".equals(selected_model)) {
                        car_Namedropdown.addItem("Landcruiser");
                        car_Namedropdown.addItem("Harrier");
                        car_Namedropdown.addItem("Probox");
                        car_Namedropdown.addItem("vitz");
                        car_Namedropdown.addItem("Alphard");
                    } else if ("ISUZU".equals(selected_model)) {
                        car_Namedropdown.addItem("DMAX");
                        car_Namedropdown.addItem("OFFROAD");
                        car_Namedropdown.addItem("Wide Load Truck");
                    } else if ("Honda".equals(selected_model)) {
                        car_Namedropdown.addItem("Turbo boost");
                        car_Namedropdown.addItem("civic");
                    }else if ("Mitsubishi".equals(selected_model)) {
                        car_Namedropdown.addItem("Wide load");
                        car_Namedropdown.addItem("OFFROAD");
                        car_Namedropdown.addItem("FUSO");
                    }else if ("Lexus".equals(selected_model)) {
                        car_Namedropdown.addItem("LX 570");
                        car_Namedropdown.addItem("LX 1250");
                        car_Namedropdown.addItem("SUV");
                    }else if ("Mazda".equals(selected_model)) {
                        car_Namedropdown.addItem("Demio");
                        car_Namedropdown.addItem("sario");
                        car_Namedropdown.addItem("double cabin");
                    } else if ("Mercedes".equals(selected_model)) {
                        car_Namedropdown.addItem("G wagon");
                        car_Namedropdown.addItem("E class");
                        car_Namedropdown.addItem("S class");
                        car_Namedropdown.addItem("C class");
                    }
                }
            });
	    JLable myImageDisplay = new JLable();
	    carData.this.add(myImageDisplay);
            addcarCarButton = new JButton("Add Car");
            addcarCarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
		    ImageIcon icon = myWindowImage("images.jpeg");
		    myImageDisplay.setIcon(icon)
                    String model = (String) car_Modeldropdown.getSelectedItem();
                    String name = (String) car_Namedropdown.getSelectedItem();
                    String owner = car_Ownerfield.getText();
                    double price = Double.parseDouble(car_pricefield.getText());
                    Car1 car = new Car1(model, name, owner, price);
                    cars.add(car);
                    updateCarInfoDisplay();
                    String priceText = null;
                    if (model.isEmpty() || name.isEmpty() || owner.isEmpty() || priceText.isEmpty()) {
                        JOptionPane.showMessageDialog(CarData.this, "Error: All fields must be filled in.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                    double car_price;
                    try {
                        price = Double.parseDouble(priceText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(CarData.this, "Error: Invalid price format.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Stop processing
                    }
                }
            });

            JPanel userDetailsPanel = new JPanel();
            userDetailsPanel.setBackground(Color.BLUE);

            JPanel userEntryPanel = new JPanel();
            userEntryPanel.setBackground(Color.GREEN);

            JPanel outputPanel = new JPanel();
            outputPanel.setBackground(Color.YELLOW);

            userDetailsPanel.setLayout(new GridLayout(2, 2));
            userDetailsPanel.add(new JLabel("User Details:"));
            userDetailsPanel.add(new JLabel("")); // Placeholder
            userDetailsPanel.add(new JLabel("")); // Placeholder
            userDetailsPanel.add(new JLabel("")); // Placeholder

            userEntryPanel.setLayout(new GridLayout(5, 2));
            userEntryPanel.add(new JLabel("Car Model:"));
            userEntryPanel.add(car_Modeldropdown);
            userEntryPanel.add(new JLabel("Car Name:"));
            userEntryPanel.add(car_Namedropdown);
            userEntryPanel.add(new JLabel("Car Price:"));
            userEntryPanel.add(car_pricefield);
            userEntryPanel.add(new JLabel("Car Owner:"));
            userEntryPanel.add(car_Ownerfield);
            userEntryPanel.add(new JLabel(""));
            userEntryPanel.add(addcarCarButton);

            outputPanel.setLayout(new BorderLayout());
            outputPanel.add(Car_data_Display, BorderLayout.CENTER);

            // Add panels to the JFrame
            add(userDetailsPanel, BorderLayout.NORTH);
            add(userEntryPanel, BorderLayout.CENTER);
            add(outputPanel, BorderLayout.SOUTH);

            setLocationRelativeTo(null);
            setVisible(true);
        }

        private void updateCarInfoDisplay() {
            Car_data_Display.setText("Car Information:\n");
            for (Car1 car : cars) {
                Car_data_Display.append("Model: \n" + car.getCar_Model() + ", Name:\n " + car.getCar_Name() + ", Price: KSH\n" + car.getCar_Price() + ", Owner:\n " + car.getCar_Owner() + "\n");
            }
        }
    }
    public ImageIcon myWindowImage(String path){
	    java.net.Url imagePhoto = getClass().getResources(path);
	    if (imagePhoto != 0){
		    return new ImageIcon(imagePhoto);
	    else {
		    print("The image does not exist"+ path);
	    }
	    }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Car1 car = new Car1();
            car.new CarData();
    }
}
