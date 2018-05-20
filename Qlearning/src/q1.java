

import java.text.DecimalFormat;
import java.util.Random;
 

public class q1 {
    final DecimalFormat df = new DecimalFormat("#.##");
 
    // path finding
    final double alpha = 0.1;// Learning value
    final double gamma = 0.9; // Discount value
 
 

 
   
 
    final int statesCount = 135;
    final int[] states = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,
    		                       15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,
    		                       30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,
    		                       45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,
    		                       60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,
    		                       75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,
    		                       90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,
    		                       105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,
    		                       120,121,122,123,124,125,126,127,128,129,130,131,132,133,134};
 
    
 
    // Q(s,a)= Q(s,a) + alpha * (R(s,a) + gamma * Max(next state, all actions) - Q(s,a))
 
    int[][] R = new int[statesCount][statesCount]; // reward lookup
    double[][] Q = new double[statesCount][statesCount]; // Q learning
 
    int[] a0= new int[] {1,15};
    int[] a1= new int[] {0,2,16};
    int[] a2= new int[] {1,3,17};
    int[] a3= new int[] {2,4,18};
    int[] a4= new int[] {3,5,19};
    int[] a5= new int[] {4,6,20};
    int[] a6= new int[] {5,7,21};
    int[] a7= new int[] {6,8,22};
    int[] a8= new int[] {7,9,23};
    int[] a9= new int[] {8,10,24};
    int[] a10= new int[] {9,11,25};
    int[] a11= new int[] {10,12,26};
    int[] a12= new int[] {11,13,27};
    int[] a13= new int[] {12,14,28};
    int[] a14= new int[] {13,29};
    int[] a15= new int[] {16,30,0};
    int[] a16= new int[] {15,17,31,1};
    int[] a17= new int[] {16,18,32,2};
    int[] a18= new int[] {17,19,33,3};
    int[] a19= new int[] {18,20,34,4};
    int[] a20= new int[] {19,21,35,5};
    int[] a21= new int[] {20,22,36,6};
    int[] a22= new int[] {21,23,37,7};
    int[] a23= new int[] {22,24,38,8};
    int[] a24= new int[] {23,25,39,9};
    int[] a25= new int[] {24,26,40,10};
    int[] a26= new int[] {25,27,41,11};
    int[] a27= new int[] {26,28,42,12};
    int[] a28= new int[] {27,29,43,13};
    int[] a29= new int[] {28,44,14};
    int[] a30= new int[] {31,45,15};
    int[] a31= new int[] {30,32,46,16};
    int[] a32= new int[] {31,33,47,17};
    int[] a33= new int[] {32,34,48,18};
    int[] a34= new int[] {33,35,49,19};
    int[] a35= new int[] {34,36,50,20};
    int[] a36= new int[] {35,37,51,21};
    int[] a37= new int[] {36,38,52,22};
    int[] a38= new int[] {37,39,53,23};
    int[] a39= new int[] {38,40,54,24};
    int[] a40= new int[] {39,41,55,25};
    int[] a41= new int[] {40,42,56,26};
    int[] a42= new int[] {41,43,57,27};
    int[] a43= new int[] {42,44,58,28};
    int[] a44= new int[] {43,59,29};
    int[] a45= new int[] {46,60,30};
    int[] a46= new int[] {45,47,61,31};
    int[] a47= new int[] {46,48,62,32};
    int[] a48= new int[] {47,49,63,33};
    int[] a49= new int[] {48,50,64,34};
    int[] a50= new int[] {49,51,65,35};
    int[] a51= new int[] {50,52,66,36};
    int[] a52= new int[] {51,53,67,37};
    int[] a53= new int[] {52,54,68,38};
    int[] a54= new int[] {53,55,69,39};
    int[] a55= new int[] {54,56,70,40};
    int[] a56= new int[] {55,57,71,41};
    int[] a57= new int[] {56,58,72,42};
    int[] a58= new int[] {57,59,73,43};
    int[] a59= new int[] {58,74,44};
    int[] a60= new int[] {61,75,45};
    int[] a61= new int[] {60,62,76,46};
    int[] a62= new int[] {61,63,77,47};
    int[] a63= new int[] {62,64,78,48};
    int[] a64= new int[] {63,65,79,49};
    int[] a65= new int[] {64,66,80,50};
    int[] a66= new int[] {65,67,81,51};
    int[] a67= new int[] {66,68,82,52};
    int[] a68= new int[] {67,69,83,53};
    int[] a69= new int[] {68,70,84,54};
    int[] a70= new int[] {69,71,85,55};
    int[] a71= new int[] {70,72,86,56};
    int[] a72= new int[] {71,73,87,57};
    int[] a73= new int[] {72,74,88,58};
    int[] a74= new int[] {73,89,59};
    int[] a75= new int[] {76,90,60};
    int[] a76= new int[] {75,77,91,61};
    int[] a77= new int[] {76,78,92,62};
    int[] a78= new int[] {77,79,93,63};
    int[] a79= new int[] {78,80,94,64};
    int[] a80= new int[] {79,81,95,65};
    int[] a81= new int[] {80,82,96,66};
    int[] a82= new int[] {81,83,97,67};
    int[] a83= new int[] {82,84,98,68};
    int[] a84= new int[] {83,85,99,69};
    int[] a85= new int[] {84,86,100,70};
    int[] a86= new int[] {85,87,101,71};
    int[] a87= new int[] {86,88,102,72};
    int[] a88= new int[] {87,89,103,73};
    int[] a89= new int[] {88,104,74};
    int[] a90= new int[] {91,105,75};
    int[] a91= new int[] {90,92,106,76};
    int[] a92= new int[] {91,93,107,77};
    int[] a93= new int[] {92,94,108,78};
    int[] a94= new int[] {93,95,109,79};
    int[] a95= new int[] {94,96,110,80};
    int[] a96= new int[] {95,97,111,81};
    int[] a97= new int[] {96,98,112,82};
    int[] a98= new int[] {97,99,113,83};
    int[] a99= new int[] {98,100,114,84};
    int[] a100= new int[] {99,101,115,85};
    int[] a101= new int[] {100,102,116,86};
    int[] a102= new int[] {101,103,117,87};
    int[] a103= new int[] {102,104,118,88};
    int[] a104= new int[] {103,119,89};
    int[] a105= new int[] {106,120,90};
    int[] a106= new int[] {105,107,121,91};
    int[] a107= new int[] {106,108,122,92};
    int[] a108= new int[] {107,109,123,93};
    int[] a109= new int[] {108,110,124,94};
    int[] a110= new int[] {109,111,125,95};
    int[] a111= new int[] {110,112,126,96};
    int[] a112= new int[] {111,113,127,97};
    int[] a113= new int[] {112,114,128,98};
    int[] a114= new int[] {113,115,129,99};
    int[] a115= new int[] {114,116,130,100};
    int[] a116= new int[] {115,117,131,101};
    int[] a117= new int[] {116,118,132,102};
    int[] a118= new int[] {117,119,133,103};
    int[] a119= new int[] {118,134,104};
    int[] a120= new int[] {121,105};
    int[] a121= new int[] {120,122,106};
    int[] a122= new int[] {121,123,107};
    int[] a123= new int[] {122,124,108};
    int[] a124= new int[] {123,125,109};
    int[] a125= new int[] {124,126,110};
    int[] a126= new int[] {125,127,111};
    int[] a127= new int[] {126,128,112};
    int[] a128= new int[] {127,129,113};
    int[] a129= new int[] {128,130,114};
    int[] a130= new int[] {129,131,115};
    int[] a131= new int[] {130,132,116};
    int[] a132= new int[] {131,133,117};
    int[] a133= new int[] {132,134,118};
    int[] a134= new int[] {133,119};

    
    
        
    int[][] actions = new int[][] { a0,a1,a2,a3,a4,a5,a6,a7,
    	a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22
    	,a23,a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35,a36,
    	a37,a38,a39,a40,a41,a42,a43,a44,a45,a46,a47,a48,a49,a50,a51,
    	a52,a53,a54,a55,a56,a57,a58,a59,a60,a61,a62,a63,a64,a65,a66,
    	a67,a68,a69,a70,a71,a72,a73,a74,a75,a76,a77,a78,a79,a80,a81,
    	a82,a83,a84,a85,a86,a87,a88,a89,a90,a91,a92,a93,a94,a95,a96,
    	a97,a98,a99,a100,a101,a102,a103,a104,a105,a106,a107,a108,a109,
    	a110,a111,a112,a113,a114,a115,a116,a117,a118,a119,a120,a121,a122,
    	a123,a124,a125,a126,a127,a128,a129,a130,a131,a132,a133,a134, };
 
    String[] stateNames = new String[] {"a0","a1","a2",
    		"a3","a4","a5","a6","a7","a8","a9","a10","a11","a12","a13","a14","a15"
    		,"a16","a17","a18","a19","a20","a21","a22","a23","a24","a25","a26",
    		"a27","a28","a29","a30","a31","a32","a33","a34","a35","a36","a37","a38","a39",
    		"a40","a41","a42","a43","a44","a45","a46","a47","a48","a49","a50","a51","a52",
    		"a53","a54","a55","a56","a57","a58","a59","a60","a61","a62","a63","a64","a65",
    		"a66","a67","a68","a69","a70","a71","a72","a73","a74","a75","a76","a77","a78",
    		"a79","a80","a81","a82","a83","a84","a85","a86","a87","a88","a89","a90","a91"
    		,"a92","a93","a94","a95","a96","a97","a98","a99","a100","a101","a102","a103",
    		"a104","a105","a106","a107","a108","a109","a110","a111","a112","a113","a114",
    		"a115","a116","a117","a118","a119","a120","a121","a122"
    		,"a123","a124","a125","a126","a127","a128","a129","a130",
    		"a131","a132","a133","a134"};
 
    public q1() {
        init();
    }
 
    public void init() {  
    	// Reward for reaching the goal state is +3
        R[92][93] = 3; 
        R[78][93] = 3; 
        R[108][93] = 3;
        R[94][93] = 3;
        //Reward for reaching the gray block is -1
        for(int i=0; i<14;i++)
        {
        	R[i+15][i]=-1;
        }
        for(int i=0; i<14;i++)
        {
        	R[i+1][i]=-1;
        }
        for(int i=0; i<14;i++)
        {
        	R[i][i+1]=-1;
        }
        
        for(int i=28; i<=134;i=i+15)
        {
        	R[i][i+1]=-1;
        	
        }
        for(int i=14; i<=119;i=i+15)
        {
        	R[i][i+15]=-1;
        	
        }
        for(int i=14; i<=119;i=i+15)
        {
        	R[i+15][i]=-1;
        	
        }
        
        for(int i=105; i<=119;i++)
        {
        	R[i][i+15]=-1;
        	
        }
        for(int i=120; i<134;i++)
        {
        	R[i][i+1]=-1;
        	
        }
        for(int i=120; i<134;i++)
        {
        	R[i+1][i]=-1;
        	
        }
        for(int i=15; i<=120;i=i+15)
        {
        	R[i+1][i]=-1;
        	
        }
        for(int i=0; i<=105;i=i+15)
        {
        	R[i+15][i]=-1;
        	
        }
        for(int i=0; i<=105;i=i+15)
        {
        	R[i][i+15]=-1;
        	
        }
        
        // All other state transitions have a reward of 0
        
       
    }
 
    public static void main(String[] args) {
        
 
        q1 obj = new q1();
 
        obj.run();
        obj.printResult();
        obj.showPolicy();
 
       
        
    }
 
    void run() {
        
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) { // train episodes
            // Select random initial state
            int state = rand.nextInt(statesCount);
            while (state != 93) // goal state
            {
            	
                // Select one among all possible actions for the current state
                int[] actionsFromState = actions[state];
                 
                // Selection strategy is random in this example
                int index = rand.nextInt(actionsFromState.length);
                int action = actionsFromState[index];
 
                // Action outcome is set to deterministic in this example
                // Transition probability is 1
                int nextState = action; // data structure
 
                // Using this possible action, consider to go to the next state
                double q = Q(state, action);
                double maxQ = maxQ(nextState);
                int r = R(state, action);
 
                double value = q + alpha * (r + gamma * maxQ - q);
                setQ(state, action, value);
 
                // Set the next state as the current state
                state = nextState;
                
            }
        }
    }
 
    double maxQ(int s) {
        int[] actionsFromState = actions[s];
        double maxValue = Double.MIN_VALUE;
        for (int i = 0; i < actionsFromState.length; i++) {
            int nextState = actionsFromState[i];
            double value = Q[s][nextState];
 
            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }
 
    // get policy from state
    int policy(int state) {
        int[] actionsFromState = actions[state];
        double maxValue = Double.MIN_VALUE;
        int policyGotoState = state; // default goto self if not found
        for (int i = 0; i < actionsFromState.length; i++) {
            int nextState = actionsFromState[i];
            double value = Q[state][nextState];
 
            if (value > maxValue) {
                maxValue = value;
                policyGotoState = nextState;
            }
        }
        return policyGotoState;
    }
 
    double Q(int s, int a) {
        return Q[s][a];
    }
 
    void setQ(int s, int a, double value) {
        Q[s][a] = value;
    }
 
    int R(int s, int a) {
        return R[s][a];
    }
 
    void printResult() {
        System.out.println("Print result");
        for (int i = 0; i < Q.length; i++) {
         
            for (int j = 0; j < Q[i].length; j++) {
            	
                System.out.print(df.format(Q[i][j]) + " ");
            }
            System.out.println();
           
        }
      
    }
 
    // policy is maxQ(states)
    void showPolicy() {
        
        for (int i = 0; i < states.length; i++) {
            int from = states[i];
            int to =  policy(from);
            System.out.println("from "+stateNames[from]+" goto "+stateNames[to]);
            if(stateNames[to]== "a93")
            	break;
        }           
    }
}