package com.VooTreeVeeVuu.usecase.BookingUsecase;

import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DeleteBookingUseCase {
    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public void deleteBooking(String id){bookingRepository.deleteById(id);
    }
}
