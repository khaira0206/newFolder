import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class abc {
	static JFrame frame = new JFrame("Artificial Intelligence Search System:");
	static JButton[] b = new JButton[120];
	int count = 0;
	final DecimalFormat df = new DecimalFormat("#.##");//To get the answer in decimal format.

	// path finding
	final double alpha = 0.1;//I have given dynamically can also be changed to observe the different values.
	final double gamma = 0.9;
	// declarations of nodes and its values and links.
	final int A1 = 0;
	final int A2 = 1;
	final int A3 = 2;
	final int A4 = 3;
	final int A5 = 4;
	final int A6 = 5;
	final int A7 = 6;
	final int A8 = 7;
	final int A9 = 8;
	final int A10 = 9;
	final int A11 = 10;
	final int A12 = 11;
	final int A13 = 12;
	final int A14 = 13;
	final int A15 = 14;
	final int A16 = 15;
	final int A17 = 16;
	final int A18 = 17;
	final int A19 = 18;
	final int A20 = 19;
	final int A21 = 20;
	final int A22 = 21;
	final int A23 = 22;
	final int A24 = 23;
	final int A25 = 24;
	final int A26 = 25;
	final int A27 = 26;
	final int A28 = 27;
	final int A29 = 28;
	final int A30 = 29;
	final int A31 = 30;
	final int A32 = 31;
	final int A33 = 32;
	final int A34 = 33;
	final int A35 = 34;
	final int A36 = 35;
	final int A37 = 36;
	final int A38 = 37;
	final int A39 = 38;
	final int A40 = 39;
	final int A41 = 40;
	final int A42 = 41;
	final int A43 = 42;
	final int A44 = 43;
	final int A45 = 44;
	final int A46 = 45;
	final int A47 = 46;
	final int A48 = 47;
	final int A49 = 48;
	final int A50 = 49;
	final int A51 = 50;
	final int A52 = 51;
	final int A53 = 52;
	final int A54 = 53;
	final int A55 = 54;
	final int A56 = 55;
	final int A57 = 56;
	final int A58 = 57;
	final int A59 = 58;
	final int A60 = 59;
	final int A61 = 60;
	final int A62 = 61;
	final int A63 = 62;
	final int A64 = 63;
	final int A65 = 64;
	final int A66 = 65;
	final int A67 = 66;
	final int A68 = 67;
	final int A69 = 68;
	final int A70 = 69;
	final int A71 = 70;
	final int A72 = 71;
	final int A73 = 72;
	final int A74 = 73;
	final int A75 = 74;
	final int A76 = 75;
	final int A77 = 76;
	final int A78 = 77;
	final int A79 = 78;
	final int A80 = 79;
	final int A81 = 80;
	final int A82 = 81;
	final int A83 = 82;
	final int A84 = 83;
	final int A85 = 84;
	final int A86 = 85;
	final int A87 = 86;
	final int A88 = 87;
	final int A89 = 88;
	final int A90 = 89;
	final int A91 = 90;
	final int A92 = 91;
	final int A93 = 92;
	final int A94 = 93;
	final int A95 = 94;
	final int A96 = 95;
	final int A97 = 96;
	final int A98 = 97;
	final int A99 = 98;
	final int A100 = 99;
	final int A101 = 100;
	final int A102 = 101;
	final int A103 = 102;
	final int A104 = 103;
	final int A105 = 104;
	final int A106 = 105;
	final int A107 = 106;
	final int A108 = 107;
	final int A109 = 108;
	final int A110 = 109;
	final int A111 = 110;
	final int A112 = 111;
	final int A113 = 112;
	final int A114 = 113;
	final int A115 = 114;
	final int A116 = 115;
	final int A117 = 116;
	final int A118 = 117;
	final int A119 = 118;
	final int A120 = 119;

	//Total number
	final int statesCount = 120;

	final int[] states = new int[] { A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18,
			A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39,
			A40, A41, A42, A43, A44, A45, A46, A47, A48, A49, A50, A51, A52, A53, A54, A55, A56, A57, A58, A59, A60,
			A61, A62, A63, A64, A65, A66, A67, A68, A69, A70, A71, A72, A73, A74, A75, A76, A77, A78, A79, A80, A81,
			A82, A83, A84, A85, A86, A87, A88, A89, A90, A91, A92, A93, A94, A95, A96, A97, A98, A99, A100, A101, A102,
			A103, A104, A105, A106, A107, A108, A109, A110, A111, A112, A113, A114, A115, A116, A117, A118, A119,
			A120 };

	// Q(s,a)= Q(s,a) + alpha * (R(s,a) + gamma * Max(next state, all actions) -
	// Q(s,a)) Its formula that we need to use.

	int[][] R = new int[statesCount][statesCount]; // reward lookup
	double[][] Q = new double[statesCount][statesCount]; // Q learning
	int[] fromA1 = new int[] { A2, A13 };
	int[] fromA2 = new int[] { A1, A3, A14 };
	int[] fromA3 = new int[] { A2, A4, A15 };
	int[] fromA4 = new int[] { A3, A5, A16 };
	int[] fromA5 = new int[] { A4, A6, A17 };
	int[] fromA6 = new int[] { A5, A7, A18 };
	int[] fromA7 = new int[] { A6, A8, A19 };
	int[] fromA8 = new int[] { A7, A9, A20 };
	int[] fromA9 = new int[] { A8, A10, A21 };
	int[] fromA10 = new int[] { A9, A11, A22 };
	int[] fromA11 = new int[] { A10, A12, A23 };
	int[] fromA12 = new int[] { A11, A24 };
	int[] fromA13 = new int[] { A1, A14, A25 };
	int[] fromA14 = new int[] { A2, A13, A15, A26 };
	int[] fromA15 = new int[] { A3, A14, A16, A27 };
	int[] fromA16 = new int[] { A4, A15, A17, A28 };
	int[] fromA17 = new int[] { A5, A16, A18, A29 };
	int[] fromA18 = new int[] { A6, A17, A19, A30 };
	int[] fromA19 = new int[] { A7, A18, A20, A31 };
	int[] fromA20 = new int[] { A8, A19, A21, A32 };
	int[] fromA21 = new int[] { A9, A20, A22, A33 };
	int[] fromA22 = new int[] { A10, A21, A23, A34 };
	int[] fromA23 = new int[] { A11, A22, A24, A35 };
	int[] fromA24 = new int[] { A12, A23, A36 };
	int[] fromA25 = new int[] { A13, A26, A37 };
	int[] fromA26 = new int[] { A14, A25, A27, A38 };
	int[] fromA27 = new int[] { A15, A26, A28, A39 };
	int[] fromA28 = new int[] { A16, A27, A29, A40 };
	int[] fromA29 = new int[] { A17, A28, A30, A41 };
	int[] fromA30 = new int[] { A18, A29, A31, A42 };
	int[] fromA31 = new int[] { A19, A30, A32, A43 };
	int[] fromA32 = new int[] { A20, A31, A33, A44 };
	int[] fromA33 = new int[] { A21, A32, A34, A45 };
	int[] fromA34 = new int[] { A22, A33, A35, A46 };
	int[] fromA35 = new int[] { A23, A34, A36, A47 };
	int[] fromA36 = new int[] { A24, A35, A48 };
	int[] fromA37 = new int[] { A25, A38, A49 };
	int[] fromA38 = new int[] { A26, A37, A39, A50 };
	int[] fromA39 = new int[] { A27, A38, A40, A51 };
	int[] fromA40 = new int[] { A28, A39, A41, A52 };
	int[] fromA41 = new int[] { A29, A40, A42, A53 };
	int[] fromA42 = new int[] { A30, A41, A43, A54 };
	int[] fromA43 = new int[] { A31, A42, A44, A55 };
	int[] fromA44 = new int[] { A32, A43, A45, A56 };
	int[] fromA45 = new int[] { A33, A44, A46, A57 };
	int[] fromA46 = new int[] { A34, A45, A47, A58 };
	int[] fromA47 = new int[] { A35, A46, A48, A59 };
	int[] fromA48 = new int[] { A36, A47, A60 };
	int[] fromA49 = new int[] { A37, A50, A61 };
	int[] fromA50 = new int[] { A38, A49, A51, A62 };
	int[] fromA51 = new int[] { A39, A50, A52, A63 };
	int[] fromA52 = new int[] { A40, A51, A53, A64 };
	int[] fromA53 = new int[] { A41, A52, A54, A65 };
	int[] fromA54 = new int[] { A42, A53, A55, A66 };
	int[] fromA55 = new int[] { A43, A54, A56, A67 };
	int[] fromA56 = new int[] { A44, A55, A57, A68 };
	int[] fromA57 = new int[] { A45, A56, A58, A69 };
	int[] fromA58 = new int[] { A46, A57, A59, A70 };
	int[] fromA59 = new int[] { A47, A58, A60, A71 };
	int[] fromA60 = new int[] { A48, A59, A72 };
	int[] fromA61 = new int[] { A49, A62, A73 };
	int[] fromA62 = new int[] { A50, A61, A63, A74 };
	int[] fromA63 = new int[] { A51, A62, A64, A75 };
	int[] fromA64 = new int[] { A52, A63, A65, A76 };
	int[] fromA65 = new int[] { A53, A64, A66, A77 };
	int[] fromA66 = new int[] { A54, A65, A67, A78 };
	int[] fromA67 = new int[] { A55, A66, A68, A79 };
	int[] fromA68 = new int[] { A56, A67, A69, A80 };
	int[] fromA69 = new int[] { A57, A68, A70, A81 };
	int[] fromA70 = new int[] { A58, A69, A71, A82 };
	int[] fromA71 = new int[] { A59, A70, A72, A83 };
	int[] fromA72 = new int[] { A60, A71, A84 };
	int[] fromA73 = new int[] { A61, A74, A85 };
	int[] fromA74 = new int[] { A62, A73, A75, A86 };
	int[] fromA75 = new int[] { A63, A74, A76, A87 };
	int[] fromA76 = new int[] { A64, A75, A77, A88 };
	int[] fromA77 = new int[] { A65, A76, A78, A89 };
	int[] fromA78 = new int[] { A66, A77, A79, A90 };
	int[] fromA79 = new int[] { A67, A78, A80, A91 };
	int[] fromA80 = new int[] { A68, A79, A81, A92 };
	int[] fromA81 = new int[] { A69, A80, A82, A93 };
	int[] fromA82 = new int[] { A70, A81, A83, A94 };
	int[] fromA83 = new int[] { A71, A82, A84, A95 };
	int[] fromA84 = new int[] { A72, A83, A96 };
	int[] fromA85 = new int[] { A73, A86, A97 };
	int[] fromA86 = new int[] { A74, A85, A87, A98 };
	int[] fromA87 = new int[] { A75, A86, A88, A99 };
	int[] fromA88 = new int[] { A76, A87, A89, A100 };
	int[] fromA89 = new int[] { A77, A88, A90, A101 };
	int[] fromA90 = new int[] { A78, A89, A91, A102 };
	int[] fromA91 = new int[] { A79, A90, A92, A103 };
	int[] fromA92 = new int[] { A80, A91, A93, A104 };
	int[] fromA93 = new int[] { A81, A92, A94, A105 };
	int[] fromA94 = new int[] { A82, A93, A95, A106 };
	int[] fromA95 = new int[] { A83, A94, A96, A107 };
	int[] fromA96 = new int[] { A84, A95, A108 };
	int[] fromA97 = new int[] { A85, A98, A109 };
	int[] fromA98 = new int[] { A86, A97, A99, A110 };
	int[] fromA99 = new int[] { A87, A98, A100, A111 };
	int[] fromA100 = new int[] { A88, A99, A101, A112 };
	int[] fromA101 = new int[] { A89, A100, A102, A113 };
	int[] fromA102 = new int[] { A90, A101, A103, A114 };
	int[] fromA103 = new int[] { A91, A102, A104, A115 };
	int[] fromA104 = new int[] { A92, A103, A105, A116 };
	int[] fromA105 = new int[] { A93, A104, A106, A117 };
	int[] fromA106 = new int[] { A94, A105, A107, A118 };
	int[] fromA107 = new int[] { A95, A106, A108, A119 };
	int[] fromA108 = new int[] { A96, A107, A120 };
	int[] fromA109 = new int[] { A97, A110 };
	int[] fromA110 = new int[] { A98, A109, A111 };
	int[] fromA111 = new int[] { A99, A110, A112 };
	int[] fromA112 = new int[] { A100, A111, A113 };
	int[] fromA113 = new int[] { A101, A112, A114 };
	int[] fromA114 = new int[] { A102, A113, A115 };
	int[] fromA115 = new int[] { A103, A114, A116 };
	int[] fromA116 = new int[] { A104, A115, A117 };
	int[] fromA117 = new int[] { A105, A116, A118 };
	int[] fromA118 = new int[] { A106, A117, A119 };
	int[] fromA119 = new int[] { A107, A118, A120 };
	int[] fromA120 = new int[] { A108, A119 };
	//actions of each
	int[][] actions = new int[][] { fromA1, fromA2, fromA3, fromA4, fromA5, fromA6, fromA7, fromA8, fromA9, fromA10,
			fromA11, fromA12, fromA13, fromA14, fromA15, fromA16, fromA17, fromA18, fromA19, fromA20, fromA21, fromA22,
			fromA23, fromA24, fromA25, fromA26, fromA27, fromA28, fromA29, fromA30, fromA31, fromA32, fromA33, fromA34,
			fromA35, fromA36, fromA37, fromA38, fromA39, fromA40, fromA41, fromA42, fromA43, fromA44, fromA45, fromA46,
			fromA47, fromA48, fromA49, fromA50, fromA51, fromA52, fromA53, fromA54, fromA55, fromA56, fromA57, fromA58,
			fromA59, fromA60, fromA61, fromA62, fromA63, fromA64, fromA65, fromA66, fromA67, fromA68, fromA69, fromA70,
			fromA71, fromA72, fromA73, fromA74, fromA75, fromA76, fromA77, fromA78, fromA79, fromA80, fromA81, fromA82,
			fromA83, fromA84, fromA85, fromA86, fromA87, fromA88, fromA89, fromA90, fromA91, fromA92, fromA93, fromA94,
			fromA95, fromA96, fromA97, fromA98, fromA99, fromA100, fromA101, fromA102, fromA103, fromA104, fromA105,
			fromA106, fromA107, fromA108, fromA109, fromA110, fromA111, fromA112, fromA113, fromA114, fromA115,
			fromA116, fromA117, fromA118, fromA119, fromA120 };

	String[] stateNames = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32",
			"33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
			"51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68",
			"69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86",
			"87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103",
			"104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118",
			"119", "120" };
	static int[] a=new int[120];

	public abc() {
		init();
	}

	public void init() {
		// From white to goal the reward taken is +3.
		R[A1][A42] = 2; 
		R[A2][A42] = 2;
		R[A3][A42] = 2;
		R[A4][A42] = 2;
		R[A5][A42] = 2;
		R[A6][A42] = 2;
		R[A7][A42] = 2;
		R[A8][A42] = 2;
		R[A9][A42] = 2;
		R[A10][A42] = 2;
		R[A11][A42] = 2;
		R[A12][A42] = 2;
		R[A13][A42] = 3;
		R[A14][A42] = 3;
		R[A15][A42] = 3;
		R[A16][A42] = 3;
		R[A17][A42] = 3;
		R[A18][A42] = 3;
		R[A19][A42] = 3;
		R[A20][A42] = 3;
		R[A21][A42] = 3;
		R[A22][A42] = 3;
		R[A23][A42] = 3;
		R[A24][A42] = 2;
		R[A25][A42] = 2;
		R[A26][A42] = 3;
		R[A27][A42] = 3;
		R[A28][A42] = 3;
		R[A29][A42] = 3;
		R[A30][A42] = 3;
		R[A31][A42] = 3;
		R[A32][A42] = 3;
		R[A33][A42] = 3;
		R[A34][A42] = 3;
		R[A35][A42] = 3;
		R[A36][A42] = 2;
		R[A37][A42] = 2;
		R[A38][A42] = 2;
		R[A39][A42] = 2;
		R[A40][A42] = 2;
		R[A41][A42] = 3;
		R[A42][A42] = 3;
		R[A43][A42] = 3;
		R[A44][A42] = 3;
		R[A45][A42] = 2;
		R[A46][A42] = 2;
		R[A47][A42] = 2;
		R[A48][A42] = 2;
		R[A49][A42] = 2;
		R[A50][A42] = 3;
		R[A51][A42] = 3;
		R[A52][A42] = 2;
		R[A53][A42] = 3;
		R[A54][A42] = 3;
		R[A55][A42] = 3;
		R[A56][A42] = 3;
		R[A57][A42] = 2;
		R[A58][A42] = 3;
		R[A59][A42] = 3;
		R[A60][A42] = 2;
		R[A61][A42] = 2;
		R[A62][A42] = 3;
		R[A63][A42] = 3;
		R[A64][A42] = 3;
		R[A65][A42] = 3;
		R[A66][A42] = 3;
		R[A67][A42] = 3;
		R[A68][A42] = 3;
		R[A69][A42] = 3;
		R[A70][A42] = 3;
		R[A71][A42] = 3;
		R[A72][A42] = 2;
		R[A73][A42] = 2;
		R[A74][A42] = 3;
		R[A75][A42] = 3;
		R[A76][A42] = 3;
		R[A77][A42] = 3;
		R[A78][A42] = 3;
		R[A79][A42] = 3;
		R[A80][A42] = 3;
		R[A81][A42] = 3;
		R[A82][A42] = 3;
		R[A83][A42] = 3;
		R[A84][A42] = 2;
		R[A85][A42] = 2;
		R[A86][A42] = 3;
		R[A87][A42] = 3;
		R[A88][A42] = 3;
		R[A89][A42] = 3;
		R[A90][A42] = 3;
		R[A91][A42] = 3;
		R[A92][A42] = 3;
		R[A93][A42] = 3;
		R[A94][A42] = 3;
		R[A95][A42] = 3;
		R[A96][A42] = 2;
		R[A97][A42] = 2;
		R[A98][A42] = 3;
		R[A99][A42] = 3;
		R[A100][A42] = 3;
		R[A101][A42] = 3;
		R[A102][A42] = 3;
		R[A103][A42] = 3;
		R[A104][A42] = 3;
		R[A105][A42] = 3;
		R[A106][A42] = 3;
		R[A107][A42] = 3;
		R[A108][A42] = 2;
		R[A109][A42] = 2;
		R[A110][A42] = 2;
		R[A111][A42] = 2;
		R[A112][A42] = 2;
		R[A113][A42] = 2;
		R[A114][A42] = 2;
		R[A115][A42] = 2;
		R[A116][A42] = 2;
		R[A117][A42] = 2;
		R[A118][A42] = 2;
		R[A119][A42] = 2;
		R[A120][A42] = 2;

		// From grey to goal the reward is +2 because grey button stands for -1.
		
		R[A1][A75] = 2; 
		R[A2][A75] = 2;
		R[A3][A75] = 2;
		R[A4][A75] = 2;
		R[A5][A75] = 2;
		R[A6][A75] = 2;
		R[A7][A75] = 2;
		R[A8][A75] = 2;
		R[A9][A75] = 2;
		R[A10][A75] = 2;
		R[A11][A75] = 2;
		R[A12][A75] = 2;
		R[A13][A75] = 3;
		R[A14][A75] = 3;
		R[A15][A75] = 3;
		R[A16][A75] = 3;
		R[A17][A75] = 3;
		R[A18][A75] = 3;
		R[A19][A75] = 3;
		R[A20][A75] = 3;
		R[A21][A75] = 3;
		R[A22][A75] = 3;
		R[A23][A75] = 3;
		R[A24][A75] = 2;
		R[A25][A75] = 2;
		R[A26][A75] = 3;
		R[A27][A75] = 3;
		R[A28][A75] = 3;
		R[A29][A75] = 3;
		R[A30][A75] = 3;
		R[A31][A75] = 3;
		R[A32][A75] = 3;
		R[A33][A75] = 3;
		R[A34][A75] = 3;
		R[A35][A75] = 3;
		R[A36][A75] = 2;
		R[A37][A75] = 2;
		R[A38][A75] = 2;
		R[A39][A75] = 2;
		R[A40][A75] = 2;
		R[A41][A75] = 3;
		R[A42][A75] = 3;
		R[A43][A75] = 3;
		R[A44][A75] = 3;
		R[A45][A75] = 2;
		R[A46][A75] = 2;
		R[A47][A75] = 2;
		R[A48][A75] = 2;
		R[A49][A75] = 2;
		R[A50][A75] = 3;
		R[A51][A75] = 3;
		R[A52][A75] = 2;
		R[A53][A75] = 3;
		R[A54][A75] = 3;
		R[A55][A75] = 3;
		R[A56][A75] = 3;
		R[A57][A75] = 2;
		R[A58][A75] = 3;
		R[A59][A75] = 3;
		R[A60][A75] = 2;
		R[A61][A75] = 2;
		R[A62][A75] = 3;
		R[A63][A75] = 3;
		R[A64][A75] = 3;
		R[A65][A75] = 3;
		R[A66][A75] = 3;
		R[A67][A75] = 3;
		R[A68][A75] = 3;
		R[A69][A75] = 3;
		R[A70][A75] = 3;
		R[A71][A75] = 3;
		R[A72][A75] = 2;
		R[A73][A75] = 2;
		R[A74][A75] = 3;
		R[A75][A75] = 3;
		R[A76][A75] = 3;
		R[A77][A75] = 3;
		R[A78][A75] = 3;
		R[A79][A75] = 3;
		R[A80][A75] = 3;
		R[A81][A75] = 3;
		R[A82][A75] = 3;
		R[A83][A75] = 3;
		R[A84][A75] = 2;
		R[A85][A75] = 2;
		R[A86][A75] = 3;
		R[A87][A75] = 3;
		R[A88][A75] = 3;
		R[A89][A75] = 3;
		R[A90][A75] = 3;
		R[A91][A75] = 3;
		R[A92][A75] = 3;
		R[A93][A75] = 3;
		R[A94][A75] = 3;
		R[A95][A75] = 3;
		R[A96][A75] = 2;
		R[A97][A75] = 2;
		R[A98][A75] = 3;
		R[A99][A75] = 3;
		R[A100][A75] = 3;
		R[A101][A75] = 3;
		R[A102][A75] = 3;
		R[A103][A75] = 3;
		R[A104][A75] = 3;
		R[A105][A75] = 3;
		R[A106][A75] = 3;
		R[A107][A75] = 3;
		R[A108][A75] = 2;
		R[A109][A75] = 2;
		R[A110][A75] = 2;
		R[A111][A75] = 2;
		R[A112][A75] = 2;
		R[A113][A75] = 2;
		R[A114][A75] = 2;
		R[A115][A75] = 2;
		R[A116][A75] = 2;
		R[A117][A75] = 2;
		R[A118][A75] = 2;
		R[A119][A75] = 2;
		R[A120][A75] = 2;
	}

	void showPolicy() {
		System.out.println("The final path is as follows:");
		for (int i = 0; i < states.length; i++) {
			int from = states[i];
			int to = policy(from);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b[Integer.parseInt(stateNames[to])].setForeground(Color.WHITE);
			b[Integer.parseInt(stateNames[to])].setBackground(Color.GREEN);
			//Here I have taken goal has 75 if you change please change here and always start from 1 only change the goal. 
			
			System.out.println("from " + stateNames[from] + " goto " + stateNames[to]);
			
			b[Integer.parseInt(stateNames[to])-1].setForeground(Color.WHITE);
			b[Integer.parseInt(stateNames[to])-1].setBackground(Color.GREEN);
			if (Integer.parseInt(stateNames[to]) == 75) {
				break;
			}
		}
		
	}

	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		JLabel lblArtificialIntelliegenceSearch = new JLabel("Q-Learning Program Assignment");
		lblArtificialIntelliegenceSearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblArtificialIntelliegenceSearch.setBounds(400, 47, 620, 50);
		panel.add(lblArtificialIntelliegenceSearch);

		JLabel selection1 = new JLabel("Type of Project:");
		selection1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		selection1.setBounds(360, 161, 130, 24);
		panel.add(selection1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(500, 161, 219, 20);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		comboBox.setForeground(new Color(0, 0, 0));

		comboBox.addItem("Q-Learning");

		panel.add(comboBox);

		int i1, sum = 0;

		for (i1 = 0; i1 < 120; i1++) {
			if (i1 < 12) {
				b[i1] = new JButton(" ");
				if (i1 == 0) {
					b[i1] = new JButton("S");
				}
				if (i1 > 0) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				}
				b[i1].setBounds(sum, 203, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 12 && i1 < 24) {
				if (i1 == 12) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 12 || i1 == 23) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);
				}
				b[i1].setBounds(sum, 226, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 24 && i1 < 36) {
				if (i1 == 24) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 24 || i1 == 35) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}

				b[i1].setBounds(sum, 249, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 36 && i1 < 48) {
				if (i1 == 36) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 42) {
					b[i1] = new JButton("P");
					}
				if ((i1 >= 36 && i1 <= 39) || (i1 >= 44 && i1 <= 47)) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}
				b[i1].setBounds(sum, 272, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 48 && i1 < 60) {
				if (i1 == 48) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 48 || i1 == 56 || i1 == 51 || i1 == 59) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}
				b[i1].setBounds(sum, 295, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 60 && i1 < 72) {
				if (i1 == 60) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 60 || i1 == 71) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}
				b[i1].setBounds(sum, 318, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 72 && i1 < 84) {
				if (i1 == 72) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 72 || i1 == 83) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}
				if (i1 == 74) {
					b[i1] = new JButton("G");
				}
				b[i1].setBounds(sum, 341, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 84 && i1 < 96) {
				if (i1 == 84) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 84 || i1 == 95) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}
				b[i1].setBounds(sum, 364, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 96 && i1 < 108) {
				if (i1 == 96) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 == 96 || i1 == 107) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}
				b[i1].setBounds(sum, 387, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			} else if (i1 >= 108 && i1 < 120) {
				if (i1 == 108) {
					sum = 0;
				}
				b[i1] = new JButton(" ");
				if (i1 >= 108 && i1 <= 119) {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.GRAY);
				} else {
					b[i1].setForeground(Color.WHITE);
					b[i1].setBackground(Color.WHITE);

				}
				b[i1].setBounds(sum, 410, 89, 23);
				panel.add(b[i1]);
				sum = sum + 89;
			}
		}

	}

	public static void main(String... arg) {

		int number_of_vertices = 120;

		int distance;

		Scanner scan = new Scanner(System.in);
		frame.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		frame.setBackground(new Color(204, 204, 102));
		// frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Zipal
		// Trivedi\\Desktop\\images (1).png"));
		// Code from 47 to 61 line is used to create JFrame
		frame.setSize(1082, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1082, 700);
		frame.getContentPane().add(panel);
		placeComponents(panel);
		frame.setVisible(true);
		long BEGIN = System.currentTimeMillis();

		abc obj = new abc();

		obj.run();
		obj.printResult();
		obj.showPolicy();

		
		
		

	}

	void run() {
		
		
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) { // train episodes
			// Select random initial state
			int state = rand.nextInt(statesCount);
			while (state != A75) // goal state
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
			System.out.print("out from " + stateNames[i] + ":  ");
			for (int j = 0; j < Q[i].length; j++) {
				System.out.print(df.format(Q[i][j]) + " ");
			}
			System.out.println();
		}
	}

	
}