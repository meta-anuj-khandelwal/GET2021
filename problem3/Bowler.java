package problem3;

public class Bowler implements Comparable<Bowler> {
	// name of bowler
	String name;
	// count of ball for a bowler
	int ballCount;

	/**
	 * @param name
	 *            name of bowler
	 * @param ballCount
	 *            count of ball for a bowler
	 */
	public Bowler(String name, int ballCount) {
		this.name = name;
		this.ballCount = ballCount;
	}

	/**
	 * @return the name of bowler
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ballCount
	 */
	public int getBallCount() {
		return ballCount;
	}

	/**
	 * @param ballCount
	 *            the ballCount to set
	 */
	public void decreaseBallCount() {
		this.ballCount--;
	}

	/**
	 * @param bowler
	 *            Bowler to be compared with this bowler based on remaining
	 *            balls
	 */
	@Override
	public int compareTo(Bowler bowler) {
		// TODO Auto-generated method stub
		return this.ballCount - bowler.ballCount;
	}

}
