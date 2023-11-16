import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Car1 {
    private String carModel;
    private String carName;
    private Image carImage;

    public Car1(String carModel, String carName, Image carImage) {
        this.carModel = carModel;
        this.carName = carName;
        this.carImage = carImage;
    }

    public Car1() {
    }

    public Car1(Object model, String name, String image) {
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarName() {
        return carName;
    }

    public Image getCarImage() {
        return carImage;
    }

    public class CarDataGUI extends JFrame {
        private ArrayList<Car1> cars = new ArrayList<>();
        private JComboBox<String> carModelDropdown;
        private JComboBox<String> carNameDropdown;
        private JTextField carPriceField;
        private JTextArea carDataDisplay;
        private JButton addCarButton;
        private JLabel carImageLabel;
        private JPanel outputPanel;

        public CarDataGUI() {
            setTitle("GROUP 7 CAR DATA");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 400);

            // Let's initialize the components of the GUI
            carModelDropdown = new JComboBox<>(new String[]{"Toyota", "Mazda", "Mitsubishi", "Lexus", "ISUZU", "Honda", "Mercedes"});
            carNameDropdown = new JComboBox<>();
            carPriceField = new JTextField(15);
            carDataDisplay = new JTextArea(15, 40);
            carDataDisplay.setEditable(false);
            outputPanel = new JPanel();  // Initialize outputPanel here

            // Creating an action Listener for the car model dropdown
            carModelDropdown.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedModel = (String) carModelDropdown.getSelectedItem();
                    carNameDropdown.removeAllItems();
                    if ("Toyota".equals(selectedModel)) {
                        carNameDropdown.addItem("Landcruiser");
                        carNameDropdown.addItem("Harrier");
                        carNameDropdown.addItem("Probox");
                        carNameDropdown.addItem("Vitz");
                        carNameDropdown.addItem("Alphard");
                    } else if ("ISUZU".equals(selectedModel)) {
                        carNameDropdown.addItem("DMAX");
                        carNameDropdown.addItem("OFFROAD");
                        carNameDropdown.addItem("Wide Load Truck");
                    } else if ("Honda".equals(selectedModel)) {
                        carNameDropdown.addItem("Turbo boost");
                        carNameDropdown.addItem("Civic");
                    } else if ("Mitsubishi".equals(selectedModel)) {
                        carNameDropdown.addItem("Wide load");
                        carNameDropdown.addItem("OFFROAD");
                        carNameDropdown.addItem("FUSO");
                    } else if ("Lexus".equals(selectedModel)) {
                        carNameDropdown.addItem("LX 570");
                        carNameDropdown.addItem("LX 1250");
                        carNameDropdown.addItem("SUV");
                    } else if ("Mazda".equals(selectedModel)) {
                        carNameDropdown.addItem("Demio");
                        carNameDropdown.addItem("Sario");
                        carNameDropdown.addItem("Double Cabin");
                    } else if ("Mercedes".equals(selectedModel)) {
                        carNameDropdown.addItem("G wagon");
                        carNameDropdown.addItem("E class");
                        carNameDropdown.addItem("S class");
                        carNameDropdown.addItem("C class");
                    }

                    carImageLabel = new JLabel();
                    JPanel imagePanel = new JPanel();
                    imagePanel.setBackground(Color.WHITE);
                    imagePanel.add(carImageLabel);
                    outputPanel.add(imagePanel, BorderLayout.WEST);
                }
            });

            addCarButton = new JButton("Add Car");
            addCarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String model = (String) carModelDropdown.getSelectedItem();
                    String name = (String) carNameDropdown.getSelectedItem();

                    if (model.isEmpty() || name.isEmpty()) {
                        JOptionPane.showMessageDialog(CarDataGUI.this, "Error: Please fill all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Create An image to test
                    Image lx570 = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

                    Car1 car = new Car1(model, name,lx570);
                    cars.add(car);
                    updateCarInfoDisplay();
                    updateCarImageDisplay();
                }
            });

            JPanel userDetailsPanel = new JPanel();
            userDetailsPanel.setBackground(Color.pink);

            JPanel userEntryPanel = new JPanel();
            userEntryPanel.setBackground(Color.ORANGE);

            outputPanel.setLayout(new BorderLayout());
            outputPanel.add(carDataDisplay, BorderLayout.CENTER);

            userDetailsPanel.setLayout(new GridLayout(2, 2));
            userDetailsPanel.add(new JLabel("User Details:"));
            userDetailsPanel.add(new JLabel(""));
            userDetailsPanel.add(new JLabel(""));
            userDetailsPanel.add(new JLabel(""));

            userEntryPanel.setLayout(new GridLayout(4, 2));
            userEntryPanel.add(new JLabel("Car Model:"));
            userEntryPanel.add(carModelDropdown);
            userEntryPanel.add(new JLabel("Car Name:"));
            userEntryPanel.add(carNameDropdown);
            userEntryPanel.add(new JLabel("Car Price:"));
            userEntryPanel.add(carPriceField);
            userEntryPanel.add(new JLabel(""));
            userEntryPanel.add(addCarButton);

            // Add panels to the JFrame
            add(userDetailsPanel, BorderLayout.NORTH);
            add(userEntryPanel, BorderLayout.CENTER);
            add(outputPanel, BorderLayout.SOUTH);

            setLocationRelativeTo(null);
            setVisible(true);
        }

        private void updateCarInfoDisplay() {
            carDataDisplay.setText("Car Information:\n");
            for (Car1 car : cars) {
                carDataDisplay.append("Model: " + car.getCarModel() + ", Name: " + car.getCarName() + "\n");
            }
        }

        private void updateCarImageDisplay() {
            Car1 selectedCar = cars.get(cars.size() - 1);
            carImageLabel.setIcon(new ImageIcon(selectedCar.getCarImage()));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Car1 car = new Car1();
            car.new CarDataGUI();
        });
    }
}
