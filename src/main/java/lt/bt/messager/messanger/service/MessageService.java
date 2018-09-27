package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.entity.MessageEntity;
import lt.bt.messager.messanger.entity.UserEntity;
import lt.bt.messager.messanger.repository.MessageRepository;
import lt.bt.messager.messanger.repository.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;



    public void createMessage(Message message) {
        MessageEntity entity = new MessageEntity();

        entity.setMessage(message.getMessage());
        entity.setReceiver(userService.findIdFromUsername(message.getReceiver()));
        entity.setSender(userService.findIdFromUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
<<<<<<< Updated upstream
=======
        if (message.getReceiver()==null) {
            if (message.getChannelId()==null) {
                entity.setChannel(Long.parseLong("1"));
            }else {
                entity.setChannel(message.getChannelId());
            }

        }
>>>>>>> Stashed changes

        messageRepository.save(entity);
    }

    public List<Message> fetchUserMessages() {
        Long userId = userService.findIdFromUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<MessageEntity> messages = (List<MessageEntity>) messageRepository.findAllByReceiver(userId);

        List<Message> messageList = new ArrayList<>();

        for(MessageEntity message: messages) {
            Message newMessage = new Message();

            newMessage.setMessage(message.getMessage());
            newMessage.setReceiver(userService.findUserNameFromId(message.getReceiver()));
            newMessage.setSender(userService.findUserNameFromId(message.getSender()));

            messageList.add(newMessage);
        }

        return messageList;

    }


<<<<<<< Updated upstream
//    public List<Message> getUserMessages (String id) {
//            Long ID = Long.parseLong(id);
//         List<MessageEntity> userMessages = messageRepository.findAllByReceiver(ID);
//         if (userMessages!=null) {
//             List<Message> answerMessages = new ArrayList<>();
//             for (MessageEntity msg:userMessages) {
//                 Message message = new Message();
//
//                 message.setMessage(msg.getMessage());
//                 message.setReceiver(userService.findUserNameFromId(msg.getReceiver()));
//                 message.setSender(userService.findUserNameFromId(msg.getSender()));
//
//
//                 answerMessages.add(message);
//             }
//             return answerMessages;
//         }
//
//     return null;
//    }
=======
    public List<Message> getMessagesByChanelId (Long id) {

         List<MessageEntity> userMessages = messageRepository.findAllByChannel(id);
         if (userMessages!=null) {
             List<Message> answerMessages = new ArrayList<>();
             for (MessageEntity msg:userMessages) {
                 Message message = new Message();

                 message.setMessage(msg.getMessage());
                 message.setSender(userService.findUserNameFromId(msg.getSender()));
                 message.setChannelId(msg.getChannel());
                 answerMessages.add(message);
             }
             return answerMessages;
         }

     return null;
    }
>>>>>>> Stashed changes
}
