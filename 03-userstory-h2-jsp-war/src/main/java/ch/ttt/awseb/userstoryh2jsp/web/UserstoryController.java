package ch.ttt.awseb.userstoryh2jsp.web;

import ch.ttt.awseb.userstoryh2jsp.business.UserstoryService;
import ch.ttt.awseb.userstoryh2jsp.data.Userstory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class UserstoryController {
    private final UserstoryService userstoryService;

    public UserstoryController(final UserstoryService userstoryService) {
        this.userstoryService = userstoryService;
    }

    @GetMapping("/list-userstories")
    public String showUserstories(final Model model, final Principal principal) {
        final List<Userstory> userstories = userstoryService.findByUsername(getUsername(principal));
        model.addAttribute("userstories", userstories);
        return "list-userstories";
    }

    @GetMapping("/add-userstory")
    public String showAddUserstoryPage(final Model model, final Principal principal) {
        model.addAttribute("userstory", new Userstory(null, getUsername(principal),
                "Default Desc", LocalDate.now(), false));
        return "userstory"; // TODO: add-userstory?
    }

    @PostMapping("/add-userstory")
    public String createUserstory(@Valid final Userstory userstory, final BindingResult result) {
        if (result.hasErrors()) {
            return "userstory";
        }

        userstoryService.update(userstory);
        return "redirect:/list-userstories";
    }

    @GetMapping("/update-userstory")
    public String showUpdateUserstoryPage(@RequestParam final Long id, final Model model) {
        final Userstory existing = userstoryService.findById(id);
        model.addAttribute("userstory", existing);
        return "userstory"; // TODO: update-userstory?
    }

    @PostMapping("/update-userstory") // TODO: PutMapping?
    public String updateUserstory(@Valid final Userstory userstory, final BindingResult result) {
        if (result.hasErrors()) {
            return "userstory";
        }
        userstoryService.update(userstory);
        return "redirect:/list-userstories";
    }

    @GetMapping("/delete-userstory") // TODO DeleteMapping?
    public String deleteUserstory(@RequestParam final Long id) {
        userstoryService.deleteById(id);
        return "redirect:/list-userstories";
    }

    private String getUsername(final Principal principal) {
        return principal.getName();
    }
}
