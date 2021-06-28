
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MyPetDog implements IDog {

    List<PetDog> list;
    List<Dog> l2;
    Scanner in;
    Random random = new Random();

    public MyPetDog() {
        list = new ArrayList();
        l2 = new ArrayList();
        in = new Scanner(System.in);
    }

    String file = "src/petdog.txt";
    String f2 = "src/dog.txt";

    @Override
    public void listPetDog() {
//        System.out.println("ID PetName");
        System.out.println("ID\tPetName");
        System.out.println("----------------------");
        list = IOFile.read(file);
        for (PetDog i : list) {
            System.out.println(i);
        }
        System.out.println("----------------------");
    }

    @Override
    public void addPetDog() {
        list = IOFile.read(file);
        PetDog p = new PetDog();
        int id;
        String name;
        while (true) {
            System.out.print("Enter id: ");
            id = Integer.parseInt(in.nextLine());
            if (searchByPetDogID(id) >= 0) {
                System.err.println("Existed!!!");
            } else {
                p.setPetID(id);
                break;
            }
        }
        while (true) {
            System.out.print("Enter name: ");
            name = in.nextLine();
            if ("".equals(name)) {
                System.err.println("PetDog name cannot be blank!");
            } else {
                p.setName(name);
                break;
            }
        }
        list.add(p);
        IOFile.write(file, list);
        System.out.println("[Add successfully!!!!]");
        System.out.println("----------------------");
    }

    public int searchByPetDogID(int id) {
//        list = IOFile.read(file);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPetID() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removePetDog(int ID) {
        list = IOFile.read(file);
        int pos = searchByPetDogID(ID);
        if (pos < 0) {
            System.err.println("No PetDog with ID = " + ID);
            System.out.println("----------------------");
        } else {
            // tim thay
            list.remove(pos);
            IOFile.write(file, list);
            System.out.println("[Remove successfully!!!!]");
            System.out.println("----------------------");
        }
    }

    @Override
    public void saveToPetDog() {
        IOFile.write(file, list);
        System.out.println("[Save successfully!!!!]");
        System.out.println("----------------------");
    }

    /////////////////////////////////////////
    /* Dog Dog Dog Dog Dog
    
    
    
    
    
     */
    /////////////////////////////////////////
    @Override
    public void listDog() {
//        System.out.println("ID DogID DogName DogColor DogGender Price Describe");
        System.out.println("ID\tDogID\tName\tColor\tGender\tPrice\tDescribe");
        System.out.println("------------------------------------");
        l2 = IOFile.read(f2);
        for (Dog i : l2) {
            System.out.println(i);
        }
        System.out.println("------------------------------------");
    }

    public int searchBydogID(int id) {
//        l2 = IOFile.read(f2);
        for (int i = 0; i < l2.size(); i++) {
            if (l2.get(i).getDogID() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void addDog() {
        l2 = IOFile.read(f2);
        Dog d = new Dog();
        int id;
        int PetID;
        String name;
        String dogColor;
        boolean dogGender;
        double price;
        String describe;
        Random random = new Random();

        while (true) {
            System.out.print("a. Random id: ");
            id = Integer.parseInt(String.format("%4d", random.nextInt(10000)));
            if (searchBydogID(id) >= 0) {
                System.err.println("Existed!!");
            } else {
                System.out.println(id);
                break;
            }
        }

        list = IOFile.read(file);
        int[] something = new int[list.size()];
        int c = 0;
        for (PetDog i : list) {
            something[c] = i.getPetID();
            c++;
        }
        // enter id in the list PetID
        while (true) {
            boolean test = false;
            System.out.print("b. Enter pet id in range " + Arrays.toString(something) + ": ");
            PetID = Integer.parseInt(in.nextLine());
            for (int i = 0; i < c; i++) {
                if (something[i] == PetID) {
                    test = true;
                    break;
                }
            }
            if (test == true) {
                break;
            } else {
                System.err.println("[Enter id again, only id in the range!!!]");
            }
        }
        // enter name
        System.out.print("c. Enter name: ");
        name = in.nextLine();
        // enter DogColor
        while (true) {
            System.out.print("d. Enter dog color: ");
            dogColor = in.nextLine();
            if ("".equals(dogColor)) {
                System.err.println("DogColor cannot be blank!");
            } else {
                break;
            }
        }
        // enter gender
        System.out.print("e. Enter gender (true or false): ");
        dogGender = Boolean.parseBoolean(in.nextLine());

        // enter price
        System.out.print("f. Enter price: ");
        price = Double.parseDouble(in.nextLine());

        // enter describe
        System.out.print("g. Enter describe: ");
        describe = in.nextLine();
        
        // save new Dog to file
        l2.add(new Dog(id, PetID, name, dogColor, dogGender, price, describe));
        IOFile.write(f2, l2);
        System.out.println("[Add successfully!!!!]");
        System.out.println("----------------------");
    }

    @Override
    public void removeDog(int ID) {
        l2 = IOFile.read(f2);
        int vt = searchBydogID(ID);
        if (vt < 0) {
            System.err.println("No dog with id = " + ID);
            return;
        } else {
            l2.remove(vt);
            IOFile.write(f2, l2);
        }
        System.out.println("[Remove successfully!!!]");
        System.out.println("----------------------");
    }

    @Override
    public void updateDog(int ID) {
        l2 = IOFile.read(f2);
        int vt = searchBydogID(ID);

        if (vt < 0) {
            // if ID not found, print error
            System.err.println("No dog with id = " + ID);

        } else {
            // found
            Dog d = l2.get(vt);
            // new Dog ID
            System.out.print("a. Enter new DogID: ");
            int PetID = Integer.parseInt(in.nextLine());
            d.setPetID(PetID);
            // update name
            System.out.print("b. Enter new name: ");
            String name = in.nextLine();
            d.setName(name);
            // update color
            while (true) {
                System.out.print("c. Enter new color: ");
                String DogColor = in.nextLine();
                if ("".equals(DogColor)) {
                    System.err.println("PetDog name cannot be blank!");
                } else {
                    d.setDogColor(DogColor);
                    break;
                }
            }
            // update gender
            System.out.print("d. Enter new gender (true/false): ");
            boolean b = Boolean.parseBoolean(in.nextLine());
            d.setDogGender(b);
            // update price
            System.out.print("e. Enter new price: ");
            double p = Double.parseDouble(in.nextLine());
            d.setPrice(p);
            // update describe
            System.out.print("f. Enter new describe: ");
            String describe = in.nextLine();
            d.setDescribe(describe);
            // save new update to file
            IOFile.write(f2, l2);
            System.out.println("[Update Dog successfully!!!]");
            System.out.println("----------------------------");
        }
    }

    @Override
    public void saveToDog() {
        IOFile.write(f2, l2);
        System.out.println("[Save successfully!!!]");
        System.out.println("----------------------");
    }

    @Override
    public void listDogAscendingName() {
        l2 = IOFile.read(f2);
        Collections.sort(l2, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        System.out.println("List all dogs in ascending order of dog names");
//        System.out.println("ID DogID DogName DogColor DogGender Price Describe");
        System.out.println("ID\tDogID\tName\tColor\tGender\tPrice\tDescribe");
        System.out.println("-------------------------------------------");
        for (Dog i : l2) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------------");
    }

    @Override
    public void listDogAscendingPrice() {
        l2 = IOFile.read(f2);
        Collections.sort(l2, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        System.out.println("List all dogs in ascending order of dog prices");
//        System.out.println("ID DogID DogName DogColor DogGender Price Describe");
        System.out.println("ID\tDogID\tName\tColor\tGender\tPrice\tDescribe");
        System.out.println("-------------------------------------------");
        for (Dog i : l2) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------------");
    }

    @Override
    public void searchColor(String color) {
        l2 = IOFile.read(f2);
//        System.out.println("ID DogID DogName DogColor DogGender Price Describe");
        System.out.println("ID\tDogID\tName\tColor\tGender\tPrice\tDescribe");
        System.out.println("-------------------------------------------");
        for (Dog i : l2) {
            if (i.getDogColor().equalsIgnoreCase(color)) {
                System.out.println(i);
            }
        }
        System.out.println("-------------------------------------------");

    }

    @Override
    public void searchFromPriceToPrice(double priceA, double priceB) {
        l2 = IOFile.read(f2);
//        System.out.println("ID DogID DogName DogColor DogGender Price Describe");
        System.out.println("ID\tDogID\tName\tColor\tGender\tPrice\tDescribe");
        System.out.println("-------------------------------------------");
        for (Dog i : l2) {
            if ((priceA) <= (i.getPrice())
                    && (i.getPrice()) <= (priceB)) {
                System.out.println(i);
            }
        }
        System.out.println("-------------------------------------------");
    }
}
