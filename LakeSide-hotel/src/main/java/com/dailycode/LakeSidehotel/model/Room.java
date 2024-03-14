package com.dailycode.LakeSidehotel.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	
	private String roomType;
	private BigDecimal roomPrice;
	private boolean isBooked = false;
	
	@Lob
	private Blob photo;
	
	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BookedRoom> bookings;
	
	public Room () {
		this.bookings = new ArrayList<>();
	}
	
	public void addBooking(BookedRoom booking) {
		if(bookings == null) {
			bookings = new ArrayList<>();
		}
		bookings.add(booking);
		booking.setRoom(this);
		isBooked = true;
		String bookingCode = RandomStringUtils.randomNumeric(10);
		booking.setBookingConfermationCode(bookingCode);
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public BigDecimal getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	
	
}
