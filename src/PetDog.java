
import java.io.Serializable;


public class PetDog implements Serializable{
    private int petID;
    private String name;

    public PetDog() {
    }

    public PetDog(int petID, String name) {
        this.petID = petID;
        this.name = name;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    @Override
    public String toString(){
        return getPetID()+"\t"+getName();
    }
}
