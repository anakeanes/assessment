package com.kbtg.bootcamp.posttest.users;

import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import static com.kbtg.bootcamp.posttest.formatErr.FormatErr.LOTTERY_NOT_FOUND;
import static com.kbtg.bootcamp.posttest.formatErr.FormatErr.LOTTERY_SOLD_OUT_MESSAGE_FORMAT;
import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final LotteryRepository lotteryRepository;

    public UsersService(UsersRepository usersRepository, LotteryRepository lotteryRepository) {
        this.usersRepository = usersRepository;
        this.lotteryRepository = lotteryRepository;
    }



    @Transactional
    public UsersGetResponseDto getLotteryTicket(final String userId, final String lotteryNumber) throws Exception {
        Optional<Lottery> optionalLottery = lotteryRepository.findBy(id);

        if (optionalLottery.isEmpty()) {
            throw new NotFoundException(String.format(LOTTERY_NOT_FOUND, lotteryNumber));
        }

        Lottery lottery = optionalLottery.get();
        validateLotteryAvailable(lottery, lotteryNumber);


        Optional<Users> optionalUser = usersRepository.findBy(id);
        if (optionalUser.isEmpty()) {
            createUser((SecurityProperties.User) id);
        }

        decrementTicketAmount(lottery);
        final Users userTicket = createUserTicket(id, lotteryNumber);
        usersRepository.save(userTicket);
        return new UsersGetResponseDto(userTicket.getLottery());
    }

    private void validateLotteryAvailable(Lottery lottery, String lotteryNumber) {
        if (lottery.getAmout() <= 0) {
            throw new NotFoundException(String.format(LOTTERY_SOLD_OUT_MESSAGE_FORMAT, lotteryNumber));
        }
    }

    private void decrementTicketAmount(Lottery lottery) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void createUser(SecurityProperties.User user) {
        final Users newUser = new Users();
        newUser.setUser(user);
        usersRepository.save(newUser);
    }

    private Users createUserTicket(SingularAttribute<AbstractPersistable, Serializable> id, String lotteryNumber) {
        Users userTicket = new Users();
        userTicket.setLottery(lotteryNumber);
        return userTicket;
    }

}