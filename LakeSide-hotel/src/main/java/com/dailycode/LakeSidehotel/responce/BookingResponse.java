package com.dailycode.LakeSidehotel.responce;

import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

	private Long Id;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private String guestFullName;	
	private String guestEmail;
	private int NumOfAdults;
	private int NumOfChildrens;
	private int totalNumOfGuest;
	private String bookingConfermationCode;
	
	private RoomResponse room;
	
	public BookingResponse(Long id, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfermationCode) {
		this.Id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.bookingConfermationCode = bookingConfermationCode;
	}
	
	
}
