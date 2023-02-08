package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("users.json");
        try {if(!file.exists()) {
            file.createNewFile();
        }
}catch (IOException e) {System.out.println("Cant create file" + e.getMessage());
            try {

               User value = objectMapper.readValue(file, User.class);
                users.add(value);

            }catch (IOException r){
                System.out.println("Cant read from file" + r.getMessage());
            }

        }
        Main main = new Main();
        main.menu();
        main.action(scanner, users, objectMapper, file);
    }
    public void menu(){
        System.out.println("""
                1. Register
                2. Show all users
                3. Exit
                """);
    }
    private void action(Scanner scanner, List<User>users, ObjectMapper mapper, File file){
        String userInput = scanner.nextLine();
        switch(userInput){
            case "1" -> register(scanner, users, mapper,file );

            case "2" -> System.out.println(users);
            case "3" -> System.out.println("baigti programa");
            default -> System.out.println("Netinkama ivestis");
        }
    }
    private void register (Scanner scanner, List<User> users, ObjectMapper mapper, File file){
        System.out.println("Iveskite varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde");
        String surname =scanner.nextLine();
        System.out.println("Iveskite asmens koda");
        String personId = scanner.nextLine();
        User user = new User(name, surname, personId);
        users.add(user);
try {mapper.writeValue(file, users);
}catch (IOException e){
    System.out.println("Cant write to file" + e.getMessage());
}
           }

}