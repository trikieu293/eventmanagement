package dto;

import lombok.Data;
import models.Event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
public class HomeEventDTO implements Serializable {
    private String name;
    private String description;
    private LocalDateTime eventDate;
    private boolean isSelected;

    public HomeEventDTO(Event event) {
        this.name = event.getName();
        this.description = event.getDescription();
        this.eventDate = event.getEventDate();
        this.isSelected = false;
    }

    // calculate the remaining time for filtering and sorting
    public long getRemainingTime() {
        long remainingTime = LocalDateTime.now().until(eventDate, ChronoUnit.DAYS);
        return remainingTime;
    }

}
