package universitySystem.Faculty;

/**
* @generated
*/

public class Mark {
    
    private double point;
    
    public Mark(double point){
        this.point = point;
       }
    
    public double getPoint() {
        return this.point;
    }
    
    public void setPoint(double point) {
        this.point = point;
    }
    
    public String letterEquivalent(double p) {
    	
    	String s = "";
    	
    	int[] points = {0, 49, 50, 54, 55, 59, 60, 64, 65, 69, 70, 74, 75, 79, 80, 84, 85, 89, 90, 94, 95, 100};
		String[] grades = {"F", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A"};
		
		for (int i = 0; i < points.length; i = i + 2) {
			if (p >= points[i] && p <= points[i+1]) {
				s = grades[i/2];
			}
		}
		return s;
    }
    
    
}
