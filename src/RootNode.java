import java.util.*;
/**
 * RootNode class contains the top node of the tree.
 * @author Luna Dagci
 */
class RootNode extends Node {

    //The min(start) of the range of values for the RootNode
    private int min;

    //The max(end) of the range of values for the RootNode
    private int max;

    //The collection of child nodes for the root node.
   // private Collection<Node> nodes;
    private Collection<Node> nodes;

    /**
     * The constructor for the class RootNode
     * @param min the start of the range of values
     * @param max the end of the range of values
     * @param nodes the collection of child nodes of the root node
     */
    public RootNode(int min, int max, Collection<Node> nodes) {

        this.min = min; //start
        this.max = max; //end
        this.nodes = nodes;
    }

    /**
     * Getter for min
     * @return min
     * */
    int getMin() {
        return min;
    }

    /**
     * Getter for max
     * @return max
     * */
    int getMax() {
        return max;
    }

    /**
     * Getter for collection of nodes
     * @return nodes
     * */
    Collection<Node> getNodes() {
        return nodes;
    }
}