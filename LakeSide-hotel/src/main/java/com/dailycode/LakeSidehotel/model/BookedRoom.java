package com.dailycode.LakeSidehotel.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@Column(name = "check_In")
	private LocalDate checkInDate;
	
	@Column(name = "check_Out")
	private LocalDate checkOutDate;
	
	@Column(name = "Guest_FullName")
	private String guestFullName;
	
	@Column(name = "Guest_Email")
	private String guestEmail;
	
	@Column(name = "Adult")
	private int NumOfAdults;
	
	@Column(name = "children")
	private int NumOfChildrens;
	
	@Column(name = "total_guest")
	private int totalNumOfGuest;
	
	@Column(name = "confermation_code")
	private String bookingConfermationCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_Id")
	private Room room;
	
	
	
	
	public void setRoom(Room room) {
		this.room = room;
	}

	public void calculateTotalNumOfGuest() {
		this.totalNumOfGuest = this.NumOfAdults + this.NumOfChildrens;
	}

	public void setNumOfAdults(int numOfAdults) {
		NumOfAdults = numOfAdults;
		calculateTotalNumOfGuest();
	}

	public void setNumOfChildrens(int numOfChildrens) {
		NumOfChildrens = numOfChildrens;
		calculateTotalNumOfGuest();
	}

	public void setBookingConfermationCode(String bookingConfermationCode) {
		this.bookingConfermationCode = bookingConfermationCode;
	}

	
	
	
	
		
}
