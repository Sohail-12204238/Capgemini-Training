/**
 * 
 */
package com.capgemini.practice.experiments1;

/**
 * 
 */
public class Solution {
    public static void main(String[] args) {
        RiskModel model = new ValueAtRiskModel(1000000000,5,0);
        try{
            System.out.println(model.calculateRisk());
        }catch(RiskOverflowException e){
            System.out.println("Risk Calculation Failed!");
            System.out.println(e.getMessage());
        }catch(InvalidRiskParameterException e) {
        	System.out.println("Risk Calculation Failed!");
            System.out.println(e.getMessage());
        }
        
    }
}

abstract class RiskModel{
    double exposure;
    double volatility;
    public RiskModel(double exposure,double volatility){
        this.exposure = exposure;
        this.volatility = volatility;
    }
    abstract double calculateRisk() throws InvalidRiskParameterException,RiskOverflowException;
}

class ValueAtRiskModel extends RiskModel{
    double confidenceLevel;
    public ValueAtRiskModel(double exposure,double volatility,double confidenceLevel){
        super(exposure,volatility);
        this.confidenceLevel = confidenceLevel;
    }
    public double calculateRisk() throws InvalidRiskParameterException,RiskOverflowException{
        if(confidenceLevel == 0) throw new RiskOverflowException("Reason : Confidence level cannot be zero.");
        if(confidenceLevel >= Double.MAX_VALUE) throw new RiskOverflowException("Double Max value reached");
        else return (exposure * volatility) / confidenceLevel;
    }
}

class StressTestModel extends RiskModel{
    public StressTestModel(double exposure,double volatility){
        super(exposure,volatility);
    }
    public double calculateRisk() throws InvalidRiskParameterException,RiskOverflowException{
        return exposure*volatility;
    }
}

class RiskCalculationService{
    public void calculate(RiskModel model){
        
    }
}

class InvalidRiskParameterException extends Exception{
    public InvalidRiskParameterException(String message){
        super(message);
    }
}

class RiskOverflowException extends RuntimeException{
    public RiskOverflowException(String message){
        super(message);
    }
}