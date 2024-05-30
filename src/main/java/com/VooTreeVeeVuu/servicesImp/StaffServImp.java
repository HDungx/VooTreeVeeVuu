package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Staff;
import com.VooTreeVeeVuu.repository.StaffRepository;
import com.VooTreeVeeVuu.services.StaffServ;
import com.VooTreeVeeVuu.utils.AlphaNumComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServImp implements StaffServ {
	@Autowired
	StaffRepository staffRepository;

	//	@Override
//	public Page<Staff> getAll (Pageable pageable) {
//		List<Staff> list = staffRepository.findAll();
//		List<Staff> sortedList = list.stream().sorted(
//				(p1, p2) -> new AlphaNumComparator().compare(p1.getStaffId(), p2.getStaffId())).toList();
//		int total = sortedList.size();
//		List<Staff> pageProj = sortedList.stream().skip(
//				(long) pageable.getPageNumber() * pageable.getPageSize()).limit(pageable.getPageSize()).toList();
//		return new PageImpl<>(pageProj, pageable, total);
//	}
	@Override
	public Page<Staff> getAll (Pageable pageable) {
		return staffRepository.findAll(pageable);
	}

	@Override
	public List<Staff> getAll () {
		return staffRepository.findAll();
	}

	@Override
	public Optional<Staff> getStaffById (String id) {
		if (id != null)
		{
			return staffRepository.findById(id);
		} else
		{
			return Optional.empty();
		}
	}

	@Override
	public Staff save (Staff staff) {
		return staffRepository.save(staff);
	}

	@Override
	public void deleteById (String id) {
		staffRepository.deleteById(id);
	}
}
