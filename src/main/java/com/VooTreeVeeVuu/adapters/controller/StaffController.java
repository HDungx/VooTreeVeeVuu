package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.domain.entity.Staff;
import com.VooTreeVeeVuu.servicesImp.StaffServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/staffs")
public class StaffController {
//	@Autowired
//	StaffServImp staffServImp;

//	@GetMapping ()
//	public Page<Staff> getAllStaff (@RequestParam (defaultValue = "0") int page,
//	                                @RequestParam (defaultValue = "10") int size,
//	                                @RequestParam (defaultValue = "staffId") String sortBy,
//	                                @RequestParam (defaultValue = "asc") String dir) {
//		Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//		Pageable pageable = PageRequest.of(page, size, sort);
//		return staffServImp.getAll(pageable);
//	}

//	@GetMapping ()
//	public ResponseEntity<List<Staff>> getAllStaffs () {
//		return new ResponseEntity<>(staffServImp.getAll(), HttpStatus.OK);
//	}
//
//	@GetMapping ("/{id}")
//	public ResponseEntity<Staff> getStaffById (@PathVariable Long id) {
//		return staffServImp.getStaffById(id).map(staff -> new ResponseEntity<>(staff, HttpStatus.OK)).orElse(
//				new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}
//
//	@PostMapping
//	public ResponseEntity<Staff> createStaff (@RequestBody Staff staff) {
//		return new ResponseEntity<>(staffServImp.save(staff), HttpStatus.CREATED);
//	}
//
//	@PutMapping ("/update/{id}")
//	public ResponseEntity<Staff> updateStaff (@RequestBody Staff staff, @PathVariable Long id) {
//		return staffServImp.getStaffById(id).map(st -> {
//			st.setFirstName(staff.getFirstName());
//			st.setLastName(staff.getLastName());
//			st.setEmail(staff.getEmail());
//			st.setGender(staff.getGender());
//			st.setPhoneNum(staff.getPhoneNum());
//			return new ResponseEntity<>(staffServImp.save(st), HttpStatus.OK);
//		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}
//
//	@DeleteMapping ("/delete/{id}")
//	public ResponseEntity<Void> deleteStaff (@PathVariable Long id) {
//		return staffServImp.getStaffById(id).map(staff -> {
//			staffServImp.deleteById(id);
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}
}
