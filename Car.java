import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Creating the class Car

public class Car {
    private String car_Model;
    private String car_Name;
    private double car_Price;
    private String car_Owner;

    public Car(String car_Model, String car_NAme, String car_Owner, double car_Price) {
        this.car_Model = car_Model;
        this.car_Name = car_NAme;
        this.car_Owner = car_Owner;
        this.car_Price = car_Price;


    }

    public Car() {

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
        private ArrayList<Car> cars = new ArrayList<>();
        private JComboBox<String> car_Modeldropdown;
        private JComboBox<String> car_Namedropdown;
        private JTextField car_Ownerfield;
        private JTextField car_pricefield;
        private JTextArea Car_data_Display;

        //Creating A carData Gui

        public CarData() {
            setTitle("GROUP 7 CAR DATA");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 400);

            // Let's initialize the components of the Gui
            car_Ownerfield = new JTextField(15);
            car_Modeldropdown = new JComboBox<>(new String[]{"Toyota", "ISUZU", "Honda", "Mercedes"});
            car_Namedropdown = new JComboBox<>();
            car_pricefield = new JTextField(15);
            Car_data_Display = new JTextArea(15, 40);
            Car_data_Display.setEditable(false);

            //Create an action Listener for the car model dropdown
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
                    } else if ("Mercerdes".equals(selected_model)) {
                        car_Namedropdown.addItem("G wagon");
                        car_Namedropdown.addItem("E class");
                        car_Namedropdown.addItem("S class");
                        car_Namedropdown.addItem("C class");
                    }

                }
            });
            JButton addcarCarButton = new JButton("Add Car");
            addcarCarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String model = (String) car_Modeldropdown.getSelectedItem();
                    String name = (String) car_Namedropdown.getSelectedItem();
                    String owner = car_Ownerfield.getText();
                    double price = Double.parseDouble(car_pricefield.getText());
                    Car car = new Car(model, name, owner, price);
                    cars.add(car);
                    updateCarInfoDisplay();
                }
            });

            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new GridLayout(5, 2));
            inputPanel.add(new JLabel("Car Model:"));
            inputPanel.add(car_Modeldropdown);
            inputPanel.add(new JLabel("Car Name:"));
            inputPanel.add(car_Namedropdown);
            inputPanel.add(new JLabel("Car Price:"));
            inputPanel.add(car_pricefield);
            inputPanel.add(new JLabel("Car Owner:"));
            inputPanel.add(car_Ownerfield);
            inputPanel.add(new JLabel(""));
            inputPanel.add(addcarCarButton);

            add(inputPanel, BorderLayout.NORTH);
            add(Car_data_Display, BorderLayout.CENTER);

            setLocationRelativeTo(null);
            setVisible(true);
        }

        private void updateCarInfoDisplay() {
            Car_data_Display.setText("Car Information:\n");
            for (Car car : cars) {
                Car_data_Display.append("Model: " + car.getCar_Model() + ", Name: " + car.getCar_Name() + ", Price: $" + car.getCar_Price() + ", Owner: " + car.getCar_Owner() + "\n");
            }
        }
    }
    //   public static void main(String[] args) {
    //     SwingUtilities.invokeLater(Car::new);
    //}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Car car = new Car();
            car.new CarData();
        });
    }
}