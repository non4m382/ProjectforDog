
import java.util.Scanner;

public class MainPetDog {

    public static void main(String[] args) {
        MyPetDog p = new MyPetDog();
        Dog d = new Dog();
        System.out.println("********************************");
        System.out.println("Welcome to out Project for Dog"
                + "\n*by Group 4 SE1626*");
        System.out.println("\nA. Members:\n  1. Tran Thuy Trang\n  2. Nguyen Trong Duc  "
                + "\n  3. Luong Ngoc Anh\n  4. Ly Minh Nghia\n  5. Phan Duc Hoa");
        System.out.println("\nB. Our Dearest Teacher: \n"
                + "  Miss Trinh Thi Van Anh");
        System.out.println("********************************");
        while (true) {
            System.out.println("\n");
            System.out.println("1. List all PetDogs");
            System.out.println("2. Add a new PetDog");
            System.out.println("3. Remove a PetDog by ID");
            System.out.println("4. Save PetDogs to petdog.txt file");
            System.out.println("5. List all Dogs");
            System.out.println("6. Add a new Dog");
            System.out.println("7. Remove a dog by ID");
            System.out.println("8. Update a dog based on its ID");
            System.out.println("9. Save Dogs to dog.txt file");
            System.out.println("10. List all dogs in ascending order of dog names");
            System.out.println("11. List all dogs in ascending order of dog prices");
            System.out.println("12. Search dogs based on its color");
            System.out.println("13. Search dogs based on its prices, from price… to price..");
            System.out.println("0. exit");
            System.out.print("your choice (0 --> 13): ");
            Scanner in = new Scanner(System.in);
            int choice;
            choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("Bye!!!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("[1. List all PetDogs]");
                    p.listPetDog();
                    break;
                case 2:
                    System.out.println("[2. Enter a new PetDog]");
                    p.addPetDog();
                    break;
                case 3:
                    int id;
                    System.out.println("[3. Enter a PetID to remove a PetDog]");
                    System.out.print("Enter a PetID to remove: ");
                    try{
                    id = Integer.parseInt(in.nextLine());
                    p.removePetDog(id);
                    }catch(NumberFormatException e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("[4. Save all PetDogs to file petdog.txt]");
                    p.saveToPetDog();
                    break;
                case 5:
                    System.out.println("[5. List all Dogs]");
                    p.listDog();
                    break;
                case 6:
                    System.out.println("[6. Add a new Dog]");
//                    System.out.println("Enter a new dog");
                    p.addDog();
                    break; 
                case 7:
                    System.out.println("[7. Remove a Dog by ID]");
//                    System.out.println("Enter id to remove a Dog.");
                    try{
                        id = Integer.parseInt(in.nextLine());
                        p.removeDog(id);
                    }catch(NumberFormatException e){
                        System.out.println(e);
                    }
                    break;
                case 8:
                    System.out.println("[8. Update a dog based on ID]");
                    System.out.print("Enter ID to update Dog: ");
                    id = Integer.parseInt(in.nextLine());
                    p.updateDog(id);
                    break;
                case 9:
                    System.out.println("[9. Save all Dogs to dog.txt file]");
                    p.saveToDog();
                    break;
                case 10:
                    System.out.println("[10. List all dogs in ascending "
                            + "order of dog names]");
                    p.listDogAscendingName();
                    break;
                case 11:
                    System.out.println("[11. List all dogs in ascending "
                            + "order of dog prices]");
                    p.listDogAscendingPrice();
                    break;
                case 12:
                    System.out.println("[12. Search dogs based on its color]");
                    System.out.print("Enter color to find the Dog(s): ");
                    String color = in.nextLine();
                    p.searchColor(color);
                    break;
                case 13:
                    System.out.println("[13. Search dogs based on its prices, "
                            + "from price A to price B]");
                    System.out.print("Enter price A: ");
                    double priceA = Double.parseDouble(in.nextLine());
                    System.out.print("Enter price B: ");
                    double priceB = Double.parseDouble(in.nextLine());
                    p.searchFromPriceToPrice(priceA, priceB);
                    break;
                default:System.out.println("Only choose 0 --> 13");
            }
        }
    }
}
