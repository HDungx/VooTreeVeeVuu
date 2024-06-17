package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.RatingDTO;
import com.VooTreeVeeVuu.usecase.RatingUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/ratings")
public class RatingController {
	@Autowired
	private CreateRatingUseCase createRatingUseCase;
	@Autowired
	private UpdateRatingUseCase updateRatingUseCase;
	@Autowired
	private DeleteRatingUseCase deleteRatingUseCase;
	@Autowired
	private GetAllRatingUseCase getAllRatingUseCase;
	@Autowired
	private GetRatingUseCase getRatingUseCase;

	@GetMapping ()
	public List<RatingDTO> getAllRating(){
		return getAllRatingUseCase.getAllRatings();
	}

	@GetMapping ("/{id}")
	public Optional<RatingDTO> getRatingById (@PathVariable Long id){
		return getRatingUseCase.getRatingById(id);
	}

	@PostMapping
	public RatingDTO createRating(@RequestBody RatingDTO dto) {
		return createRatingUseCase.createRating(dto);
	}

	@PutMapping ("/update/{id}")
	public Optional<RatingDTO> updateRating (@RequestBody RatingDTO dto, @PathVariable Long id) {
		return updateRatingUseCase.updateRatings(id,dto);
	}

	@DeleteMapping ("/delete/{id}")
	public void deleteRating (@PathVariable Long id) {
		deleteRatingUseCase.deleteRating(id);
	}


//	@GetMapping ("/search/{keyword}")
//	public ResponseEntity<Page<Rating>> getRatingByCusIDorHotelID (@PathVariable String keyword, Pageable pageable) {
//		return ratingServImp.getByCusIDorHotelID(keyword, pageable).map(
//				r -> new ResponseEntity<>(r, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//	}

}
