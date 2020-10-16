import java.util.*;
/**
 * The demonstration class: The search class contains the implementation of search functions and demonstration of all test cases
 * @author Luna Dagci
 * */
class Search {

    /**
     * Search method Used in Main Method
     * @param mainroot given root node (tree head) to search through the B-tree
     * @param value given value to search for in the tree
     * @return boolean
     * */
    boolean search(RootNode mainroot, int value) {
        //initial index to traverse through the tree
        return searchTree(mainroot, value, 0); //start searching from index 0
    }
    /**
     * Searches tree starting from root node
     * @param node given root node to start search (the top node of the tree)
     * @param value value to search for in the tree
     * @param i index to traverse through the tree
     * @return boolean value
     * */
    private boolean searchTree(RootNode node, int value, int i){
        //base case: The search in tree is completed or given value is out of tree range return false
         if (i == node.getNodes().size() || value < node.getMin() || value > node.getMax())
            return false;
        //if the node is a root node then search in tree
        else if (((LinkedList<Node>) node.getNodes()).get(i) instanceof RootNode) {
            if ((node.getNodes().size() != i) && (value >= ((RootNode) ((LinkedList<Node>) node.getNodes()).get(i)).getMin()) && (value <= ((RootNode) ((LinkedList<Node>) (node).getNodes()).get(i)).getMax()))
                return searchTree((RootNode)((LinkedList<Node>) node.getNodes()).get(i), value, 0);
            //if node is a leaf node instead then search in subtree
        } else if (((LinkedList<Node>) node.getNodes()).get(i) instanceof LeafNode)
                return searchSubTree((LeafNode) ((LinkedList<Node>) (node).getNodes()).get(i), value, 0);
        return searchTree(node, value, ++i);
    }

    /**
     * Searches Leaf nodes
     * @param node given leaf node for seach
     * @param value value to search for in the tree
     * @param i index for traversing through tree
     * @return boolean value
     * */
    private boolean searchSubTree(LeafNode node, int value, int i){
        //base case: leaf node does not have value or DNE or whole tree has been searched
        if (node.getValues().isEmpty() || i == node.getValues().size() || ((LinkedList<Integer>)node.getValues()).get(i) == null)
            return false;
        //Value found in leaf node
         else if (((LinkedList<Integer>) node.getValues()).get(i) == value && ((LinkedList<Integer>) node.getValues()).get(i) != null)
            return true;
        //leaf node exists but value not found
        else if (((((LinkedList<Integer>) node.getValues()).get(i)) != value) && ((LinkedList<Integer>) node.getValues()).get(i) != null)
            return searchSubTree(node, value, ++i);
        return false;
    }

    /**Helper Functions*/

    /**TEST CASE 1
     * mainroot: 1-1000
     * root nodes & leaves:
     * 1-100: 5 78 92
     * 101-200: 112
     * 201-400: 457 231
     * 401-500: 500
     * 501-1000: 999
     * search for: 112, 78, 15
     * */
    void testcase_1(){
        //Building tree from bottom to top
        //Create Leaves and assign values
        Collection<Integer> leaf_1_values = new LinkedList<Integer>();
        leaf_1_values.add(5);
        leaf_1_values.add(78);
        leaf_1_values.add(92);

        Collection<Integer> leaf_2_values = new LinkedList<Integer>();
        leaf_2_values.add(112);

        Collection<Integer> leaf_3_values = new LinkedList<Integer>();
        leaf_3_values.add(457);
        leaf_3_values.add(231);

        Collection<Integer> leaf_4_values = new LinkedList<Integer>();
        leaf_4_values.add(500);

        Collection<Integer> leaf_5_values = new LinkedList<Integer>();
        leaf_5_values.add(999);

        LeafNode leafNode_1_100 = new LeafNode(leaf_1_values);
        LeafNode leafNode_101_200 = new LeafNode(leaf_2_values);
        LeafNode leafNode_201_400 = new LeafNode(leaf_3_values);
        LeafNode leafNode_401_500 = new LeafNode(leaf_4_values);
        LeafNode leafNode_501_1000 = new LeafNode(leaf_5_values);

        Collection<Node> tree = new LinkedList<Node>(); //top node; contains to whole tree

        Collection<Node> subTree1_100 = new LinkedList<Node>();
        Collection<Node> subTree101_200 = new LinkedList<Node>();
        Collection<Node> subTree201_400 = new LinkedList<Node>();
        Collection<Node> subTree401_500 = new LinkedList<Node>();
        Collection<Node> subTree501_1000 = new LinkedList<Node>();

        //Subtrees containing leaves
        subTree1_100.add(leafNode_1_100);
        subTree101_200.add(leafNode_101_200);
        subTree201_400.add(leafNode_201_400);
        subTree401_500.add(leafNode_401_500);
        subTree501_1000.add(leafNode_501_1000);

        //Build the tree
        //The top notes, root nodes, of subtrees are storing the leaves
        RootNode rootNode501_1000 = new RootNode(501, 1000, subTree501_1000);
        subTree401_500.add(rootNode501_1000);

        RootNode rootNode401_500 = new RootNode(401, 500, subTree401_500);
        subTree201_400.add(rootNode401_500);

        RootNode rootNode201_400 = new RootNode(201, 400, subTree201_400);
        subTree101_200.add(rootNode201_400);

        RootNode rootNode101_200 = new RootNode(101, 200, subTree101_200);
        RootNode rootNode1_100 = new RootNode(1,100, subTree1_100);
        tree.add(rootNode1_100);
        tree.add(rootNode101_200);

        RootNode TopRootNode = new RootNode(1, 1000, tree); //the top root node containing all subtrees

/**Demonstrating Implementation*/
        System.out.println("Searching for values in the B-Tree implementation CASE 1: ");
        System.out.println("Value 112: " +  search(TopRootNode,112));
        System.out.println("Value 78: " +   search(TopRootNode,78));
        System.out.println("Value 15: " +   search(TopRootNode,15));
    }
    /**TEST CASE 2
     * mainroot: 1-1000
     * root nodes & leaves:
     * 1- 100: 13 21 44 77 66
     * 101-200: 111
     * 201-1000: 800 801
     * search for:  800, -1, 44
     * */
    void testcase_2(){
//Building tree from bottom to top
        //Create Leaves and assign values
        Collection<Integer> leaf_1_values = new LinkedList<Integer>();
        leaf_1_values.add(13);
        leaf_1_values.add(21);
        leaf_1_values.add(44);
        leaf_1_values.add(77);
        leaf_1_values.add(66);

        Collection<Integer> leaf_2_values = new LinkedList<Integer>();
        leaf_2_values.add(111);

        Collection<Integer> leaf_3_values = new LinkedList<Integer>();
        leaf_3_values.add(800);
        leaf_3_values.add(801);

        LeafNode leafNode_1_100 = new LeafNode(leaf_1_values);
        LeafNode leafNode_101_200 = new LeafNode(leaf_2_values);
        LeafNode leafNode_201_1000 = new LeafNode(leaf_3_values);

        Collection<Node> tree = new LinkedList<Node>(); //top node

        Collection<Node> subTree1_100 = new LinkedList<Node>();
        Collection<Node> subTree101_200 = new LinkedList<Node>();
        Collection<Node> subTree201_1000 = new LinkedList<Node>();

        //Subtrees containing leaves
        subTree1_100.add(leafNode_1_100);
        subTree101_200.add(leafNode_101_200);
        subTree201_1000.add(leafNode_201_1000);

        //Build the tree
        //The top notes, root nodes, of subtrees are storing the leaves
        RootNode rootNode201_1000 = new RootNode(201, 1000, subTree201_1000);
        tree.add(rootNode201_1000);

        RootNode rootNode101_200 = new RootNode(101, 200, subTree101_200);
        RootNode rootNode1_100 = new RootNode(1,100, subTree1_100);
        tree.add(rootNode1_100);
        tree.add(rootNode101_200);

        RootNode TopRootNode = new RootNode(1, 1000, tree); //the top root node containing all subtrees

/**Demonstrating Implementation*/
        System.out.println("Searching for values in the B-Tree implementation CASE 2: ");
        System.out.println("Value 800: " +  search(TopRootNode,800));
        System.out.println("Value -1: " +   search(TopRootNode,-1));
        System.out.println("Value 44: " +   search(TopRootNode,44));
    }
    /**TEST CASE 3
     * mainroot: 1-1000
     * root nodes & leaves:
     * 1-75: 66
     * 76-301: 200 210 111
     * 302-525: 525
     * 526-800: 800 777
     * 801-1000: 950
     * search for: 210, 117, 525
     * */
    void testcase_3(){
//Building tree from bottom to top
        //Create Leaves and assign values
        Collection<Integer> leaf_1_values = new LinkedList<Integer>();
        leaf_1_values.add(66);

        Collection<Integer> leaf_2_values = new LinkedList<Integer>();
        leaf_2_values.add(200);
        leaf_2_values.add(210);
        leaf_2_values.add(111);

        Collection<Integer> leaf_3_values = new LinkedList<Integer>();
        leaf_3_values.add(525);

        Collection<Integer> leaf_4_values = new LinkedList<Integer>();
        leaf_4_values.add(800);
        leaf_4_values.add(777);

        Collection<Integer> leaf_5_values = new LinkedList<Integer>();
        leaf_5_values.add(950);

        LeafNode leafNode_1_75 = new LeafNode(leaf_1_values);
        LeafNode leafNode_76_301 = new LeafNode(leaf_2_values);
        LeafNode leafNode_302_525 = new LeafNode(leaf_3_values);
        LeafNode leafNode_526_800 = new LeafNode(leaf_4_values);
        LeafNode leafNode_801_1000 = new LeafNode(leaf_5_values);

        Collection<Node> tree = new LinkedList<Node>(); //top node

        Collection<Node> subTree1_75 = new LinkedList<Node>();
        Collection<Node> subTree76_301 = new LinkedList<Node>();
        Collection<Node> subTree302_525 = new LinkedList<Node>();
        Collection<Node> subTree526_800 = new LinkedList<Node>();
        Collection<Node> subTree801_1000 = new LinkedList<Node>();

        //Subtrees containing leaves
        subTree1_75.add(leafNode_1_75);
        subTree76_301.add(leafNode_76_301);
        subTree302_525.add(leafNode_302_525);
        subTree526_800.add(leafNode_526_800);
        subTree801_1000.add(leafNode_801_1000);

        //Build the tree
        //The top notes, root nodes, of subtrees are storing the leaves
        RootNode rootNode801_1000 = new RootNode(801, 1000, subTree801_1000);
        subTree526_800.add(rootNode801_1000);

        RootNode rootNode526_800 = new RootNode(526, 800, subTree526_800);
        subTree302_525.add(rootNode526_800);

        RootNode rootNode302_525 = new RootNode(302, 525, subTree302_525);
        tree.add(rootNode302_525);

        RootNode rootNode76_301 = new RootNode(76, 301, subTree76_301);
        RootNode rootNode1_75 = new RootNode(1,75, subTree1_75);
        tree.add(rootNode1_75);
        tree.add(rootNode76_301);

        RootNode TopRootNode = new RootNode(1, 1000, tree); //the top root node containing all subtrees

/**Demonstrating Implementation*/
        //  Search tree = new Search(); //Searching object used as a search tool
        System.out.println("Searching for values in the B-Tree implementation CASE 3: ");
        System.out.println("Value 210: " +  search(TopRootNode,210));
        System.out.println("Value 117: " +   search(TopRootNode,117));
        System.out.println("Value 525: " +   search(TopRootNode,525));
    }

    /**
     * The main method to demonstrate test cases*/
    public static void main(String[] args) {
        Search demonstrateTestCases = new Search(); //search tool to demonstrate test cases and implementation of search methods
        demonstrateTestCases.testcase_1();
        demonstrateTestCases.testcase_2();
        demonstrateTestCases.testcase_3();
    }
}
