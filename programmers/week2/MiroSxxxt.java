package com.example.programmers.week2;

class Solution2{
	static int[] dx={1,0,0,-1};
	static int[] dy={0,-1,1,0};
	static char[] dir={'d', 'l', 'r', 'u'};
	static boolean found=false;
	static String answer="impossible";
	public String solution(int n, int m, int x, int y, int r, int c, int k){

		int s= Math.abs(x-r)+Math.abs(y-c); // 맨해튼 거리
		if (s > k || (k - s) % 2 != 0) {
			return "impossible";
		}
		dfs(x,y,"",k,n,m,r,c);
		return answer;
	}

	private void dfs(int x, int y, String path, int remaining,int n,int m,int r, int c){
		if(found) return;
		if (remaining == 0) {
			if (x == r && y == c) {
				answer = path;
				found = true;
			}
			return;
		}
		for(int i=0;i<4;i++){
			int nx=dx[i]+x;
			int ny=dy[i]+y;
			if (nx < 1 || ny < 1 || nx > n || ny > m) continue;
			if (Math.abs(nx-r)+Math.abs(ny-c) > remaining - 1) continue;
			dfs(nx,ny,path+dir[i],remaining-1,n,m,r,c);
		}
	}
}

public class MiroSxxxt {
	public static void main(String[] args) {
		Solution2 sol=new Solution2();
		System.out.println(sol.solution(3, 3, 1, 2, 3, 3, 4));
	}


}
