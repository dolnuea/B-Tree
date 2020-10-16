import java.util.*;
/**
 * LeafNode class contains the leaf node(s) of the B-tree.
 * @author Luna Dagci
 * */
class LeafNode extends Node{

    //Collection of integers values that the leaf node stores.
    private Collection<Integer> values;

    /**
     * The constructor for the class LeafNode
     * @param values Collection of integer values of nodes
     * */
    LeafNode(Collection<Integer> values) {
        this.values = values;
    }

    /**
     * Getter for values
     * @return values
     * */
    Collection<Integer> getValues() {
        return values;
    }
}