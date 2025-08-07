package com.example.booking.controller;

import com.example.booking.model.Booking;
import com.example.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    private List<String> chennaiRoutes = List.of(
        "Central", "Egmore", "Kilpauk", "Chetpet", "Nungambakkam",
        "Kodambakkam", "T Nagar", "Saidapet", "Guindy", "Alandur",
        "Airport", "Ashok Nagar", "Vadapalani", "Koyambedu", "Arumbakkam",
        "Anna Nagar East", "Anna Nagar Tower", "Thirumangalam", "Mogappair", "Ambattur","High Court", "Government Estate", "LIC", "Thousand Lights", "AG-DMS",
        "Teynampet", "Nandanam", "Saidapet", "Little Mount", "Guindy Metro",
        "Ekkatuthangal", "Ashok Nagar", "Meenambakkam", "Nanganallur Road",
        "St. Thomas Mount", "Washermanpet", "Mannadi", "Sir Theagaraya College",
        "Tondiarpet", "Tollgate", "Kaladipet", "Thiruvottiyur"
    );

    @ModelAttribute("routes")
    public List<String> getRoutes() {
        return chennaiRoutes;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBookings", bookingService.getAllBookings());
        return "index";
    }

    @GetMapping("/showNewBookingForm")
    public String showNewBookingForm(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "new_booking";
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute("booking") Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/";
    }
    
    @GetMapping("/saveBooking")
    public String handleGetSaveBooking() {
        return "redirect:/showNewBookingForm";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            model.addAttribute("errorMessage", "Booking ID not found.");
            return "error_page"; // custom error page
        }
        model.addAttribute("booking", booking);
        return "update_booking";
    }

    @GetMapping("/deleteBooking/{id}")
    public String deleteBooking(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot delete. Booking ID " + id + " not found.");
            return "redirect:/";
        }

        bookingService.deleteBooking(id);
        redirectAttributes.addFlashAttribute("successMessage", "Booking ID " + id + " deleted successfully.");
        return "redirect:/";
    }

}
