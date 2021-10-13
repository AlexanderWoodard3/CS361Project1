package fa.dfa;
import fa.dfa.DFAInterface;
import fa.FAInterface;
import fa.State;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Deterministic Finite Automaton. Conveniently store a machine's 5-tuple
 * and determine if a language is recognized.
 *
 * @author Alexander Woodard and Quinn Shultz
 */
public class DFA implements DFAInterface, FAInterface {

	// Instance variables populated with real values after Object construction
    private LinkedHashSet<DFAState> Q = new LinkedHashSet<DFAState>();				// States
	private LinkedHashSet<Character> sigma = new LinkedHashSet<Character>();		// Alphabet
	private HashMap<String, DFAState> delta = new HashMap<String, DFAState>();		// Transitions
	private DFAState q0 = null;														// Initial State
	private LinkedHashSet<DFAState> F = new LinkedHashSet<DFAState>();				// Final States

    @Override
    public void addStartState(String name) {
    	q0 = new DFAState(name);
    }

    @Override
    public void addState(String name) {
    	DFAState newState = new DFAState(name);
    	Q.add(newState);
    }

    @Override
    public void addFinalState(String name) {
    	DFAState newState = new DFAState(name);
    	F.add(newState);
    }

    @Override
    public void addTransition(String fromState, char symbol, String toState) {
    	// TODO: Need to store transitions
    }

    @Override
	public Set<? extends State> getStates() {
		return Q;
	}

	@Override
	public Set<? extends State> getFinalStates() {
		return F;
	}

	@Override
	public State getStartState() {
		return q0;
	}

	@Override
	public Set<Character> getABC() {
		return sigma;
	}

    @Override
    public boolean accepts(String s) {
    	// TODO: Need to check if a string is accepted.
        return false;
    }

    @Override
    public DFAState getToState(DFAState from, char onSymb) {
    	// TODO: Need to return transitions
        return q0;
    }

    @Override
    public String toString() {
    	// TODO: Need to Build a String for this DFA
        return "";
    }

    /*  
     * Get States (as a String).
     */
    private String getQ() {
    	// TODO: Return States
        return "";
    }

    /*  
     * Get Alphabet (as a String).
     */
    private String getSigma() {
    	// TODO: Return Alphabet
        return "";
    }

    /*  
     * Get Transitions (as a String).
     */
    private String getDelta() {
    	// TODO: Return Transitions
        return "";
    }

    /*  
     * Get Initial State (as a String).
     */
    private String getQ0() {
        return q0.toString();
    }

    /*  
     * Get Final States (as a String).
     */
    private String getF() {
    	// TODO: Return Final States
        return "";
    }

}
