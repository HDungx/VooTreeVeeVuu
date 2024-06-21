package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
//	@Query("SELECT h, SUM(CASE WHEN r.quantity - COALESCE(br.numBooked, 0) >= :quantity THEN 1 ELSE 0 END) AS numValidRooms " +
//			"FROM Hotel h " +
//			"JOIN Room r ON h.id = r.hotel.id " +
//			"LEFT JOIN (SELECT b.room.id AS roomId, COUNT(*) AS numBooked " +
//			"           FROM Booking b " +
//			"           WHERE b.checkInDate <= :checkOut AND b.checkOutDate >= :checkIn " +
//			"           GROUP BY b.room.id) br ON r.id = br.roomId " +
//			"WHERE (:searchTerm IS NULL OR h.hotelName LIKE :searchTerm OR h.city LIKE :searchTerm) " +
//			"AND (:capacity IS NULL OR r.capacity >= :capacity) " +
//			"GROUP BY h.id, h.hotelName, h.city, h.address, h.checkInTime, h.checkOutTime, h.description, h.hotelPhoneNum, h.hotelStars, h.status, h.userId, h.typeId " +
//			"HAVING SUM(CASE WHEN r.quantity - COALESCE(br.numBooked, 0) >= :quantity THEN 1 ELSE 0 END) > 0")
//	List<Hotel> searchHotels(
//			@Param("searchTerm") String searchTerm,
//			@Param("capacity") Integer capacity,
//			@Param("checkIn") LocalDate checkIn,
//			@Param("checkOut") LocalDate checkOut,
//			@Param("quantity") Integer quantity);
	
	List<Hotel> findByHotelName (String hotelName);

	List<Hotel> findByCity (String city);
}