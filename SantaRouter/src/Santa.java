
public class Santa {
	
	private final double secondsPerPresent;

	public Santa(double timePerPresent) {
		this.secondsPerPresent = timePerPresent;
	}

	public double deliveryTimeHours(int presents) {
		return (presents * secondsPerPresent) / 3600;
	}
}