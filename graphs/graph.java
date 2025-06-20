import java.util.*;

public class graph{
    static class edge{
        int src;
        int dst;
        public edge(int s,int d){
            this.src=s;
            this.dst=d;
        }
        
    }
    static void creatgraph(ArrayList<edge> list[]){
        for(int i=0;i<list.length;i++){
            list[i]=new ArrayList<>();
        }
        list[0].add(new edge(0, 1));
        list[1].add(new edge(1, 3));
        list[2].add(new edge(2, 3));
        list[2].add(new edge(2,1));
        list[3].add(new edge(3, 2));


    }
     
    public static void main(String[] args) {
        int V=4;
        ArrayList<edge> list[] =new ArrayList[V];
        creatgraph(list);
        for(int i=0;i<list[2].size();i++){
            edge e=list[2].get(i);
            System.out.print(e.dst+" ");
        }

    }
}