package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.users.UsersRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Service;

@Service
public class LotteryService  {
    private final LotteryRepository lotteryRepository;
    private final UsersRepository usersRepository;


    public LotteryService(LotteryRepository lotteryRepository, UsersRepository usersRepository) {
        this.lotteryRepository = lotteryRepository;
        this.usersRepository = usersRepository;
    }

    public List<Lottery> getLotteryList() {
        List<Lottery> lotteryList = lotteryRepository.findAll();
        return lotteryList;
    }

    @Transactional
    public LotteryResponseDto createLottery(LotteryRequestDto requestDto) throws Exception {
        Optional<Lottery> optionalLottery = lotteryRepository.findBy(id);
        if (optionalLottery.isPresent()) {
            Lottery lottery = optionalLottery.get();
            int amount;
            amount = requestDto.getTicketAmount() + lottery.getAmout();
            lottery.setPrice(80);
            lottery.setAmount(amount);
            lotteryRepository.save(optionalLottery.get());
            return new LotteryResponseDto(optionalLottery.get().getLottoTicket());
        }

        Lottery newLottery = new Lottery();
        newLottery.setLottoTicket(requestDto.getTicketNumber());
        newLottery.setPrice(80);
        newLottery.setAmount(requestDto.getTicketAmount());
        lotteryRepository.save(newLottery);
        return new LotteryResponseDto(newLottery.getLottoTicket());
    }

}