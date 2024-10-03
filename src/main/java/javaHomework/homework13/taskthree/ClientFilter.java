package javaHomework.homework13.taskthree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ClientFilter {
    public static void main(String[] args) {
        Client alex = new Client(1, "Alex", (byte) 28, Arrays.asList(
                new Phone(true)
        ));
        Client rex = new Client(2, "Rex", (byte) 36, Arrays.asList(
                new Phone(true),
                new Phone(false)
        ));
        Client john = new Client(3, "John", (byte) 61, Arrays.asList(
                new Phone(true)
        ));
        Client clifford = new Client(4, "Clifford", (byte) 61, Arrays.asList(
                new Phone(true),
                new Phone(false)
        ));
        Comparator<Client> sortByAge = (s1, s2) -> s1.getAge() - s2.getAge();

        Optional<Client> optionalClient = Stream.of(alex, rex, john, clifford).
                filter(client -> client.phoneList.stream().
                        anyMatch(phone -> !phone.getIsPortable())).
                max(sortByAge);
        System.out.println(optionalClient.orElse(null));
    }
}
