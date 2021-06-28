
public interface IDog {

    public void listPetDog();

    public void addPetDog();

    public void removePetDog(int ID);

    public void saveToPetDog();

    public void listDog();

    public void addDog();

    public void removeDog(int DogID);

    public void updateDog(int DogID);

    public void saveToDog();

    public void listDogAscendingName();

    public void listDogAscendingPrice();

    public void searchColor(String color);

    public void searchFromPriceToPrice(double priceA, double priceB);
}
