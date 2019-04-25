public class app{
  public static void main(String[] args){

    Book b = new Book("akuna", 1912);
    // reference
    Book c = b;
    System.out.println(b);

    System.out.println(b.getClass());
    String name = "Caffee";
    if(c.equals(b)){
      System.out.println("It is correct");
    }else{
      System.out.println("It is false");
    }

    //new Object
    c = new Book("bujaja",1912);
    // Man ezra = new Man("Melech");
    System.out.println(c);

    if(c.equals(b)){
      System.out.println("It is correct");
    }else{
      System.out.println("It is false");
    }


  }

}
