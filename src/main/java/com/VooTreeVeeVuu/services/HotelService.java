package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.*;
import com.VooTreeVeeVuu.domain.repository.*;
import com.VooTreeVeeVuu.dto.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelFacilityRepository hotelFacilityRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private RoomFacilityRepository roomFacilityRepository;

    @Autowired
    private UserRepository userRepository;

    public List<GetAllHotelDTO> getAllHotelByUser(Long id) {
        //User partner = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Partner not found"));
        return hotelRepository.findByUserId(id).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public HotelDTO createHotel(HotelDTO hotelDTO) {
        Hotel hotel = mapToHotelEntity(hotelDTO);
        Hotel savedHotel = hotelRepository.save(hotel);

        if (hotelDTO.getHotelFacilities() != null) {
            for (HotelFacilityDTO facilityDTO : hotelDTO.getHotelFacilities()) {
                HotelFacility hotelFacility = new HotelFacility();
                hotelFacility.setHotel(savedHotel);
                hotelFacility.setFacility(new Facility(facilityDTO.getFacilityId()));
                hotelFacilityRepository.save(hotelFacility);
            }
        }

        if (hotelDTO.getRooms() != null) {
            for (RoomDTO roomDTO : hotelDTO.getRooms()) {
                RoomType roomType = roomTypeRepository.findById(roomDTO.getRoomTypeId()).orElseThrow(
                        () -> new RuntimeException("RoomType not found with id: " + roomDTO.getRoomTypeId()));
                Room room = mapToRoomEntity(roomDTO, savedHotel, roomType);
                roomRepository.save(room);
                if (roomDTO.getRoomFacilities() != null) {
                    for (RoomFacilityDTO roomFacilityDTO : roomDTO.getRoomFacilities()) {
                        Facility facility = facilityRepository.findById(roomFacilityDTO.getFacilityId()).orElseThrow(
                                () -> new RuntimeException(
                                        "Facility not found with id: " + roomFacilityDTO.getFacilityId()));
                        RoomFacility roomFacility = new RoomFacility();
                        roomFacility.setRoom(room);
                        roomFacilityRepository.save(roomFacility);
                    }
                    roomRepository.save(room);
                }
            }
        }
        return mapToHotelDTO(savedHotel);
    }

    @Transactional
    public HotelDTO updateHotel(Long hotelId, HotelDTO hotelDTO) {
        Hotel existingHotel = hotelRepository.findById(hotelId).orElseThrow(
                () -> new RuntimeException("Hotel not found with id: " + hotelId));
        updateHotelEntity(existingHotel, hotelDTO);
        Hotel updatedHotel = hotelRepository.save(existingHotel);

        updateHotelFacilities(updatedHotel, hotelDTO.getHotelFacilities());

        return mapToHotelDTO(updatedHotel);
    }

    @Transactional
    public void deleteHotel(Long id) {
        Hotel existed = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));

        existed.getRooms().forEach(room -> {
            roomFacilityRepository.deleteAll(room.getRoomFacilities());
        });

        roomRepository.deleteAll(existed.getRooms());

        hotelFacilityRepository.deleteAll(existed.getHotelFacilities());

        hotelRepository.delete(existed);
    }

    public List<GetAllHotelDTO> searchHotels(String hotelName, String city, LocalDate checkinDate,
                                             LocalDate checkoutDate, int rooms, int capacity) {
        List<Hotel> hotels;


        if (hotelName != null && !hotelName.isEmpty() && city != null && !city.isEmpty()) {
            hotels = hotelRepository.findByHotelNameOrCity(hotelName, city);
        } else {
            throw new IllegalArgumentException("Either hotelName or city must be provided.");
        }

        // Lọc các khách sạn dựa trên số lượng phòng trống, sức chứa và ngày, sau đó chuyển đổi thành DTO
        return hotels.stream().map(hotel -> {
                    hotel.setRooms(filterRooms(hotel.getRooms(), checkinDate, checkoutDate, rooms, capacity));
                    return hotel;
                }).filter(hotel -> !hotel.getRooms().isEmpty()) // Chỉ giữ khách sạn có phòng thỏa mãn điều kiện
                .map(this::toDTO).collect(Collectors.toList());
    }

    // Lấy chi tiết khách sạn và lọc theo tiêu chí tìm kiếm
    public GetAllHotelDTO getHotelByIdWithCriteria(Long id, LocalDate checkinDate, LocalDate checkoutDate, int rooms,
                                                   int capacity) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Hotel not found with id: " + id));

        // Lọc các phòng dựa trên tiêu chí tìm kiếm
        hotel.setRooms(filterRooms(hotel.getRooms(), checkinDate, checkoutDate, rooms, capacity));

        return toDTO(hotel);
    }

    private List<Room> filterRooms(List<Room> rooms, LocalDate checkinDate, LocalDate checkoutDate, int requiredRooms,
                                   int capacity) {
        return rooms.stream().filter(room -> room.getCapacity() >= capacity).filter(
                room -> getAvailableRooms(room, checkinDate, checkoutDate) >= requiredRooms).collect(
                Collectors.toList());
    }

    private int getAvailableRooms(Room room, LocalDate checkinDate, LocalDate checkoutDate) {
        long bookedRooms = room.getListBooking().stream().filter(
                booking -> booking.getCheckInDate().isBefore(checkoutDate) && booking.getCheckOutDate().isAfter(
                        checkinDate)).count();
        return room.getQuantity() - (int) bookedRooms;
    }

    public boolean validateDates(LocalDate checkinDate, LocalDate checkoutDate) {
        return checkinDate.isBefore(checkoutDate);
    }

    private GetAllHotelDTO toDTO(Hotel hotel) {
        GetAllHotelDTO hotelDTO = new GetAllHotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setHotelPhoneNum(hotel.getHotelPhoneNum());
        hotelDTO.setHotelStars(hotel.getHotelStars());
        hotelDTO.setHotelDescription(hotel.getHotelDescription());
        hotelDTO.setCheckInTime(hotel.getCheckInTime());
        hotelDTO.setCheckOutTime(hotel.getCheckOutTime());
        hotelDTO.setStatus(hotel.getStatus());
        hotelDTO.setAccommodationType(hotel.getAccommodationType());
        hotelDTO.setHotelFacilities(hotel.getHotelFacilities());
        hotelDTO.setUser(hotel.getUser());
        hotelDTO.setHotelImages(hotel.getHotelImages());
        hotelDTO.setRooms(hotel.getRooms());
        hotel.setListRating(hotel.getListRating());
        return hotelDTO;
    }

    private void updateHotelFacilities(Hotel hotel, List<HotelFacilityDTO> facilityDTOs) {
        List<HotelFacility> existingFacilities = hotelFacilityRepository.findByHotel(hotel);
        hotelFacilityRepository.deleteAll(existingFacilities);

        if (facilityDTOs != null) {
            for (HotelFacilityDTO facilityDTO : facilityDTOs) {
                Facility facility = facilityRepository.findById(facilityDTO.getFacilityId()).orElseThrow(
                        () -> new RuntimeException("Facility not found with id: " + facilityDTO.getFacilityId()));
                HotelFacility hotelFacility = new HotelFacility();
                hotelFacility.setHotel(hotel);
                hotelFacility.setFacility(facility);
                hotelFacilityRepository.save(hotelFacility);
            }
        }
    }

    private Hotel mapToHotelEntity(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setCity(hotelDTO.getCity());
        hotel.setHotelPhoneNum(hotelDTO.getHotelPhoneNum());
        hotel.setHotelStars(hotelDTO.getHotelStars());
        hotel.setHotelDescription(hotelDTO.getHotelDescription());
        hotel.setStatus(hotelDTO.getStatus());
        hotel.setCheckInTime(hotelDTO.getCheckInTime());
        hotel.setCheckOutTime(hotelDTO.getCheckOutTime());
        hotel.setAccommodationType(new AccommodationType(hotelDTO.getAccommodationTypeId()));
        hotel.setUser(new User(hotelDTO.getUserId()));
        return hotel;
    }


    private Room mapToRoomEntity(RoomDTO roomDTO, Hotel hotel, RoomType roomType) {
        Room room = new Room();
        room.setCapacity(roomDTO.getCapacity());
        room.setPrice(roomDTO.getPrice());
        room.setQuantity(roomDTO.getQuantity());
        room.setRoomSize(roomDTO.getRoomSize());
        room.setDescription(roomDTO.getDescription());
        room.setServeBreakfast(roomDTO.isServeBreakfast());
        room.setHotel(hotel);
        room.setRoomType(roomType);
        return room;
    }

    private HotelDTO mapToHotelDTO(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setAddress(hotel.getAddress());
        hotelDTO.setHotelName(hotel.getHotelName());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setHotelPhoneNum(hotel.getHotelPhoneNum());
        hotelDTO.setHotelStars(hotel.getHotelStars());
        hotelDTO.setStatus(hotel.getStatus());
        hotelDTO.setHotelDescription(hotel.getHotelDescription());
        hotelDTO.setCheckInTime(hotel.getCheckInTime());
        hotelDTO.setCheckOutTime(hotel.getCheckOutTime());
        hotelDTO.setAccommodationTypeId(hotel.getAccommodationType().getId());
        hotelDTO.setUserId(hotel.getUser().getId());

        hotelDTO.setRooms(hotel.getRooms().stream().map(r -> {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setId(r.getId());
            roomDTO.setCapacity(r.getCapacity());
            roomDTO.setPrice(r.getPrice());
            roomDTO.setQuantity(r.getQuantity());
            roomDTO.setRoomSize(r.getRoomSize());
            roomDTO.setDescription(r.getDescription());
            roomDTO.setServeBreakfast(r.isServeBreakfast());
            roomDTO.setRoomTypeId(r.getRoomType().getId());

            roomDTO.setRoomFacilities(r.getRoomFacilities().stream().map(rf -> {
                RoomFacilityDTO roomFacilityDTO = new RoomFacilityDTO();
                roomFacilityDTO.setFacilityId(rf.getFacility().getFacId());
                return roomFacilityDTO;
            }).collect(Collectors.toList()));
            return roomDTO;
        }).collect(Collectors.toList()));

        hotelDTO.setHotelFacilities(hotel.getHotelFacilities().stream().map(hf -> {
            HotelFacilityDTO facilityDTO = new HotelFacilityDTO();
            facilityDTO.setFacilityId(hf.getFacility().getFacId());
            return facilityDTO;
        }).collect(Collectors.toList()));

        return hotelDTO;
    }

    private void updateHotelEntity(Hotel hotel, HotelDTO hotelDTO) {
        hotel.setAddress(hotelDTO.getAddress());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setCity(hotelDTO.getCity());
        hotel.setHotelPhoneNum(hotelDTO.getHotelPhoneNum());
        hotel.setHotelStars(hotelDTO.getHotelStars());
        hotel.setHotelDescription(hotelDTO.getHotelDescription());
        hotel.setCheckInTime(hotelDTO.getCheckInTime());
        hotel.setCheckOutTime(hotelDTO.getCheckOutTime());
        hotel.setAccommodationType(new AccommodationType(hotelDTO.getAccommodationTypeId()));
        hotel.setUser(new User(hotelDTO.getUserId()));
        hotel.setStatus(hotelDTO.getStatus());
    }
}
