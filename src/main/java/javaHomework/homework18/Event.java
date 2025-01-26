package javaHomework.homework18;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Event {
    private int eventId;
    @EqualsAndHashCode.Exclude
    private String userName;
    @EqualsAndHashCode.Exclude
    private String userIp;
    @EqualsAndHashCode.Exclude
    private LocalDate eventDate;
    @EqualsAndHashCode.Exclude
    private EventState eventState;
}
