public class Einwohner{
  private int einkommen;

  public void setEinkommen(int einkommen){
    this.einkommen = einkommen;
  }

  public int zuVersteuerndesEinkommen(){
    return einkommen;
  }

  public int steuer(){
    int steuer = (int)(zuVersteuerndesEinkommen() * 0.1);
    if(steuer < 1){
      return 1;
    }
    return steuer;
  }

  public int getEinkommen(){
    return einkommen;
  }
}
