package local.umg.susersmvc.controller;

import local.umg.susersmvc.model.User;
import local.umg.susersmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    private UserService service;

    @Autowired
    public AppController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/list-user")
    public String getUsers(Model model) {
        List<User> userList = service.findAll();
        model.addAttribute("userList", userList);
        return "list_user";
    }

    @RequestMapping("/list-user-sort-id")
    public String getUsersSortById(Model model) {
        List<User> userList = service.findAllSortById();
        model.addAttribute("userList", userList);
        return "list_user";
    }

    @RequestMapping("/list-user-sort-firstname")
    public String getUsersSortByFirstName(Model model) {
        List<User> userList = service.findAllSortByFirstName();
        model.addAttribute("userList", userList);
        return "list_user";
    }

    @RequestMapping("/list-user-sort-lastname")
    public String getUsersSortByLastName(Model model) {
        List<User> userList = service.findAllSortByLastName();
        model.addAttribute("userList", userList);
        return "list_user";
    }

    @RequestMapping("/list-user-sort-email")
    public String getUsersSortByEmail(Model model) {
        List<User> userList = service.findAllSortByEmail();
        model.addAttribute("userList", userList);
        return "list_user";
    }

    @RequestMapping("/list-user-sort-upn")
    public String getUsersSortByUPN(Model model) {
        List<User> userList = service.findAllSortByUniquePersonNumber();
        model.addAttribute("userList", userList);
        return "list_user";
    }

    @RequestMapping("/list-user-sort-country")
    public String getUsersSortByCountry(Model model) {
        List<User> userList = service.findAllSortByCountry();
        model.addAttribute("userList", userList);
        return "list_user";
    }

    @RequestMapping("/new")
    public String showNewFormUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        service.create(user);
        return "redirect:/list-user";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditFormUser(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = service.find(id).orElseThrow();
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/list-user";
    }


}
