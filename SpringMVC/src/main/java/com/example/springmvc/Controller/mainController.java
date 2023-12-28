package com.example.springmvc.Controller;

import com.example.springmvc.DataController.Programmer;
import com.example.springmvc.repository.ProgrammerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class mainController {
    @Autowired
    ProgrammerRepo pr;

@RequestMapping("/home")
public String HomePage(){
    return  "HomePage.html";
}

 // Way to set value to access other html file
//    @RequestMapping("/addProgrammer")
//    public String addProgammer(@RequestParam int pId, @RequestParam String pName,
//                               @RequestParam String plan, Model model){
//
//        model.addAttribute("pId",pId);
//        model.addAttribute("pName",pName);
//        model.addAttribute("plan",plan);
////        System.out.println(pId+" "+pName+" "+plan);
//        return  "ProgrammerInfo.html";
//    }

//
//    @RequestMapping("/addProgrammer")
//    public ModelAndView addProgammer(@RequestParam("pId") int id, @RequestParam("pName") String name,
//                                     @RequestParam("plan") String lan){
//           ModelAndView mv=new ModelAndView();
//           mv.setViewName("ProgrammerInfo.html");
//           mv.addObject("pId",id);
//        mv.addObject("pName",name);
//        mv.addObject("plan",lan);
//        return  mv;
//    }



//    @RequestMapping("/addProgrammer")
//    public ModelAndView addProgammer(@ModelAttribute Programmer programmer){
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("ProgrammerInfo.html");
//        return  mv;
//    }


//    @RequestMapping("/addProgrammer")
//    public String addProgammer(@ModelAttribute Programmer programmer){
//        return "ProgrammerInfo.html";
//    }
//@PostMapping("/addProgrammer")
//public String addProgammer(@ModelAttribute Programmer programmer){
//    return "ProgrammerInfo.html";
//}

//    @GetMapping("/allprogrammer")
//    public String allProgammer(Model m){
//        List<Programmer> p=new ArrayList<Programmer>();
//        p.add(new Programmer(1001,"raju","java"));
//        p.add(new Programmer(1002,"nayeem","Php"));
//        p.add(new Programmer(1003,"rana","Flutter"));
//        p.add(new Programmer(1004,"sourav","Flutter"));
//
//        m.addAttribute("programmers",p);
//        return "allprogrammer.html";
//
//    }

    @RequestMapping("/addProgrammer")
    public String addProgammer(@ModelAttribute Programmer programmer){
        pr.save(programmer);
        return "redirect:/home";
    }

    @PostMapping("/findById")
    public String findById(@RequestParam int pId,Model m){
    Programmer pm=pr.getOne(pId);

    m.addAttribute("programmer",pm);
        return "ProgrammerInfo.html";
    }


    @PostMapping("/findByplan")
    public String findByplan(@RequestParam String plan,Model m){
        List <Programmer> pm=pr.findByplan(plan);
        m.addAttribute("programmers",pm);
        return "allprogrammer.html";
    }


    @PostMapping("/findBypName")
    public String findPname(@RequestParam String pName,Model m){
        List <Programmer> pm=pr.findP(pName);
        m.addAttribute("programmers",pm);
        return "allprogrammer.html";
    }


    @GetMapping("/deleteProgrammer")
    public String deleteProgrammer(@RequestParam int pId,Model m){
      pr.deleteById(pId);
        return "redirect:/home";
    }




    @PostMapping("/updateProgrammer")
    public String updateProgammer(@ModelAttribute Programmer programmer){
        Programmer pm=pr.getOne(programmer.getpId());
        pm.setpName(programmer.getpName());
        pm.setPlan(programmer.getPlan());
        pr.save(pm);
        return "ProgrammerInfo.html";
    }



    @GetMapping("/user/alldata")
    public List<Programmer> getProgrammer(){

        return  pr.findAll();
    }


}
