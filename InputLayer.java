public class InputLayer {
    private int neurons;
    private double[] neuronsValue;

    InputLayer(double[] neuronsValue)
    {
        neurons = neuronsValue.length;
        this.neuronsValue = neuronsValue;
    }

    public double[] getNeuronsValue() {
        return neuronsValue;
    }

    public void setNeuronsValue(double[] neuronsValue) {
        neurons = neuronsValue.length;
        this.neuronsValue = neuronsValue;
    }
    public int getNeurons() {
        return neurons;
    }
}
