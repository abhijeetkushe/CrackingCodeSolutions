package sorting.search;


//1 2  3  4
//3 6  9  12
//5 8  11 13
//7 15 16 17
public class TwoDSearch
{
 	static class Pos
 	{
 		int x, y;
 		Pos(int x, int y)
 		{
 			this.x = x;
 			this.y = y;
 		}		
 	}
 	
 	
 	public static boolean search2(int[][] arr, int no)
 	{
 		int M = arr.length - 1;
 		int N = arr[0].length - 1;
 		
 		int row = 0;
 		int col = N;
 		
 		while(row < M && col >= 0)
 		{
 			if(arr[row][col] == no)
 			{
 				return true;
 			}else if(arr[row][col] > no)
 			{
 				col--;
 			}else {
 				
 				row++;
 			}
 			
 		}
 		
 		return false;
 	}
	
	//lxly mxly uxly m
	//lxmy mxmy uxmy
	//lxuy mxuy uxuy
	public static Pos search(int[][] arr, int no)
	{
		int lx = 0;
		int ly = 0;
		int ux = arr.length;
		int uy = arr[0].length;
		
		while(lx < ux && ly < uy)
		{
			int mx = (lx + ux)/2;
			int my = (ly + uy)/2;
			
			if(arr[lx][ly] == no) 
			{
				return new Pos(lx, ly);
			}else if(arr[mx][ly] == no)
			{
				return new Pos(mx, ly);
			}else if(arr[ux][ly] == no)
			{
				return new Pos(ux, ly);
			}else if(arr[lx][my] == no)
			{
				return new Pos(lx,my);
			}else if(arr[mx][my] == no)
			{
				return new Pos(mx,my);
			}else if(arr[ux][my] == no)
			{
				return new Pos(ux,my);
			}else if(arr[lx][uy] == no)
			{
				return new Pos(lx,uy);
			}else if(arr[mx][uy] == no)
			{
				return new Pos(mx,uy);
			}else if(arr[ux][uy] == no)
			{
				return new Pos(ux,uy);
			}
			
			if(arr[lx][ly] < no && arr[mx][ly] > no && arr[lx][my] < no && arr[mx][my] > no)
			{
				ux = mx - 1;
				uy = my - 1;
			}else if(arr[mx][ly] < no && arr[ux][ly] > no && arr[mx][my] < no && arr[ux][my] > no)
			{
				lx = mx + 1;
				uy = my + 1;
			}else if(arr[lx][my] < no && arr[mx][my] > no && arr[lx][uy] < no && arr[mx][uy] > no)
			{
				ly = my - 1;
				ux = mx - 1;
				
			}else if(arr[mx][my] < no && arr[ux][my] > no && arr[mx][uy] < no && arr[ux][uy] > no)
			{
				lx = mx + 1;
				ly = my + 1;
			}
		}
		
		return new Pos(-1, -1);
	} 

	public static void main(String[] args)
	{
		int[][] matrix = {{1, 2, 3, 4},
						  {5, 6, 7, 8},
						  {9, 10,11,12},
						  {13, 14,15,16}};
						  
	
		System.out.println(search2(matrix, 4));
		
		//Pos elem = search(matrix, 9);
		//System.out.println(elem.x +" "+ elem.y);									  	

	}

}