package fa.dfa;
import fa.dfa.DFAInterface;
import fa.FAInterface;
import fa.State;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

/**
 * Deterministic Finite Automaton. Conveniently store a machine's 5-tuple
 * and determine if a language is recognized.
 *
 * @author Alexander Woodard and Quinn Shultz
 */
public class DFA implements DFAInterface, FAInterface {

	// Instance variables populated with real values after Object construction
    private LinkedHashSet<DFAState> Q;				// States
	private LinkedHashSet<Character> sigma;		    // Alphabet
	private HashMap<String, DFAState> delta;		// Transitions
	private DFAState q0;							// Initial State
	private LinkedHashSet<DFAState> F;				// Final States

    public DFA() {
        Q = new LinkedHashSet<DFAState>();
        sigma = new LinkedHashSet<Character>();
        delta = new HashMap<String, DFAState>();
        q0 = null;
        F = new LinkedHashSet<DFAState>();
    }

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
    	String keyString = fromState + symbol;
		DFAState transState = null;

		for(DFAState state: Q) {
			if(state.toString().equals(toState)) {
				transState = state;
			}
		}

		delta.put(keyString, transState);

		if(!sigma.contains(symbol)) {
			sigma.add(symbol);
		}
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
    	boolean accepts = true;
		DFAState currState = q0;

		// run through the string to see if it is valid
		for(int i = 0; i < s.length(); i++) {
			// if the character is in the alphabet
			if(sigma.contains(s.charAt(i))){
				// get the state it takes us to from current state
				currState = getToState(currState, s.charAt(i));
			} else if(s.charAt(i) == 'e') {
				accepts = true;
				break;
			} else {
				// otherwise, we don't accept the string & break the loop
				accepts = false;
				break;
			}
        
        }

		// if we made it through the loop, and the current state is a final state
		if(accepts && F.contains(currState)) {
			// we accept the string
			accepts = true;
		} else {
			// we reject the string
			accepts = false;
		}

		return accepts;

    }

    @Override
    public DFAState getToState(DFAState from, char onSymb) {
    	DFAState nextState = delta.get(from.toString() + onSymb);
        return nextState;
    }

    @Override
    public String toString() {
    	StringBuilder str = new StringBuilder();
    	str.append(getQ());
    	str.append("\n");
    	str.append(getSigma());
    	str.append("\n");
    	str.append(getDelta());
    	str.append("\n");
    	str.append(getQ0());
    	str.append("\n");
    	str.append(getF());
        return str.toString();
    }

    /*  
     * Get States (as a String).
     */
    private String getQ() {
    	StringBuilder str = new StringBuilder();
    	Iterator<DFAState> iter = Q.iterator();
    	
    	str.append("Q = { ");
    	while (iter.hasNext()) {
    		str.append(iter.next());
    		str.append(" ");
    	}
    	str.append("}");
    	
        return str.toString();
    }

    /*  
     * Get Alphabet (as a String).
     */
    private String getSigma() {
    	StringBuilder str = new StringBuilder();
    	Iterator<Character> iter = sigma.iterator();
    	
    	str.append("Sigma = { ");
    	while (iter.hasNext()) {
    		str.append(iter.next());
    		str.append(" ");
    	}
    	str.append("}");
    	
        return str.toString();
    }

    /*  
     * Get Transitions (as a String).
     */
    private String getDelta() {
    	String transTable = "delta = \n";
        transTable += "\t\t";

        for(Character c: sigma) {
            transTable += c + "\t";
        }
        
        transTable += "\n";

        for(DFAState s: Q) {
            transTable += "\t" + s.toString();
            for(Character c: sigma) {
                transTable += "\t" + delta.get(s.toString() + c).toString();
            }

            transTable += "\n";

        }

        return transTable;

    }

    /*  
     * Get Initial State (as a String).
     */
    private String getQ0() {
    	StringBuilder str = new StringBuilder();
    	str.append("q0 = ");
    	str.append(q0.toString());
        return str.toString();
    }

    /*  
     * Get Final States (as a String).
     */
    private String getF() {
    	StringBuilder str = new StringBuilder();
    	Iterator<DFAState> iter = F.iterator();
    	
    	str.append("F = { ");
    	while (iter.hasNext()) {
    		str.append(iter.next());
    		str.append(" ");
    	}
    	str.append("}");
    	
        return str.toString();
    }

}