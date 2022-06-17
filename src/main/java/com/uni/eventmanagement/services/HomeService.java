package com.uni.eventmanagement.services;

import com.uni.eventmanagement.dto.HomeEventDTO;
import com.uni.eventmanagement.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import com.uni.eventmanagement.repositories.EventRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

    private final EventRepository eventRepository;

    @Autowired
    public HomeService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<HomeEventDTO> findAll() {
        List<Event> dbList = eventRepository.findAll();
        List<HomeEventDTO> listForHomepage = new ArrayList<>();
        for ( Event e : dbList) {
            listForHomepage.add(new HomeEventDTO(e));
        }
        return listForHomepage;
    }

    public List<HomeEventDTO> getUpcomingList() {
        List<HomeEventDTO> listForHomepage = findAll();
        listForHomepage.sort(Comparator.comparing(event->event.getParticipantsNumber()));
        return listForHomepage.stream()
                .filter(event -> event.getRemainingTime() > 0)
                .limit(3)
                .toList();
    }
    public List<HomeEventDTO> getSidebarList() {
        List<HomeEventDTO> listForHomepage = findAll();
        listForHomepage.sort(Comparator.comparing(event-> -event.getParticipantsNumber()));
        return listForHomepage.stream()
                .limit(10)
                .toList();
    }
}
