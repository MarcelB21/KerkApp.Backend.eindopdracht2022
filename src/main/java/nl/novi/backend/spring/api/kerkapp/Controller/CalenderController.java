package nl.novi.backend.spring.api.kerkapp.Controller;

import nl.novi.backend.spring.api.kerkapp.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CalenderController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping(value="/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value="/staticcalendar", method=RequestMethod.GET)
    public ModelAndView staticcalendar() {
        return new ModelAndView("staticcalendar");
    }

    @RequestMapping(value="/calendar", method=RequestMethod.GET)
    public ModelAndView calendar() {
        return new ModelAndView("calendar");
    }

    @RequestMapping(value="/jsoncalendar", method=RequestMethod.GET)
    public ModelAndView jsoncalendar() {
        return new ModelAndView("jsoncalendar");
    }

    @RequestMapping(value="/eventlist", method=RequestMethod.GET)
    public String events(HttpServletRequest request, Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }
}
