package ie.atu.roomreservation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@RestController
public class RoomController
{
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository)
    {
        this.roomRepository = roomRepository;
    }

    @PostMapping("/room-confirm")
    public String RoomConfirm(@RequestBody RoomDetails roomDetails)
    {
        Random random = new Random();
        int roomOption1 = random.nextInt(100) + 1;
        int roomOption2 = random.nextInt(100) + 1;

        String category = "";
        if(roomOption1 <= 33)
        {
            category= "Budget";
        }
      else if (roomOption2 <= 66)
        {
            category = "Standard";
        }
      else
      {
          category = "Deluxe";
        }

      String room1 = String.format("Room Number: " + roomOption1 + "\nRoom Type: " + category);
      String room2 = String.format("Room Number: " + roomOption2 + "\nRoom Type: " + category);

      int choice = roomDetails.getCategory();
      String selectedRoom;
      if (choice == 1)
      {
          selectedRoom = room1 ;
      }
      else
      {
          selectedRoom = room2;
      }

      String selectedRoomNumber = (roomDetails.getCategory() == 1) ? String.valueOf(roomOption1) : String.valueOf(roomOption2);

        RoomDetails selectedRoomEntity = new RoomDetails();
        selectedRoomEntity.setRoomNumber(selectedRoomNumber);
        selectedRoomEntity.setRoomType(category);

        roomRepository.save(selectedRoomEntity);

        return "\nSelected Room: " + selectedRoomNumber + "\nRoom Type: " + category;
    }


}