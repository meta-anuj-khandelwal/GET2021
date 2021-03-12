package problem3;

public class BowlerOrder {
	private PriorityQueue<Bowler> bowlerPriorityQueue;

	/**
	 * 
	 * @param bowlerCount
	 *            number of bowlers to be add in queue
	 */
	public BowlerOrder(int bowlerCount) {
		this.bowlerPriorityQueue = new BowlerPriorityQueue(bowlerCount);
	}

	/**
	 * add bowler in queue
	 * 
	 * @param bowler
	 *            bowlers to be add in queue
	 * @return boolean true if bowler added successfully in queue else false.
	 */
	public boolean addBowler(Bowler bowler) {
		return bowlerPriorityQueue.enQueue(bowler);
	}

	/**
	 * This function used to get order of bowler with remaining ball in String
	 * format
	 * 
	 * @param totalBallViratPlay
	 *            number of balls virat is going to play
	 * @return order of bowler with remaining ball in String format
	 */
	public String getBowlerOrder(int totalBallViratPlay) {
		String bowlerOrder = new String();
		while (totalBallViratPlay != 0 && !bowlerPriorityQueue.isEmpty()) {
			// dequeue high priority bowler from queue
			Bowler bowler = bowlerPriorityQueue.deQueue();
			// decrease high priority bowler's remaining ball by 1
			bowler.decreaseBallCount();
			bowlerOrder += (bowler.getName() + "\t" + bowler.getBallCount() + "\n");
			if (bowler.getBallCount() != 0) {
				bowlerPriorityQueue.enQueue(bowler);
			}
			// decreasing number of balls remaining for virat
			totalBallViratPlay--;
		}
		return bowlerOrder;
	}

	/**
	 * This function used to get order of bowler ball in String format
	 * 
	 * @param totalBallViratPlay
	 *            number of balls virat is going to play
	 * @return order of bowler in String format
	 */
	public String getOrder(int totalBallViratPlay) {
		String bowlerOrder = new String();
		while (totalBallViratPlay != 0 && !bowlerPriorityQueue.isEmpty()) {
			// dequeue high priority bowler from queue
			Bowler bowler = bowlerPriorityQueue.deQueue();
			// decrease high priority bowler's remaining ball by 1
			bowler.decreaseBallCount();
			bowlerOrder += (bowler.getName());
			if (bowler.getBallCount() != 0) {
				bowlerPriorityQueue.enQueue(bowler);
			}
			// decreasing number of balls remaining for virat
			totalBallViratPlay--;
		}
		return bowlerOrder;
	}
}
