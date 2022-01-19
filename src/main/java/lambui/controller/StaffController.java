package lambui.controller;

import lambui.model.Branch;
import lambui.model.Staff;
import lambui.service.IBranchService;
import lambui.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
public class StaffController {
    @Autowired
    IStaffService staffService;

    @Autowired
    IBranchService branchService;

    @GetMapping("/staffs")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("staffs", staffService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("staffs", new Staff());
        modelAndView.addObject("branch", branchService.findAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute(value = "staff") Staff staff, @RequestParam long idBranch){
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:/staffs";
    }
    @GetMapping ("/delete")
    public ModelAndView delete(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("staff" , staffService.findById(id) );
        return modelAndView;
    }
    @PostMapping ("/delete")
    public String deleteAlert(@RequestParam long id){
        staffService.delete(id);
        return "redirect:/staffs";
    }
    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("staffs", staffService.findById(id));
        modelAndView.addObject("branch", branchService.findAll());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editProduct(@ModelAttribute  Staff staff,  @RequestParam long idBranch) {
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);

        return "redirect:/staffs";
    }

    @PostMapping("/search")
    public ModelAndView searchByName(@RequestParam String search){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("staffs", staffService.searchByName(search));
        return modelAndView;
    }
    @GetMapping("/sortAge")
    public ModelAndView sortByAge(){
        ModelAndView modelAndView = new ModelAndView("show");
        List<Staff> staffList = staffService.sortByAge();
        modelAndView.addObject("staffs",staffList);
        return modelAndView;
    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("staffs",staffService.findById(id));
        return modelAndView;
    }

}
