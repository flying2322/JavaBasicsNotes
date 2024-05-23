import com.example.protos.addressbook.Person;

public class Main {
    public static void main(String[] args) {
        Person message = Person.newBuilder()
            .setId(1)
            .setName("Example")
            .build();

        System.out.println(message);
    }
}
