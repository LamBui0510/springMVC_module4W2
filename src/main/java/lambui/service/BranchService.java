package lambui.service;

import lambui.model.Branch;
import lambui.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BranchService implements IBranchService{
    @Autowired
    BranchRepo branchRepo;
    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepo.findAll();
    }
}
