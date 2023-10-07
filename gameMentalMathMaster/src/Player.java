public class Player{
    int count;
    int corerct;
    private String name;
    void setName(String name){
        this.name = name;
    }
    String getNmae(){
        return this.name;
    }


    long statringPlayer(String nam){
        setName(nam);

        return System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return name;
    }
}
