package com.VooTreeVeeVuu.adapters.controller;
import com.VooTreeVeeVuu.adapters.dto.AccommodationTypeDTO;
import com.VooTreeVeeVuu.domain.entity.AccommodationType;
import com.VooTreeVeeVuu.domain.repository.AccommodationTypeRepository;
import com.VooTreeVeeVuu.usecase.AccommodationTypeUsecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/accommodationTypes")
public class AccommodationTypeController {
    @Autowired
    private CreateAccommodationTypeUseCase createAccommodationTypeUsecase;

     @Autowired
    private UpdateAccommodationTypeUseCase updateAccommodationTypeUsecase;

     @Autowired
    private DeleteAccommodationTypeUseCase deleteAccommodationTypeUsecase;

     @Autowired
    private GetAllAccommodationTypeUseCase getAllAccommodationTypeUsecase;

     @Autowired
    private GetAccommodationTypeUseCase getAccommodationTypeUsecase;

     @GetMapping()
    public List<AccommodationTypeDTO> getAllAccommodationTypeDTOS(){
         return getAllAccommodationTypeUsecase.getAllAccommodationTypeDTOS();
     }

    @GetMapping ("/{id}")
    public Optional<AccommodationTypeDTO> getAccommodationType (@PathVariable String id){
         return getAccommodationTypeUsecase.getAccommodationTypeById(id);
    }

    @PostMapping
    public AccommodationTypeDTO createTypeDTO (@RequestBody AccommodationTypeDTO dto) {
        return createAccommodationTypeUsecase.createAccommodationType(dto);
    }

    @PutMapping ("/{id}")
    public Optional<AccommodationTypeDTO> updateTypeDTO (@RequestBody AccommodationTypeDTO dto, @PathVariable String id) {
        return updateAccommodationTypeUsecase.updateAccommodationTypeDTO(id,dto);
    }

    @DeleteMapping ("/{id}")
    public void deleteTypeDTO (@PathVariable String id) {
        deleteAccommodationTypeUsecase.deleteAccommodationType(id);
    }




}
