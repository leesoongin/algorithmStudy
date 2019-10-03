public class Programmers_DFS_BFS_01 {
    public static void main(String[] args){
        int[] numbers={1,2,3,4,5};
        int target=13;

        System.out.println(solution(numbers,target));
    }
    public static int solution(int[] numbers,int target){
        int answer=0;

        answer=dfs(numbers,0,0,target);

        return answer;
    }

    public static int dfs(int[] numbers,int index,int sum,int target){
        if(index == numbers.length) {//종료조건
            if (target == sum)
                return 1;
            else
                return 0;
        }
        return dfs(numbers,index+1,sum+numbers[index],target)
                +dfs(numbers,index+1,sum-numbers[index],target);

    }//dfs
}

