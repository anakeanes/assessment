package  com.kbtg.bootcamp.posttest.users;

import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import static java.util.regex.Pattern.matches;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public  class UsersController {
    private final LotteryService lotteryService;
    private final UsersService usersService;

    public UsersController(LotteryService lotteryService, UsersService usersService) {
        this.lotteryService = lotteryService;
        this.usersService = usersService;
    }

    @PostMapping("/{user_id}/lotteries/{lotteryNumber}")
    public UsersGetResponseDto getLotteryTicket(@PathVariable("user_id") String userId, @PathVariable("lotteryNumber") String lotteryNumber)
        throws Exception {
        String userValidationResult = validateUserId(userId);
        if (!userValidationResult.equals("valid")) {
            throw new BadRequestException(userValidationResult);
        }

        String lotteryValidationResult = validateLotteryNumber(lotteryNumber);
        if (!lotteryValidationResult.equals("valid")) {
            throw new BadRequestException(lotteryValidationResult);
        }

        return usersService.getLotteryTicket(userId, lotteryNumber);
    }

    private String validateUserId(String userId) {
        if (userId == null || userId.isBlank()) {
            return "User ID cannot be null or empty.";
        }
        if (userId.isEmpty() || userId.length() > 100) {
            return "User ID must be between 1 and 100 characters.";
        }
        if (!matches("^[a-zA-Z0-9]*$", userId)) {
            return "User ID must be alphanumeric.";
        }
        return "valid";
    }
    private String validateLotteryNumber(String lotteryNumber) {
        if (lotteryNumber == null || lotteryNumber.isBlank()) {
            return "Lottery number cannot be null or empty.";
        }
        if (lotteryNumber.length() != 6) {
            return "Lottery number must be 6 numbers.";
        }
        if (!matches("^[0-9]*$", lotteryNumber)) {
            return "Lottery number must be numeric.";
        }
        return "valid";
    }
}