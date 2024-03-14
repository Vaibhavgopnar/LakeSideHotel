package com.dailycode.LakeSidehotel.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dailycode.LakeSidehotel.model.Room;
import com.dailycode.LakeSidehotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements IRoomService {

	private RoomRepository roomRepository;
	
	@Override
	public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws SerialException, SQLException, IOException {

		Room room = new Room();
		room.setRoomType(roomType);
		room.setRoomPrice(roomPrice);
		if (!file.isEmpty()) {
				byte[] photoBytes = file.getBytes();
				SerialBlob photoBlob = new SerialBlob(photoBytes);
				room.setPhoto(photoBlob); 
		}

		return roomRepository.save(room);
	}

}
