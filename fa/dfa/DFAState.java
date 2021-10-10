package fa.dfa;
import fa.State;

/**
 * creates a state for a DFA
 * The state object has a name.
 * 
 * @author Alexander Woodard and Quinn Shultz
 *
 */
public class DFAState extends State {
	
    private String name;
	
	/**
	 * Creates a state that has a unique name.
	 * @param name - the name of the state
	 */
	public DFAState(String name ) {
		this.name = name;
	}

	public String toString() {
		return name;
	}	
}