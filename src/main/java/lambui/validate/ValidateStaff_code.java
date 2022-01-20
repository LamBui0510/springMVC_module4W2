package lambui.validate;

import lambui.model.Staff;
import lambui.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component

public class ValidateStaff_code implements Validator {
    @Autowired
    IStaffService iStaffService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    Staff staff = (Staff) target; //ép kiểu về đtg object trong vld
        List<Staff> staffList = iStaffService.findAll();
        for (Staff s: staffList) {
            if (staff.getStaff_code().equals(s.getStaff_code())){
                errors.rejectValue("staff_code","","Staff_code already exist!");
                return;
            }
        }
    }
}
