package fa.dfa;
import fa.dfa.DFAInterface;
import fa.FAInterface;
import fa.State;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * Description needs to be written
 * 
 * @author Alexander Woodard and Quinn Shultz
 */
public class DFA implements DFAInterface, FAInterface {

    private LinkedHashSet<DFAState> Q;
	private LinkedHashSet<Character> sigma;
	private HashMap<String, DFAState> delta;
	private DFAState q0;
	private LinkedHashSet<DFAState> F;

    /* Description needs to be written */
    public DFA() {
		Q = new LinkedHashSet<DFAState>();
		sigma = new LinkedHashSet<Character>();
		delta = new HashMap<String, DFAState>();
		q0 = null;
		F = new LinkedHashSet<DFAState>();
	}

    @Override
    public void addStartState(String name) {

    }

    @Override
    public void addState(String name) {

    }

    @Override
    public void addFinalState(String name) {

    }

    @Override
    public void addTransition(String fromState, char symbol, String toState) {

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
        return;
    }

    @Override
    public DFAState getToState(DFAState from, char onSymb) {
        return;
    }

    @Override
    public String toString() {
        return;
    }

    /* Description needs to be written */
    private String getQ() {
        return;
    }

    /* Description needs to be written */
    private String getSigma() {
        return;
    }

    /* Description needs to be written */
    private String getDelta() {
        return;
    }

    /* Description needs to be written */
    private String getQ0() {
        return;
    }

    /* Description needs to be written */
    private String getF() {
        return;
    }

}