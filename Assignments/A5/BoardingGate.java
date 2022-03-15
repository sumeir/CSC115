// Sumeir Khinda, V00933760
// I took this course in Spring 2020 as well, and this assignment is the exact same as one of the older assignments. If there is any similarity between 
// my implementations, it is purely due to me thinking about the solution the same way this time (which is very likely to happen), not copying from my earlier work. 

/*
 * represents a transit boarding gate (train, airplane, etc.)
 */

public class BoardingGate {
    
    private PriorityQueue passengers;
    
    /* 
     * constructor that initializes passengers to a default-sized priority queue
     */
	public BoardingGate() {
		passengers = new HeapPriorityQueue(10000);
	}
    
    /* 
     * constructor that initializes passengers to a priority queue of given size
     */
	public BoardingGate(int size) {
		passengers = new HeapPriorityQueue(size);
	}

    
    /* addPassenger
     * PURPOSE:
     *  add given Passenger p to passengers and
     *  prints a notification message if passengers is full
     *
     * PARAMETERS:
     *  Passenger p - Passenger to be added
     *
     * RETURNS:
     *  None.
     */
	public void addPassenger(Passenger p) {
		try {
            passengers.insert(p);
        } catch (HeapFullException e) {
            System.out.println("Boarding gate full!");
        }
	}
    
    
    /* numPassengersWaiting
     * PURPOSE:
     *  returns the number of Passengers in passengers waiting to board
     *
     * PARAMETERS:
     *  None.
     *
     * RETURNS:
     *  int - number of passengers waiting to board
     */
	public int numPassengersWaiting() {
        return passengers.size();
	}
    
    
    /* nextPassenger
     *
     * PURPOSE:
     *  removes and returns the next Passenger from passengers
     *
     * PARAMETERS:
     *  None.
     *
     * RETURNS:
     *  Passenger - the next Passenger, null if there is no more Passengers.
     */
	public Passenger nextPassenger() {
		if (passengers.size()>0) {
            Passenger p = (Passenger)(passengers.removeMin());
            return p;
        } else {
            return null;
        }
	}
}

