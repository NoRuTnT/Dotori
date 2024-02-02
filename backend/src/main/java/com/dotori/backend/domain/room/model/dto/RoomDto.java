package com.dotori.backend.domain.room.model.dto;

import com.dotori.backend.domain.book.model.entity.Book;
import com.dotori.backend.domain.room.model.entity.Room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {
	private Long roomId;
	private Book book;
	private Long hostId;
	private String title;
	private String password;
	private boolean isRecording;
	private int joinCnt;
	private int limitCnt;
	private boolean isPublic;
	private String sessionId;

	public RoomDto(Room room) {
		this.roomId = room.getRoomId();
		this.book = room.getBook();
		this.hostId = room.getHostId();
		this.title = room.getTitle();
		this.password = room.getPassword();
		this.isRecording = room.isRecording();
		this.joinCnt = room.getJoinCnt();
		this.limitCnt = room.getLimitCnt();
		this.isPublic = room.isPublic();
		this.sessionId = room.getSessionId();
	}
}
