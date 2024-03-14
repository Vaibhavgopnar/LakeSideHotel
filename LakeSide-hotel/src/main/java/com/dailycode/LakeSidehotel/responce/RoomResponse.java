package com.dailycode.LakeSidehotel.responce;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

//import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
public class RoomResponse {

	private Long Id;
	private String roomType;
	private BigDecimal roomPrice;
	private boolean isBooked;
	private String photo;
	private List<BookingResponse> bookings;
	
	public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
		this.Id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
	}

	public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoBytes,
			List<BookingResponse> bookings) {
		this.Id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.isBooked = isBooked;
		this.photo = photoBytes != null ? Base64.getEncoder().encodeToString(photoBytes) : null;
		this.bookings = bookings;
	}
	
	
	
}
