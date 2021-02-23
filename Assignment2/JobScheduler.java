package Assignment2;


import java.util.Scanner;

public class JobScheduler {
	private int processArrivalBurstTime[][];
	int processCount;
	int indexArrival = 0;
	int indexBurst = 1;

	/**
	 * @param processArrivalBurstTime
	 * @param processCount
	 */
	public JobScheduler(int[][] processArrivalBurstTime, int processCount) {
		this.processArrivalBurstTime = processArrivalBurstTime;
		this.processCount = processCount;
	}

	/**
	 * This function is used to calculate Waiting Time of all process.
	 * 
	 * @return int[] Waiting Time of all process
	 */
	int[] getWaitingTime() {
		int waitingTime[] = new int[processCount];
		int serviceTime[] = new int[processCount];
		int wastedTime = 0;
		for (int i = 1; i < processCount; i++) {
			serviceTime[i] = serviceTime[i - 1]
					+ processArrivalBurstTime[i - 1][indexBurst];
			waitingTime[i] = serviceTime[i]
					- processArrivalBurstTime[i][indexArrival];
			if (waitingTime[i] < 0) {
				wastedTime = -1 * waitingTime[i];
				waitingTime[i] = 0;
			}
			serviceTime[i] += wastedTime;

		}
		return waitingTime;

	}

	/**
	 * This function is used to calculate Turn Around Time of all process.
	 * 
	 * @return int[] Turn Around Time of all process
	 */
	int[] getTurnAroundTime() {
		int turnAroundTime[] = new int[processCount];
		int waitingTime[] = getWaitingTime();

		for (int i = 0; i < processCount; i++) {
			turnAroundTime[i] = waitingTime[i]
					+ processArrivalBurstTime[i][indexBurst];
		}
		return turnAroundTime;
	}

	/**
	 * This function is used to calculate Completion Time of all process.
	 * 
	 * @return int[] Completion Time of all process
	 */
	int[] getCompletionTime() {
		int completionTime[] = new int[processCount];
		int turnAroundTime[] = getTurnAroundTime();
		for (int i = 0; i < processCount; i++) {
			completionTime[i] = turnAroundTime[i]
					+ processArrivalBurstTime[i][indexArrival];
		}
		return completionTime;
	}

	/**
	 * This function is used to calculate Average waiting time of a process.
	 * 
	 * @return float Average waiting time
	 */
	float getAverageWaitingTime() {
		float averageWaitingTime = 0;
		int waitingTime[] = getWaitingTime();
		for (int i = 0; i < processCount; i++) {
			averageWaitingTime += waitingTime[i];
		}
		averageWaitingTime = (float) averageWaitingTime / (float) processCount;
		return averageWaitingTime;
	}

	/**
	 * This function is used to calculate maximum waiting time of a process.
	 * 
	 * @return int maximum waiting time
	 */
	int getMaxWaitingTime() {
		int maxWaitingTime = 0;
		int waitingTime[] = getWaitingTime();
		for (int i = 0; i < processCount; i++) {
			if (maxWaitingTime < waitingTime[i]) {
				maxWaitingTime = waitingTime[i];
			}
		}
		return maxWaitingTime;
	}

	/**
	 * This function is used to print array elements on console.
	 * 
	 * @param array
	 *            This parameter contains the array data to be print on console.
	 * @return nothing
	 */
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1]);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int processTimes[][] = { { 0, 10 }, { 6, 20 }, { 60, 10 }, { 110, 5 } };
		
		JobScheduler jobScheduler = new JobScheduler(processTimes,
				processTimes.length);

		int choice;
		while (true) {
			System.out.println("1] Calculate Completion Time");
			System.out.println("2] Calculate Waiting Time");
			System.out.println("3] Calculate Turn around Time");
			System.out.println("4] Calculate Average Waiting Time");
			System.out.println("5] Calculate Maximum Waiting Time");
			System.out.println("6] Exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				int completionTime[] = jobScheduler.getCompletionTime();
				printArray(completionTime);
				break;
			case 2:
				int waitingTime[] = jobScheduler.getWaitingTime();
				printArray(waitingTime);

				break;
			case 3:
				int[] turnAroundtime = jobScheduler.getTurnAroundTime();
				printArray(turnAroundtime);
				break;
			case 4:
				System.out.println(jobScheduler.getAverageWaitingTime());
				break;
			case 5:
				System.out.println(jobScheduler.getMaxWaitingTime());
				break;
			case 6:
				System.exit(0);
			default:
				break;
			}
		}
		
	}

}
