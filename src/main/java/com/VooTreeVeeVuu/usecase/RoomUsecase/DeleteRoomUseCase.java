package com.VooTreeVeeVuu.usecase.RoomUsecase;


import com.VooTreeVeeVuu.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteRoomUseCase {
    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }
}
