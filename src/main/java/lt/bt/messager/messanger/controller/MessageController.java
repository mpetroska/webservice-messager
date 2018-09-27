package lt.bt.messager.messanger.controller;

import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @RequestMapping()
    public List<Message> getMessages() {

        return messageService.fetchUserMessages();
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Message createMessage(@RequestBody Message message) {

        messageService.createMessage(message);

        return message;
    }
//    @GetMapping("/{id}")
//    public List<Message> getUserMsg(@PathVariable String id) {
//
//         return messageService.getUserMessages(id);
//    }
}
