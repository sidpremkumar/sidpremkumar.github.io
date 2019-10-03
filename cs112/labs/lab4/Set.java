package hw3;
//Make sure to copy/paste the honor code and fill in all the required details.
//If you do not complete the honor code, your assignment will not get marked.


public class Set  {

    private int SIZE = 10;        // initial length of the array

    private int[] S;              // array holding the set

    private int next;             // pointer to next available slot in array


    /*
     * DO NOT MODIFY THE Set()
     * constructor. We have completed this for you.
     */
    public Set() {
        S = new int[SIZE];
        next = 0;
    }


    /*
     * TODO:
     * return an exact copy of this set.
     * Read the assignment handout for more details.
     */
    public Set(int[] A) {
        /*
            1 - Create a new Array of size SIZE (Use S)
            2 - Copy everything from A to our new array (S)
            3 - Update next accordingly
        */

    }


    /*
     * TODO:
     * return an exact copy of this set
     * Read the assignment handout for more details.
     */
    public Set clone() {
      /*
          1 - Create new Set object
          2 - Insert everything (we have this function) into our new set
              - Loop over S
          3 - Return our new Set object
      */


    }

    //

    /*
     * DO NOT MODIFY THE resize method.
     * replace array A with array twice as big, and copy everything over
     */
    private void resize() {
        int[] T = new int[SIZE * 2];
        for (int i = 0; i < S.length; ++i) {
            T[i] = S[i];
        }
        SIZE = SIZE * 2;
        S = T;
    }


    /*
     * DO NOT MODIFY THE toString method.
     * We have completed this method for you.
     */
    public  String toString()  {
        if (next == 0) {
            return "[]";
        }
        String s = "[";
        for (int i = 0; i < next-1; ++i) {
            s += S[i] + ",";
        }
        s += S[next-1] + "]";
        return s;
    }


    /*
     * TODO:
     * Return the number of elements in the set
     * Read the assignment handout for more details.
     */

    public int size() {
      /*
          1 - We have a variable that we can just return
              - Look at the class variables at the top
      */


    }



    /*
     * TODO:
     * Return true if S is the empty set (has no members)
     * Read the assignment handout for more details.
     */

    public  boolean isEmpty() {
      /*
          1 - We have a size() function, lets use it!
      */

    }



    /*
     * TODO:
     * Return true if n is in the set and false otherwise
     * Read the assignment handout for more details.
     */
    public boolean member(int k) {
      /*
          1 - Linear search over S
      */


    }




    /*
     * TODO:
     * Returns true if S is a subset of T, that is, every member of S is a member of T.
     * Read the assignment handout for more details.
     */
    public  boolean subset(Set T) {

      /*
          1 - We a member() function, lets use it!
              - Loop over S
              - Keep checking if that value is a member of T
              - If its not -> Return False!
              - Else after the loop -> Return True
      */



    }


    /*
     * TODO:
     * The equal method must call the subset method i.e.,
     * two sets are equal if both are subset of each other.
     */
    public  boolean equal(Set T) {
      /*
          1 - We have a subset() function, lets use it!
          2 - Are we (this) a subset of T
          3 - Is T a subset of us (this)
      */

    }


    /*
     * TODO:
     * Read the assignment handout for more details.
     */
    public void insert(int k) {
      /*
          1 - First check if K is a member
          2 - Now check if we have to call resize()
          3 - Use our global variable 'next' to index S
          4 - Update 'next' accordingly
      */



    }


    /*
     * TODO:
     * Read the assignment handout for more details.
     */
    public void delete(int k) {=
      /*
          1 - Create a new array of size SIZE
          2 - Check if 'k' is a member
          3 - Then -> Loop over our new array, copy everything except if == 'k'
      */




    }

    /*
     * TODO:
     * Returns the union of this set and T as a new set
     * Read the assignment handout for more details.
     */

    public Set union(Set T) {
      /*
          1 - Union is this + T
          2 - Loop over everything in S
          3 - Add it to T
          4 - Return T
      */


    }

    /*
     * TODO:
     * Returns the intersection of S and T as a new set
     * Read the assignment handout for more details.
     */
    public Set intersection(Set T) {
      /*
          1 - Create a new Set
          2 - Loop over everything in S
          3 - Only add it to our new set if it's ALSO a member() of T
      */



    }


    /* TODO:
     * Returns the set difference this / T, i.e., all elements of this set which
     * are not in T, as a new set.
     * Read the assignment handout for more details.
     */
    public Set setdifference(Set T) {



      /*
          1 - Create a new Set
          2 - Loop over everything in S
          3 - Only add it to our new set if it's NOT a member() of T
          4 - Note: Same as intersection (but just different condition)
      */




    }

    /*
	 * Do not write any code inside the main method and expect it to get marked.
	 * Any code that you write inside the main method will be ignored. However,
	 * you are free to edit the main function in any way you like for
	 * your own testing purposes.
	 */
    public static void main(String [] args) {

        System.out.println("\nUnit Test for Set: note that your answers, when they are");
        System.out.println("  sets, could be in a different order (since order does");
        System.out.println("  not matter), this is the meaning of \"same set as...\"\n");

        Set A = new Set();
        Set B = new Set( new int[] { 5 } );
        Set C = new Set( new int[] { 5, 3, 7, 4, 1 } );
        Set D = new Set( new int[] { 4, 3, -3, 10, 8 } );
        Set E = new Set( new int[] { 8, 4, 10 } );
        Set F = new Set( new int[] { 10, 8, 4 } );

        System.out.println("Test 01: Should be\n[]");
        System.out.println(A);
        System.out.println();

        System.out.println("Test 02: Should be\n[5]");
        System.out.println(B);
        System.out.println();

        System.out.println("Test 03: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C);
        System.out.println();

        System.out.println("Test 04: Should be\n[]");
        System.out.println(A.clone());
        System.out.println();

        System.out.println("Test 05: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.clone());
        System.out.println();

        System.out.println("Test 06: Should be\n0");
        System.out.println(A.size());
        System.out.println();

        System.out.println("Test 07: Should be\n5");
        System.out.println(D.size());
        System.out.println();

        System.out.println("Test 08: Should be\ntrue");
        System.out.println(A.isEmpty());
        System.out.println();

        System.out.println("Test 09: Should be\nfalse");
        System.out.println(F.isEmpty());
        System.out.println();

        System.out.println("Test 10: Should be\nfalse");
        System.out.println(A.member(4));
        System.out.println();

        System.out.println("Test 11: Should be\ntrue");
        System.out.println(C.member(1));
        System.out.println();

        System.out.println("Test 12: Should be\nfalse");
        System.out.println(D.member(1));
        System.out.println();

        System.out.println("Test 13: Should be\ntrue");
        System.out.println(A.subset(D));
        System.out.println();

        System.out.println("Test 14: Should be\nfalse");
        System.out.println(D.subset(C));
        System.out.println();

        System.out.println("Test 15: Should be\ntrue");
        System.out.println(E.subset(D));
        System.out.println();

        System.out.println("Test 16: Should be\nfalse");
        System.out.println(D.subset(E));
        System.out.println();

        System.out.println("Test 17: Should be\nfalse");
        System.out.println(D.equal(E));
        System.out.println();

        System.out.println("Test 18: Should be\ntrue");
        System.out.println(E.equal(F));
        System.out.println();

        System.out.println("Test 19: Should be\ntrue");
        System.out.println(F.equal(E));
        System.out.println();

        System.out.println("Test 20: Should be\ntrue");
        System.out.println(A.equal(A));
        System.out.println();

        System.out.println("Test 21: Should be same set as\n[4,6]");
        Set A1 = A.clone();
        A1.insert(4);
        A1.insert(6);
        A1.insert(4);
        System.out.println(A1);
        System.out.println();

        System.out.println("Test 22: Should be same set as\n[10,8,4,5]");
        Set F1 = F.clone();
        F1.insert(5);
        F1.insert(4);
        System.out.println(F1);
        System.out.println();

        System.out.println("Test 23: Should be same set as\n[8,4,10]");
        Set E1 = E.clone();
        E1.insert(10);
        System.out.println(E1);
        System.out.println();

        System.out.println("Test 24: Should be\n[]");
        A1 = A.clone();
        A1.delete(5);
        System.out.println(A1);
        System.out.println();

        System.out.println("Test 25: Should be\n[]");
        Set B1 = B.clone();
        B1.delete(5);
        System.out.println(B1);
        System.out.println();

        System.out.println("Test 26: Should be same set as\n[8,4,10]");
        E1 = E.clone();
        E1.delete(5);
        System.out.println(E1);
        System.out.println();

        System.out.println("Test 27: Should be same set as\n[4,10]");
        E1 = E.clone();
        E1.delete(8);
        System.out.println(E1);
        System.out.println();

        System.out.println("Test 28: Should be same set as\n[3,4]");
        System.out.println(C.intersection(D));
        System.out.println();

        System.out.println("Test 29: Should be\n[8,4,10]");
        System.out.println(E.intersection(F));
        System.out.println();

        System.out.println("Test 30: Should be same set as\n[]");
        System.out.println(A.intersection(F));
        System.out.println();

        System.out.println("Test 31: Should be same set as\n[]");
        System.out.println(B.intersection(F));
        System.out.println();

        System.out.println("Test 32: Should be same set as\n[4,3,-3,10,8,5,7,1]");
        System.out.println(C.union(D));
        System.out.println();

        System.out.println("Test 33: Should be same set as\n[10,8,4]");
        System.out.println(E.union(F));
        System.out.println();

        System.out.println("Test 34: Should be same set as\n[10,8,4]");
        System.out.println(A.union(F));
        System.out.println();

        System.out.println("Test 35: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.union(B));
        System.out.println();

        System.out.println("Test 36: Should be same set as\n[5,7,1]");
        System.out.println(C.setdifference(D));
        System.out.println();

        System.out.println("Test 37: Should be same set as\n[]");
        System.out.println(E.setdifference(F));
        System.out.println();

        System.out.println("Test 38: Should be same set as\n[5,3,7,4,1]");
        System.out.println(C.setdifference(A));
        System.out.println();

        System.out.println("Test 39: Should be same set as\n[]");
        System.out.println(C.setdifference(C));
        System.out.println();

        System.out.println("Test 40: Should be same set as\n[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]");
        Set G = new Set();
        for(int i = 0; i < 32; ++i) {
            G.insert(i);
        }
        System.out.println(G);
        System.out.println();

    }
}
