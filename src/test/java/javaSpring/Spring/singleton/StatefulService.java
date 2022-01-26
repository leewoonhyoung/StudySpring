package javaSpring.Spring.singleton;

public class StatefulService {

  // 이런 식으로 설계하면 큰일난다.
//    private int price;
//    public void order(String name, int price){
//        System.out.println("name = " + name + "price" + price);
//        this.price = price; // 여기가 문제 발생
//    }
//
//    public int getPrice(int price){
//        return price;
//    }

    public int order(String name , int price){
        System.out.println("name = " + name + "price" + price);
        return price;
    }

//    public int getPrice(){
//    }
}
