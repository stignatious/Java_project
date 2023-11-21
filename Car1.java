import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// CREATE A FRAME FOR THE USER GUI
public class Car1 extends JFrame {
    private ArrayList<Car> cars = new ArrayList<>();
    private JComboBox<String> carModelDropdown;
    private JTextField carNameField;
    private JTextField carOwnerField;
    private JTextField carPriceField;
    private JTextArea carDataDisplay;
    private JButton addCarButton;
    private JLabel carImageLabel;

    public Car1() {
        setTitle("GROUP 7 CAR MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        carModelDropdown = new JComboBox<>(new String[]{"JAGUAR", "FORD", " PAGANI","PORSCHE","SUBARU", "Toyota", "Mazda", "Mitsubishi", "Lexus", "ISUZU", "Honda", "Mercedes"});
        carNameField = new JTextField(15);
        carOwnerField = new JTextField(15);
        carPriceField = new JTextField(15);
        carDataDisplay = new JTextArea(15, 40);
        carDataDisplay.setEditable(false);
        addCarButton = new JButton("SUBMIT CAR DETAILS");
        carImageLabel = new JLabel();

        carModelDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCarImageDisplay();  // Update the car image when the car model is selected
            }
        });

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });

        setLayout(new BorderLayout());
        add(createUserDetailsPanel(), BorderLayout.NORTH);
        add(createUserEntryPanel(), BorderLayout.CENTER);
        add(createOutputPanel(), BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createUserDetailsPanel() {
        JPanel userDetailsPanel = new JPanel();
        userDetailsPanel.setBackground(Color.pink);
        userDetailsPanel.setLayout(new GridLayout(4, 2));
        userDetailsPanel.add(new JLabel("Car Model:"));
        userDetailsPanel.add(carModelDropdown);
        userDetailsPanel.add(new JLabel("Car Name:"));
        userDetailsPanel.add(carNameField);
        userDetailsPanel.add(new JLabel("Car Owner:"));
        userDetailsPanel.add(carOwnerField);
        userDetailsPanel.add(new JLabel("Add Price:"));
        userDetailsPanel.add(carPriceField);
        return userDetailsPanel;
    }

    private JPanel createUserEntryPanel() {
        JPanel userEntryPanel = new JPanel();
        userEntryPanel.setBackground(Color.ORANGE);
        userEntryPanel.setLayout(new FlowLayout());
        userEntryPanel.add(addCarButton);
        userEntryPanel.add(carImageLabel);  // Add the JLabel for displaying the car image
        return userEntryPanel;
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.BLUE);
        outputPanel.add(new JScrollPane(carDataDisplay));
        return outputPanel;
    }

    private void addCar() {
        String model = (String) carModelDropdown.getSelectedItem();
        String name = carNameField.getText();
        String owner = carOwnerField.getText();
        String price = carPriceField.getText();

        // Restricting the car price to integer data type only
        try{
            Integer.parseInt(price);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Car price can only contain didgits between 0 - 9", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (model.isEmpty() || name.isEmpty() || owner.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Please fill all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

// Here is the section for getting the Selected car image path
        ImageIcon placeholderIcon = new ImageIcon(new ImageIcon("C:\\Users\\Son Of Nations\\Downloads\\Project photos").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        Car car = new Car(model, name, owner, price);
        cars.add(car);
        updateCarInfoDisplay();
        updateCarImageDisplay(placeholderIcon);
    }

    private void updateCarInfoDisplay() {
        carDataDisplay.setText("Car Information:\n");
        for (Car car : cars) {
            carDataDisplay.append("Model: \n" + car.getCarModel()  + ", Name:\n " + car.getCarName() +
                    ", Owner: \n" + car.getCarOwner() + ", Price: \n" + car.getCarPrice() + "\n");
        }
    }
// update the car image display
    private void updateCarImageDisplay(ImageIcon icon) {
        carImageLabel.setIcon(icon);
    }

    private void updateCarImageDisplay() {
        // Implement the logic to update the car image based on the selected car model

        ImageIcon placeholderIcon = new ImageIcon(new ImageIcon("C:\\Users\\Son Of Nations\\Downloads\\Project photos").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        updateCarImageDisplay(placeholderIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Car1());
    }
}

class Car {
    private String carModel;
    private String carName;
    private String carOwner;
    private String carPrice;

    public Car(String carModel, String carName, String carOwner, String carPrice) {
        this.carModel = carModel;
        this.carName = carName;
        this.carOwner = carOwner;
        this.carPrice = carPrice;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public String getCarPrice() {
        return carPrice;
    }
}
