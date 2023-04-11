package com.ofb.ChatLogApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RestAPI {

	@Autowired
	ChatMsgDto chatMsgDto;
	
	@GetMapping("/") 
	public String welcome() { 
		return "Welcome to RestTemplate Example."; 
	}
	 
	
	@PostMapping("/chatlogs/{user}")
	public Integer createMsg(@PathVariable String user, @RequestParam(required=true) String message, 
			@RequestParam(required=true) Integer isSent, @RequestParam(required= true) Long timestamp) {
		ChatMsg cMsg = new ChatMsg(message, timestamp, user, isSent);
		chatMsgDto.save(cMsg);
		return cMsg.getId();
	}

	@GetMapping("/chatlogs/{user}") 
	public List<ChatMsg> getMsg(@PathVariable String user){ 
		return chatMsgDto.findAll(); 
	}
	
	@Transactional
	@DeleteMapping("/chatlogs/{user}/{msgId}")
	public String delete(@PathVariable String user, @PathVariable Integer msgId) {
		if(chatMsgDto.deleteByUserNameAndMsgId(user,msgId)>0)
			return "Success";
		throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "entity not found"
				);
	}

	@Transactional
	@DeleteMapping("/chatlogs/{user}")
	public String deleteAll(@PathVariable String user) {
		Integer deletedRows = chatMsgDto.deleteByUserName(user);
		if(deletedRows>0) {
			return "Success";			
		}
		throw new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "entity not found"
				);
	}
	
}
