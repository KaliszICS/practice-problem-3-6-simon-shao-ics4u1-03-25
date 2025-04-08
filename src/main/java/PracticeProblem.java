public class PracticeProblem {

	public static void main(String args[]) {
		String[][] arr = new String[][] {{"", "", "", ""},
		{"", "", "", ""},
		{"", "", "", "F"},
		{"S", "*", "*", "*"}};
System.out.println(searchMazeMoves(arr));
	}

	public static int searchMazeMoves(String[][] arr){
	int row = arr.length-1;
	int col = 0;
	int moves = 0;

	return mazeHelper(arr, row, col, moves);
	}


	public static int mazeHelper(String[][] arr, int row, int col, int moves){
		if (row == -1){
			return -1;
		}

		if (col==arr[row].length){
			return -1;
		}

		if (arr[row][col].equals("*")){
			return -1;
		}

		if (arr[row][col]=="F"){
			System.out.println(moves);
			return moves;
		}
		moves++;
		int temp1 = mazeHelper(arr, row, col+1, moves);
		int temp2 = mazeHelper(arr, row-1, col, moves);
		if (temp1 ==-1&&temp2!=-1){
			return temp2;
		}
		else if (temp2==-1&& temp1!=-1){
			return temp1;
		}
		else if(temp1 == temp2 && temp1 ==-1){
			return -1;
		}
		else{
			if (temp1>temp2){
				return temp2;
			}
			else{
				return temp1;
			}
		}

	}


	public static int noOfPaths(String[][] arr){
		int row = arr.length-1;
		int col = 0;
		int reached = 0;
		return noMazeHelper(arr, row, col, reached);
		}
	
	
		public static int noMazeHelper(String[][] arr, int row, int col, int reached){
			if (row == -1){
				return -1;
			}

			if (col == arr[row].length){
				return -1;
			}

			if (arr[row][col].equals("*")){
				return -1;
			}
	
			if (arr[row][col]=="F"){
				System.out.println("it reached");
				reached = reached+1;
				System.out.println(reached);
				return reached;
			}
			int temp1 = noMazeHelper(arr, row, col+1, reached);
			int temp2 = noMazeHelper(arr, row-1, col, reached);
			if (temp1!=-1){
				reached = reached + temp1;
			}
			if (temp2!=-1){
				reached = reached + temp2;
			}
			return reached;
	
		}




}
