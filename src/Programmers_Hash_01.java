import java.util.HashMap;
import java.util.Map;

public class Programmers_Hash_01 {
    private static Map<String,Integer> map=new HashMap<>();

    public static void main(String[] args){
        String[] pati={"asd","asdasd","asdsadasd"};
        String[] complet={"asd","asdasd"};

        System.out.println(solution(pati,complet));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        for(int i=0;i<participant.length;i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }

        for(int i=0;i<completion.length;i++){
            map.put(completion[i],map.get(completion[i])-1);
        }

        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer=key;
                return answer;
            }
        }
        return answer;
    }
}
