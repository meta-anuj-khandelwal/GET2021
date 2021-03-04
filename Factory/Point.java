package Factory;

/**
 * <h1>Point</h1>
 * <p>
 * This class is used to denote a coordinate on screen
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-03
 */
public class Point {
	private int xCordintor;

	private int yCordintor;

	/**
	 * @param xCordintor
	 * @param yCordintor
	 */
	public Point(int xCordintor, int yCordintor) {
		super();
		this.xCordintor = xCordintor;
		this.yCordintor = yCordintor;
	}

	public Point getPoint() {
		return this;
	}

	/**
	 * @return the xCordintor
	 */
	public int getxCordintor() {
		return xCordintor;
	}

	/**
	 * @param xCordintor
	 *            the xCordintor to set
	 */
	public void setxCordintor(int xCordintor) {
		this.xCordintor = xCordintor;
	}

	/**
	 * @return the yCordintor
	 */
	public int getyCordintor() {
		return yCordintor;
	}

	/**
	 * @param yCordintor
	 *            the yCordintor to set
	 */
	public void setyCordintor(int yCordintor) {
		this.yCordintor = yCordintor;
	}

	public double distanceFromOrigin() {
		double distance = Math.sqrt(Math.pow(xCordintor, 2)
				+ Math.pow(yCordintor, 2));
		return distance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Point [xCordintor=" + xCordintor + ", yCordintor=" + yCordintor
				+ "]";
	}

	public double calculateDistance(Point pt) {
		double distance = Math.sqrt(Math.pow(
				pt.getxCordintor() - this.getxCordintor(), 2)
				+ Math.pow(pt.getyCordintor() - this.getyCordintor(), 2));
		return distance;
	}
}
