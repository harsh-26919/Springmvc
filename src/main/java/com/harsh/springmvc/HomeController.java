package com.harsh.springmvc;

import com.harsh.springmvc.Dao.AlienDao;
import com.harsh.springmvc.Model.Aliens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String home()
    {
        return "index";
    }
//    @RequestMapping("/add")
//    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m)
//    {
//        1) servlet method (for this we need that httprequest object req and from that we can fetch value of the twio numbers that are submitted from the form by the user using get parameter as stated below)
//        int i = Integer.parseInt(req.getParameter("num1"));
//        int j = Integer.parseInt(req.getParameter("num2"));
//
//        int num3 = i + j;
//        HttpSession session = req.getSession();
//        session.setAttribute("result", num3);
//        2) In Spring we already get the HttpRequest object and the session object so that we don't need req.getsession()
//        int num3 = i + j;
//        sesssion.setAttribute("result", num3);
//        return "result.jsp";
//        3) But alos i dont need that HttpSession object i need to remove that httpSession object and we can do this by ModelAndView Object
//        ModelAndView mv = new ModelAndView("result");
//        int num3 = i + j;
//        mv.addObject("result",num3);
//        return mv;
//        4) instead of modelview we can use model and ModelMap object as well to store the data in the model object and then we can use the model object in the jsp file but the return type is String only.
//        now we need to create the model
//        m.addAttribute("result", i + j);
//        return "result";
//        5)we can also use Model Attribute to store the data in the model object and then we can use the model object in the jsp file.
//    @RequestMapping("/addAlien")
//    public String addAlien(@ModelAttribute("a1") Aliens a)//no need of @RequestParam object as we are using the model attribute
//    {
//        return "result";
//    }
//    6)ModelAttribute at method level
//@ModelAttribute
//public void modelData(Model m)
//{
//    m.addAttribute("name", "Aliens");
//}
//    7)Working on Spring ORM

    @Autowired
    private AlienDao dao;

    @GetMapping("/getaliens")
    public String getaliens(Model m)
    {
        m.addAttribute("alien", dao.getAliens());
        return "showAliens";
    }

    @RequestMapping("/addAlien")
    public String addAlien(@ModelAttribute("result") Aliens a)//no need of @RequestParam object as we are using the model attribute
    {
        dao.addAliens(a);
        return "showAliens";
    }
    @GetMapping("/getAlien")
    public String getAlien(@RequestParam("aid") int aid,Model m)
    {
        m.addAttribute("alien", dao.getAlien(aid));
        return "showAliens";
    }
}
