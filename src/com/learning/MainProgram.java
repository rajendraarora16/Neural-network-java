/**
 * Neural network calculation data
 */
package com.learning;

/**
 *
 * @author Rajendra arora
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][][] data = Perceptron.andData;
        
        double[] weights = Perceptron.INITIAL_WEIGHTS;
        
        MainProgram program = new MainProgram();
        Perceptron perceptron = new Perceptron();
        
        int generationNumber = 0;
        
        boolean errorFlag = true;
        
        double error = 0;
        
        double[] adjustedWeights = null;
        
        while(errorFlag) {
            
            program.printHeading(generationNumber++);
            
            errorFlag = false;
            
            error = 0;
            
            for(int i = 0; i < data.length; i++) {
                
                double weightedSum = perceptron.calculatedWeightSum(data[i][0], weights);
                
                int result = perceptron.applyActivationFunction(weightedSum);
                
                error = data[i][1][0] - result;
                
                if( error != 0 ) {
                    errorFlag = true;
                }
                
                adjustedWeights = perceptron.adjustWeights(data[i][0], weights, error);
                
                program.printVector(data[i], weights, result, error, weightedSum, adjustedWeights);
                
                weights = adjustedWeights;
            }
            
        }
    }
    
    public void printHeading(int generationNumber) {
        System.out.println("\n===============================================Generation: "+generationNumber+"===============================================");
        System.out.println("    W1  |  W2  |  X1  |  X2  |  Target Result  |  Result  |  Error  |  Weighted sum  |  adjusted W1  |  adjusted W2  ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }   
    
    public void printVector(int[][] data, double[] weights, int result, double error, double weightedSum, double[] adjustedWeights) {
        System.out.println("   "+String.format("%.2f", weights[0])+" | "+String.format("%.2f", weights[1])+" |  "+data[0][0]+"   |  "+data[0][1]+"   |       "+data[1][0]+"         |     "+result+"    |   "+error+"   |      "+String.format("%.2f", weightedSum)+"      |     "+String.format("%.2f", adjustedWeights[0])+ "      |     "+String.format("%.2f", adjustedWeights[1]));
                
    }
    
    
}
