


public class Dog extends PetDog implements Comparable<Dog>{
    public int DogID;
    public String dogColor;
    public boolean dogGender;
    public double price;
    public String describe;

    public Dog() {
    }

    public Dog(int DogID, int petID, String name, String dogColor, 
            boolean dogGender, double price, String describe) {
        super(petID, name);
        this.DogID = DogID;
        this.dogColor = dogColor;
        this.dogGender = dogGender;
        this.price = price;
        this.describe = describe;
    }

    public int getDogID() {
        return DogID;
    }

    public void setDogID(int DogID) {
        this.DogID = DogID;
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    public boolean isDogGender() {
        return dogGender;
    }

    public void setDogGender(boolean dogGender) {
        this.dogGender = dogGender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    
    @Override
    public String toString(){
        return getDogID()+"\t"+super.getPetID()+"\t"+getName()+"\t"+getDogColor()+
                "\t"+(dogGender?"duc":"cai")+"\t"+getPrice()+"\t"+getDescribe();
    }

    @Override
    public int compareTo(Dog t) {
        if(t.getPrice() > price)
            return 1;
        else{
            if (t.getPrice() == price)
                return 0;
            else
                return -1;
        }
    }
}
