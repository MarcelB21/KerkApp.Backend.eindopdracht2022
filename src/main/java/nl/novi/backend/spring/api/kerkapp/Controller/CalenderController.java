package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CalenderController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping(value="/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping(value="/calendar/staticcalendar")
    public ModelAndView staticcalendar() {
        return new ModelAndView("staticcalendar");
    }

    @GetMapping(value="/calendar")
    public ModelAndView calendar() {
        return new ModelAndView("calendar");
    }

    @GetMapping(value="/calendar/jsoncalendar")
    public ModelAndView jsoncalendar() {
        return new ModelAndView("jsoncalendar");
    }

    @GetMapping(value="/calendar/eventlist")
    public String events(HttpServletRequest request, Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }
}
