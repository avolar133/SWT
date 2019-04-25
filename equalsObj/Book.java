public class Book{
  private String name;
  private int pubYear;

  public Book(String name, int pubYear){
    this.name = name;
    this.pubYear = pubYear;
  }

  public String getName(){
    return name;
  }

  public int getYear(){
    return pubYear;
  }

  @Override
  public String toString(){
    return name+" (" +pubYear+")";
  }

  @Override
  public boolean equals(Object object){
    if(object == null){
      System.out.println("the compared object is null");
      return false;
    }
    if(this.getClass() != object.getClass()){
      System.out.println("It is not the same class");
      return false;
    }

    Book upgradedObj = (Book) object;

    if(this.pubYear != upgradedObj.getYear()){
      System.out.println("Not the same publish year");
      return false;
    }

    if(this.name == null || !this.name.equals(upgradedObj.getName())){
      System.out.println("my name is null or we dont have the same name");
      return false;
    }



    return true;
  }
}
