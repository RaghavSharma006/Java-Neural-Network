import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeuralNetwork {
    private InputLayer inputLayer;
    private List<HiddenLayer> hiddenLayers;
    private OutputLayer outputLayer;

    public NeuralNetwork(InputLayer inputLayer, List<HiddenLayer> hiddenLayers, OutputLayer outputLayer) {
        this.inputLayer = inputLayer;
        this.hiddenLayers = hiddenLayers;
        this.outputLayer = outputLayer;
    }

    public int predict() {
        double[] currentOutput = inputLayer.getNeuronsValue();

        for (HiddenLayer layer : hiddenLayers) {
            currentOutput = layer.forward(currentOutput);
        }

        return outputLayer.predict(currentOutput);
    }

    // Optionally, you can set new inputs
    public void setInput(double[] newInput) {
        inputLayer.setNeuronsValue(newInput);
    }
}
