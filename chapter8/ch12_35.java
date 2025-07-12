package com.example.chapter8;
//1을 육지로, 0을 물로 가정한 2차원 그리드 맵이 주어졌을 때 섬의 개수는? (연결되어 있는 1의 덩어리 개수를 구해라)
public class ch12_35 {
	public void dfs(int i, int j, char[][] grid){
		if(i<0|| i>= grid.length||j<0||j>=grid[0].length||grid[i][j]=='0'){
			return ;
		}
		grid[i][j]='#';
		dfs(i,j+1,grid);
		dfs(i,j-1,grid);
		dfs(i+1,j,grid);
		dfs(i-1,j,grid);
	}

	public int numIslands(char[][] grid){
		int count=0;
		for(int i=0;i< grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j]=='1'){
					dfs(i,j,grid);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		ch12_35 sol= new ch12_35();
		char[][] grid = {
			{'1', '1', '0', '0', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '1', '0', '0'},
			{'0', '0', '0', '1', '1'}
		};
		int answer=sol.numIslands(grid);
		System.out.println(answer);
	}
}
