package lambui.service;

import lambui.model.Staff;
import lambui.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class StaffService implements IStaffService{
    @Autowired
    StaffRepo staffRepo;

    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepo.findAll();
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepo.findAll(pageable);
    }


    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);

    }

    @Override
    public void delete(long id) {
    staffRepo.deleteById(id);
    }

    @Override
    public Staff findById(long id) {
        return staffRepo.findById(id).get();
    }

    @Override
    public Staff searchByName(String searchName) {
        for (Staff s: findAll()) {
            if (s.getName().toUpperCase(Locale.ROOT).contains(searchName.toUpperCase(Locale.ROOT))) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Staff> sortByAge() {
        List<Staff> staffList = findAll();
        staffList.sort(Comparator.comparing(Staff::getAge));
        return staffList;
    }
}


