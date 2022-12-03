package generics;

public class PairUse {

    public static void main(String[] args){

          pair<String, Integer> pInner= new pair<String, Integer>("ab",100);
          pair<pair<String, Integer>, String> p= new pair<>();
         // p.setFirst(PInner.getFirst());
          System.out.println(p.getFirst());
          System.out.println(p.getFirst().getFirst());
          System.out.println(p.getFirst().getSecond());

//          Pair p= new Pair(10,20);
//        System.out.println(p.getFirst()+ " " +p.getSecond());

//        PairString pS= new PairString("aa", "bb");
//        PairDouble pS= new PairDouble(3.1, 7.2);

//          Pair<String> pS= new Pair<String>("aa", "bb");
//          System.out.println(pS.getFirst()+" "+ ps.getSecond());
//          pS.setFirst("xyz");

  //        Pair<Integer> pI= new Pair<Integer>(10, 20);
  //        System.out.println(pI.getFirst()+ " " +pI.getSecond());

    ///      Pair<Double> pD= new Pair<Double>(10.1, 20.6);
    //      System.out.println(pD.getFirst()+ " " +pD.getSecond());
//

    }
}
