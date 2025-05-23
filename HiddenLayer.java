public class HiddenLayer {
    private static int layerNumber;

    private int layer;
    private int numberOfNeurons;
    private int prevLayerNumberOfNeurons;
    private double [][] weights;
    private double[] bias;

    HiddenLayer(double[][] weights,double [] bias){
        this.layer=layerNumber++;
        this.prevLayerNumberOfNeurons=weights.length;
        this.numberOfNeurons=weights[0].length;
        this.weights = weights;
        this.bias=bias;
    }


    public double[] forward(double[] input)
    {
        double[] output = new double[numberOfNeurons];

        for(int i=0;i<numberOfNeurons;i++)
        {
            double result=0;
            for(int j=0;j<prevLayerNumberOfNeurons;j++)
            {
                result+=input[j]*weights[j][i];
            }
            result+=bias[i];
            output[i]=sigmoid(result);
        }
        return output;
    }

    private double sigmoid(double num)
    {
        return 1.0 / (1.0 + Math.exp(-num));
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getNumberOfNeurons() {
        return numberOfNeurons;
    }

    public void setNumberOfNeurons(int numberOfNeurons) {
        this.numberOfNeurons = numberOfNeurons;
    }

    public int getPrevLayerNumberOfNeurons() {
        return prevLayerNumberOfNeurons;
    }

    public double[][] getWeights() {
        return weights;
    }
    public void setWeights(double [][] weights)
    {
        this.weights=weights;
    }

    public double[] getWeightsForNeuron(int neuronNumber) {
        double[] neuronWeights = new double[prevLayerNumberOfNeurons];
        for (int i = 0; i < prevLayerNumberOfNeurons; i++) {
            neuronWeights[i] = weights[i][neuronNumber];
        }
        return neuronWeights;
    }


    public double[] getBias() {
        return bias;
    }

    public void setBias(double[] bias) {
        this.bias = bias;
    }

}
