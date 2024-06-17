package com.VooTreeVeeVuu.usecase.BookingUsecase.DeleteBooking;

import com.VooTreeVeeVuu.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteBookingImpl implements DeleteBooking{
    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public void deleteBooking(Long id){bookingRepository.deleteById(id);
    }
}
