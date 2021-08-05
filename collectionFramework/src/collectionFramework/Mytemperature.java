package collectionFramework;

public class Mytemperature implements Temperature {
	private double celsius,fahrenheit;

	public Mytemperature(double value, char scale) {
		if (scale == 'C')
			setCelsius(value);
		else
			setFahrenheit(value);
	}

	public double getCelsius() {
		return Math.round(celsius*100)/100.0;
	}

	public double getFahrenheit() {
		return Math.round(fahrenheit*100)/100.0;
	}
	
	public void setCelsius(double celsius) {
		this.fahrenheit = 9*celsius/5 + 32;
	}
	
	public void setFahrenheit(double fahrenheit) {
		this.celsius = (fahrenheit - 32.0) * 5/9;
		
	}
	

}
