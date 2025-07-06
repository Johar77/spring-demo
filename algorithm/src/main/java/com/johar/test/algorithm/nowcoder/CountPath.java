package com.johar.test.algorithm.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: CountPath
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/28 23:21
 * @Since: 1.0.0
 */
public class CountPath {

    int[][] directions = new int[][]{{1,0}, {-1, 0}, {0,1}, {0, -1}};
    public int countPath (int[][] CityMap, int n, int m) {
        // write code here
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(CityMap[i][j]==1){ //确认出发点
                    queue.offer(new int[]{i,j});
                    dist[i][j] = 1;  //出发点距离为1
                    dp[i][j] = 1;  //出发点的最短路径数为1
                }
            }
        }
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            if(CityMap[x][y]==2){
                return dp[x][y];
            }
            CityMap[x][y] = -1;
            for(int[] direction : directions){
                int newx = x + direction[0];
                int newy = y + direction[1];
                if(newx>=n || newx<0 || newy<0 || newy>=m || CityMap[newx][newy]==-1){  //判断不可达
                    continue;
                }
                if(dist[newx][newy]==0 || dist[newx][newy]==dist[x][y]+1){  //dist[newx][newy]为0或当前访问点加1，则说明可以通过当前访问点到达目标点，且为最短路径
                    dp[newx][newy] += dp[x][y];
                    dist[newx][newy] = dist[x][y] + 1;
                }

                if(!visited[newx][newy]){  //通过visited数组防止重复加入访问队列
                    queue.offer(new int[]{newx, newy});
                    visited[newx][newy] = true;
                }
            }
        }
        return -1;
    }
}