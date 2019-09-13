public abstract class Part {
    private String id ;
    private String name;

    public Part(String id, String name){
        if (id == null || name == null){
            throw new NullPointerException("part attributes is null");
        }else if(name == "" || id == ""){
            throw new IllegalArgumentException("id or name is empty");
        }
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
