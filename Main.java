import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Draw a digit (28x28)");
        DrawPanel28x28 drawPanel = new DrawPanel28x28();

        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> drawPanel.clear());

        JButton predictBtn = new JButton("Predict");
        predictBtn.addActionListener(e -> {
            try {
                double[] inputs = drawPanel.getInputVector();

                InputLayer inputLayer = new InputLayer(inputs);

                double[][] hidden1Weights = loadMatrix("D:\\Nerual Network\\src\\Weights\\hiddenLayer1.csv", 784, 128);
                double[] hidden1Bias = loadVector("D:\\Nerual Network\\src\\Bias\\hiddenLayer1.csv", 128);
                HiddenLayer hiddenLayer1 = new HiddenLayer(hidden1Weights, hidden1Bias);

                double[][] outputWeights = loadMatrix("D:\\Nerual Network\\src\\Weights\\outputLayer.csv", 128, 10);
                double[] outputBias = loadVector("D:\\Nerual Network\\src\\Bias\\outputLayer.csv", 10);
                OutputLayer outputLayer = new OutputLayer(outputWeights, outputBias);

                List<HiddenLayer> hiddenLayers = new ArrayList<>();
                hiddenLayers.add(hiddenLayer1);

                NeuralNetwork nn = new NeuralNetwork(inputLayer, hiddenLayers, outputLayer);

                int prediction = nn.predict();
                JOptionPane.showMessageDialog(frame, "Predicted class index: " + prediction);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error loading weights or biases: " + ex.getMessage());
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(clearBtn);
        buttonsPanel.add(predictBtn);

        frame.setLayout(new BorderLayout());
        frame.add(drawPanel, BorderLayout.CENTER);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Your existing loadMatrix and loadVector methods here

    public static double[][] loadMatrix(String filename, int rows, int cols) throws IOException {
        double[][] matrix = new double[rows][cols];
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        int row = 0;
        while ((line = br.readLine()) != null && row < rows) {
            String[] tokens = line.split(",");
            if (tokens.length != cols) {
                throw new IOException("Invalid number of columns at row " + row + ". Expected " + cols + " but found " + tokens.length);
            }
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Double.parseDouble(tokens[col]);
            }
            row++;
        }
        br.close();
        return matrix;
    }

    public static double[] loadVector(String filename, int length) throws IOException {
        double[] vector = new double[length];
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        if (line != null) {
            String[] tokens = line.split(",");
            for (int i = 0; i < tokens.length; i++) {
                vector[i] = Double.parseDouble(tokens[i]);
            }
        }
        br.close();
        return vector;
    }
}
