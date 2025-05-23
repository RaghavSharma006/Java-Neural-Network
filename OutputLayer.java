public class OutputLayer {
        private int neurons;
        private int prevLayerNumberOfNeurons;
        private double [][] weights;
        private double[] bias;

        OutputLayer(double[][] weights, double [] bias){
            this.neurons=weights[0].length;
            this.prevLayerNumberOfNeurons =weights.length;
            this.weights = weights;
            this.bias=bias;
        }


        public int predict(double[] input)
        {
            double answer=Double.MIN_VALUE;
            int predictedIndex=-1;

            for(int i=0;i<neurons;i++)
            {
                double result=0;
                for(int j=0;j<prevLayerNumberOfNeurons;j++)
                {
                    result+=input[j]*weights[j][i];
                }
                result+=bias[i];
                result=sigmoid(result);
                if(result>answer) {
                    answer = result;
                    predictedIndex=i;
                }
            }
            return predictedIndex;
        }
    public double[] predictArray(double[] input)
    {
        double answer=Double.MIN_VALUE;
        int predictedIndex=-1;
        double[]output = new double[neurons];

        for(int i=0;i<neurons;i++)
        {
            double result=0;
            for(int j=0;j<prevLayerNumberOfNeurons;j++)
            {
                result+=input[j]*weights[j][i];
            }
            result+=bias[i];
            result=sigmoid(result);
            output[i]=result;
        }
        return output;
    }

        private double sigmoid(double num)
        {
            return 1.0 / (1.0 + Math.exp(-num));
        }

        public int getNeurons() {
            return neurons;
        }

        public void setNeurons(int numberOfNeurons) {
            this.neurons = numberOfNeurons;
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

        public double[] getWeights(int neuronNumber) {
            return weights[neuronNumber];
        }

        public void setWeights(int neuronNumber,double[] weights) {
            this.weights[neuronNumber] = weights;
        }

        public double[] getBias() {
            return bias;
        }

        public void setBias(double[] bias) {
            this.bias = bias;
        }

        public void setBias(double bias , int index){
            this.bias[index]=bias;
        }

        public double getBias(int index) {
            return this.bias[index];
        }
}
