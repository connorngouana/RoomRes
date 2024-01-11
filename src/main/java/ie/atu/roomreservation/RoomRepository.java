package ie.atu.roomreservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface RoomRepository extends JpaRepository<RoomDetails, Long>
{


}
