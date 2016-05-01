//UIUC CS125 SPRING 2016 MP. File: RobotLink.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2016-04-18T08:00:20-0500.644631539
/**
 * 
 * @author ywang443
 *
 */
public class RobotLink {

	private RobotLink next; 	
	private final Robot robot;

	public Robot getRobot() {
		return robot;
	}
	/** Constructs this link.
	 * @param next ; the next item in the chain (null, if there are no more items).
	 * @param robot ; a single robot (never null).
	 */
	public RobotLink(RobotLink next,Robot robot) {
		this.robot = robot;
		this.next = next;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int count() {
		if(next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.count();
	}
	/**
	 * Counts the number of flying robots in the linked list.
	 * Hint: robot.isFlying is useful here.
	 */
	public int countFlyingRobots() {
		int count = 0;
		if(robot.isFlying()) 
			count++;
		if(next == null) 
			return count;
		else 
			return count + next.countFlyingRobots();
	}
	/**
	 * Counts the number of flying robots upto and excluding a sad robot.
	 * (i.e. do not count the sad robot if it is flying).
	 * If there are no sad robots this function will return the same value as countFlyingRobots().
	 * Hint: robot.isHappy() is useful.
	 */
	public int countFlyingRobotsBeforeSadRobot() {
		int i = this.countFlyingRobots();
		int count = 0;
		if(!robot.isHappy()) 
			return count;
		if(robot.isFlying()) 
			count++;
		if(next == null) 
			return i;
		return count + next.countFlyingRobotsBeforeSadRobot();
	}
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param robot - the robot value of the new last link
	 */
	public void append(Robot robot) {
		if (next == null) 
			next = new RobotLink(null, this.robot);
		else 
			next.append(robot);
	}
	/**
	 * Returns the first flying unhappy robot, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getFirstFlyingUnhappyRobot() {
		if (robot.isFlying() && !robot.isHappy()) 
			return robot;
		if (next == null) 
			return null;
		return next.getFirstFlyingUnhappyRobot();
	}
	/**
	 * Returns the last flying unhappy robotn the linked list, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getLastFlyingUnhappyRobot() {
		Robot last = null;
		if(next !=  null)
			last = next.getLastFlyingUnhappyRobot();
		if(last == null && robot.isFlying() && !robot.isHappy())
			return robot;
		return last;
	}
	/**
	 * Returns a reference to the happy most distant explorer.
	 * Returns null if there are no happy robots
	 * @return reference to the most distant happy robot
	 */
	public Robot findHappyRobotFurthestFromHome() {
		Robot furthest = robot;
		double dis = robot.getDistanceFromHome();
		if (next != null) {
			dis = Math.max(dis, next.findHappyRobotFurthestFromHome().getDistanceFromHome());
			furthest = (dis == furthest.getDistanceFromHome()) ? furthest : robot;
		}
		return furthest;
	}
	/**
	 * Returns true if linked list contains the robot.
	 * Hint: Use robot.equals(other).
	 * @param robot
	 * @return
	 */
	public boolean contains(Robot other) {
		if(robot.equals(other)) 
			return true;
		if(next == null) 
			return false;
		return next.contains(other);
	}

	
}
