import java.nio.file.Watchable;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Passing_Bridge {
    public static void main(String[] args){
        int bridge_length=100;
        int weight=100;
        int[] truck_weights={10};

        System.out.println( solution(bridge_length,weight,truck_weights));
    }
    public static int solution(int bridge_length,int weight,int[] truck_weight){
        int answer=0;
        int totalWeight=0; // passingTruckQueue안의 무게 제한

        Queue<Truck> waitingTruckQueue=new LinkedList<Truck>(); // 대기중인 트럭들의 모임
        Queue<Truck> passingTruckQueue=new LinkedList<Truck>(); // 다리를 지나는 중인 트럭 (여기에 조건 붙이자 weight보다 작거나 같은만큼만 queue에 들어올수있음
        Truck[] trucks=new Truck[truck_weight.length];

       for(int i=0;i<trucks.length;i++){ // waiting 중인 트럭 queue
           trucks[i]=new Truck(truck_weight[i],bridge_length); // 각 트럭의 무게, 다리의 길이 = 다리에 있는 시간
           waitingTruckQueue.offer(trucks[i]);
       }

       totalWeight+=(Integer)waitingTruckQueue.peek()._weight;
       passingTruckQueue.offer(waitingTruckQueue.poll());
       answer++; //처음 트럭이 다리에 올랐을떄

        while(!passingTruckQueue.isEmpty()){ // passing queue가 비면 조건 종료
            for(Truck truck : passingTruckQueue){ //다리위의 트럭이 지나는 시간 1초마다 1씩 --
                truck._time--;
            }//for

            if(passingTruckQueue.peek()._time == 0){ // 다리위의 트럭의 시간이 다 지났다면 뻄
                totalWeight-=passingTruckQueue.peek()._weight;
                passingTruckQueue.poll();
            }

            if(!waitingTruckQueue.isEmpty() && totalWeight+waitingTruckQueue.peek()._weight <=weight){ //아직 기다리는 트럭이 남아있고, 트럭이 들어왔을떄 무게가 다리가 견딜수있다면
                totalWeight+=waitingTruckQueue.peek()._weight;
                passingTruckQueue.offer(waitingTruckQueue.poll());
            }
            answer++; //1초마다 시간 ++
        }//while
        return answer;
    }
}
class Truck{
    int _weight;
    int _time;

    Truck(int weight,int time){
        this._weight=weight;
        this._time=time;
    }
}

/*
* 향상된 for문 실제 사용 이점 .
* for문아니었으면 못풀었을듯
* */
