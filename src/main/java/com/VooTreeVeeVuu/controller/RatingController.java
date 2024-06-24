package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.RatingDTO;
import com.VooTreeVeeVuu.usecase.RatingUsecase.CreateRating.CreateRatingImpl;
import com.VooTreeVeeVuu.usecase.RatingUsecase.DeleteRating.DeleteRatingImpl;
import com.VooTreeVeeVuu.usecase.RatingUsecase.GetAllRating.GetAllRatingImpl;
import com.VooTreeVeeVuu.usecase.RatingUsecase.GetRating.GetRatingImpl;
import com.VooTreeVeeVuu.usecase.RatingUsecase.UpdateRating.UpdateRatingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/ratings")
public class RatingController {
	@Autowired
	private CreateRatingImpl createRatingUseCase;
	@Autowired
	private UpdateRatingImpl updateRatingUseCase;
	@Autowired
	private DeleteRatingImpl deleteRatingUseCase;
	@Autowired
	private GetAllRatingImpl getAllRatingUseCase;
	@Autowired
	private GetRatingImpl getRatingUseCase;

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
