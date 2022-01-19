package lambui.repository;

import lambui.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StaffRepo extends PagingAndSortingRepository<Staff,Long> {
}
