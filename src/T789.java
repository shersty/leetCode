public class T789 {
    class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {


            int minDis = Integer.MAX_VALUE;
            int dis, ghostX, ghostY, targetX = target[0], targetY = target[1];
            for (int[] ghost :
                    ghosts) {
                ghostX = ghost[0];
                ghostY = ghost[1];
                dis = Math.abs(ghostX - targetX) + Math.abs(ghostY - targetY);
                minDis = Math.min(minDis, dis);
            }
            int escapeDis = Math.abs(targetX) + Math.abs(targetY);



            return escapeDis < minDis;
        }
    }
}
