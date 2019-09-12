package com.jnshu.crq.action;

import com.jnshu.crq.model.Profess;
import com.jnshu.crq.model.ProfessType;
import com.jnshu.crq.model.User;
import com.jnshu.crq.service.ProfessService;
import com.jnshu.crq.service.ProfessTypeService;
import com.jnshu.crq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/jnshu")
public class JnshuController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfessService professService;

    @Autowired
    private ProfessTypeService professTypeService;

    @GetMapping("/home")
    public String home(Model model){
        List<User> list = new ArrayList<>();
        list = userService.getUserList();
//        list.sort();
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result =  o1.getSalary()>o2.getSalary()?-1:(o1.getSalary()==o2.getSalary()?0:1);
                if(result==0){
                    result = o1.getName().compareTo(o2.getName());
                }
                return result;
            }
        });
        System.out.println(list);
        if(list.size()>4){
            model.addAttribute("userList",list.subList(0,4));
        }else{
            model.addAttribute("userList",list);
        }
        return "home.page";
    }

    @GetMapping("/profess")
    public String profess(Model model){
        List<ProfessType> typeList = new ArrayList<>();
        List<Profess> proList = new ArrayList<>();
        typeList = professTypeService.getProfessTypeList();
        proList = professService.getProfessList();
        model.addAttribute("proTypeList",typeList);
        model.addAttribute("proList",proList);
        return "profession.page";
    }
}
