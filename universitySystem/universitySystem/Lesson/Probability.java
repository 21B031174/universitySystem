package universitySystem.Lesson;

import java.io.IOException;

import universitySystem.Faculty.StudentMark;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.classifiers.functions.Logistic;
import weka.core.converters.ConverterUtils.DataSource;

/**
* @generated
*/

public class Probability {
  
  private double retake;
  private double stipendiya;
  private double povyshka;
  
  static double odds;
  static double oddsRatio;
  static double total;
  
  public Probability() throws Exception {
    try {
      DataSource source = new DataSource("C:/Users/Yernar/Desktop/exam.arff");
      
      Instances dataset = source.getDataSet();
      dataset.setClassIndex(dataset.numAttributes() - 1);
      
      Logistic lr = new Logistic();
      lr.buildClassifier(dataset);
      total = dataset.numInstances();
      double[][] coef = lr.coefficients();
      odds = Math.log(coef[1][0]);
      oddsRatio = Math.log((12.0/total) / (18.0/total));
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
  public double getRetake() {
    return this.retake;
    }
    
    public void setRetake(double retake) {
        this.retake = retake;
    }
    
    public double getStipendiya() {
        return this.stipendiya;
    }
    
    public void setStipendiya(double stipendiya) {
        this.stipendiya = stipendiya;
    }
    
    public double getPovyshka() {
        return this.povyshka;
    }
    
    public void setPovyshka(double povyshka) {
        this.povyshka = povyshka;
    }
    
    public double calculateRetake() {
      StudentMark s = new StudentMark();
        this.retake = 1.0 - (Math.exp(oddsRatio + odds * s.calculateFirstAttestation()) / (1 + Math.exp(oddsRatio + odds * s.calculateFirstAttestation())));
        return this.retake * 100;
    }
    
    public double calculateStipendiya() {
      StudentMark s = new StudentMark();
        if (s.calculateFirstAttestation() + s.calculateSecondAttestation() < 30.0) {
          this.stipendiya = 0.0;
        }
        else {
          this.stipendiya = (1 - this.retake) + (this.retake * (Math.exp(oddsRatio + odds * s.calculateSecondAttestation()) / (1 + Math.exp(oddsRatio + odds * s.calculateSecondAttestation()))));
        }
        return this.stipendiya;
    }
    
    public double calculatePovyshka() {
      StudentMark s = new StudentMark();
        if (s.calculateFirstAttestation() + s.calculateSecondAttestation() < 50.0) {
          this.povyshka = 0.0;
        }
        this.povyshka = this.stipendiya + ((1 - this.stipendiya) * (Math.exp(oddsRatio + odds * s.calculateSecondAttestation()) / (1 + Math.exp(oddsRatio + odds * s.calculateSecondAttestation()))));
        return this.povyshka;
    }
    
    
}
