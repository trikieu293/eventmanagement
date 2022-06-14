package services;

import dto.HomeEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import repositories.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@SessionScope
public class HomeService {

    private final EventRepository eventRepository;

    @Autowired
    public HomeService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<HomeEventDTO> findAll() {
        return eventRepository.findAll().stream().map(event -> {
            HomeEventDTO homeEventDTO = new HomeEventDTO(event);
            return homeEventDTO;
        }).collect(Collectors.toList());
    }
}
