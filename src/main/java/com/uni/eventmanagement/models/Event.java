package com.uni.eventmanagement.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "eventsdb")
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "description")
    @NotNull
    private String description;
    @Column(name = "eventtype")
    @NotNull
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @Column(name = "place")
    @NotNull
    private String place;
    @Column(name = "eventdate")
    @NotNull
    private LocalDateTime eventDate;
    @Column(name="participants_number")
    @NotNull
    private int participantsNumber = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Event event = (Event) o;
        return id != null && Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
