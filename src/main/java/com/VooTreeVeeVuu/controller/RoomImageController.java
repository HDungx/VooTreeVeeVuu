package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.domain.entity.HotelImage;
import com.VooTreeVeeVuu.domain.entity.RoomImage;
import com.VooTreeVeeVuu.domain.repository.RoomImageRepository;
import com.VooTreeVeeVuu.dto.RoomImageDTO;
import com.VooTreeVeeVuu.usecase.RoomImageUsecase.GetAllRoomImage.GetAllRoomImageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/room-images")
public class RoomImageController {
    @Autowired
    private GetAllRoomImageImpl getAllRoomImageUseCase;
	@Autowired
	private RoomImageRepository roomImageRepository;

    @GetMapping ()
    public List<RoomImageDTO> getAllRoomImages(){
        return getAllRoomImageUseCase.getAllRoomImage();
    }

    @GetMapping ("/{imageId}")
    public ResponseEntity<ByteArrayResource> getImage (@PathVariable Long imageId) {
        RoomImage image = roomImageRepository.findById(imageId).orElseThrow(
                () -> new RuntimeException("Image not found"));

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getImageType())).header(
                HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getImageName() + "\"").body(
                new ByteArrayResource(image.getImageBase64()));
    }

}
