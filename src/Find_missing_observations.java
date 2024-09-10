import java.util.Arrays;

public class Find_missing_observations {
    public static void main(String[] args){
        int[] rolls = {3,2,4,3};
        int mean = 4;
        int n = 2;

        int[] ans = missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int m = rolls.length;
        int sum = mean * (m+n);
        for(int i=0; i<m; i++){
            sum -= rolls[i];
        }

        if(sum < n || sum > 6*n){
            return new int[0];
        }

        int avg = sum / n;
        int reminder = sum % n;

        //store the avg of every result position if reminder > 0 then increase the value of current result value and reminder decrease
        for(int i=0;i<n;i++){
            result[i] = avg;
            if(reminder > 0){
                result[i]++;
                reminder--;
            }
        }


        return result;
    }


}
