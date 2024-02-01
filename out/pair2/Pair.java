package pair2;

//import lombok.Data;
////cannot sucesses now!!!
//@Data
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {first = null; second = null; }
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {return first;}
    public T getSecond() {return second;}

    public void setFirst(T newValue) {first = newValue;}
    public void setSecond(T newValue) {second = newValue;}
}

//public class Pair<A, B> {
//    private final A first;
//    private final B second;
//
//    public Pair(A first, B second) {
//        this.first = first;
//        this.second = second;
//    }
//
//    public A getFirst() {
//        return first;
//    }
//
//    public B getSecond() {
//        return second;
//    }
//}