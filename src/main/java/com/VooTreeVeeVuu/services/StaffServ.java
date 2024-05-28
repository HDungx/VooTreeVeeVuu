package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StaffServ {
	public Page<Staff> getAll (Pageable pageable);

	public Optional<Staff> getStaffById (String id);

	public Staff save (Staff staff);

	public void deleteById (String id);
}
