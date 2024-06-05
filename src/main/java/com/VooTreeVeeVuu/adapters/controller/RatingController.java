package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.domain.entity.Rating;
import com.VooTreeVeeVuu.servicesImp.RatingServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/ratings")
public class RatingController {
	@Autowired
	RatingServImp ratingServImp;

//	@GetMapping ()
//	public Page<Rating> getAllRating (@RequestParam (defaultValue = "0") int page,
//	                                  @RequestParam (defaultValue = "10") int size,
//	                                  @RequestParam (defaultValue = "customerId") String sortBy,
//	                                  @RequestParam (defaultValue = "asc") String dir) {
//		Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//		Pageable pageable = PageRequest.of(page, size, sort);
//		return ratingServImp.getAll(pageable);
//	}

	@GetMapping ()
	public ResponseEntity<List<Rating>> getAllRatings () {
		return new ResponseEntity<>(ratingServImp.getAll(), HttpStatus.OK);
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Rating> getRatingById (@PathVariable Integer id) {
		return ratingServImp.getById(id).map(r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(
				new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping ("/search/{keyword}")
	public ResponseEntity<Page<Rating>> getRatingByCusIDorHotelID (@PathVariable String keyword, Pageable pageable) {
		return ratingServImp.getByCusIDorHotelID(keyword, pageable).map(
				r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Rating> createRating (@RequestBody Rating rating) {
		return new ResponseEntity<>(ratingServImp.save(rating), HttpStatus.CREATED);
	}

	@PutMapping ("/update/{id}")
	public ResponseEntity<Rating> updateRating (@RequestBody Rating rating, @PathVariable Integer id) {
		return ratingServImp.getById(id).map(r -> {
			r.setRate(rating.getRate());
			r.setComment(rating.getComment());
			r.setCustomer(rating.getCustomer());
			r.setHotel(rating.getHotel());
			return new ResponseEntity<>(ratingServImp.save(r), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<Void> deleteRating (@PathVariable Integer id) {
		return ratingServImp.getById(id).map(r -> {
			ratingServImp.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
