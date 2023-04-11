package com.ofb.ChatLogApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMsgDto extends JpaRepository<ChatMsg, Integer>{

	public List<ChatMsg> findAll();
	
	public Integer deleteByUserName(String userName);
	
	public Integer deleteByUserNameAndMsgId(String userName, Integer msgId);
	
}
