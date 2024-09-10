import java.util.HashSet;
import java.util.Set;

public class Walking_robot_solution {
    public  static void main(String[] args){
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};

        int ans = walkingOfRobot(commands, obstacles);
        System.out.println(ans);
    }

    public static int walkingOfRobot(int[] commands, int[][] obstacles) {
        int[] dires = {0, 1, 0, -1, 0};
        Set<Integer> s = new HashSet<>(obstacles.length);

        for(int[] ele: obstacles){
            s.add(f(ele[0], ele[1]));
        }

        int ans = 0, k = 0;
        int x = 0, y =0;

        for (int c : commands){
            if(c == -1){
                k = (k+1) % 4;
            }else if(c == -2){
                k = (k+3) % 4;
            }else{
                while (c > 0){
                    int nx = x + dires[k];
                    int ny = y + dires[k+1];
                    if(s.contains(f(nx, ny))){
                        break;
                    }

                    x = nx;
                    y = ny;
                    c--;
                    ans = Math.max(ans, (x*x + y*y));
                }
            }
        }
        return ans;
    }

    public static int f(int x, int y){
        return x*60010 + y;
    }
}
