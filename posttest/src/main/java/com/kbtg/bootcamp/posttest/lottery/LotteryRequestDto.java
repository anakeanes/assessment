package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class LotteryRequestDto {
    @NotNull
    @NotBlank(message = "Please enter 6 digits for lottery number only.")
    @Size(min = 6, max = 6, message = "Please enter 6 digits for lottery number only.")
    @Pattern(regexp = "^[0-9]*$", message = "Please enter 6 digits for lottery number only.")
    @JsonProperty("ticket")
    private String ticketNumber;

    @JsonProperty("price")
    private BigDecimal ticketPrice;

    @JsonProperty("amount")
    private Integer ticketAmount;

    public LotteryRequestDto(String ticketNumber, BigDecimal totalPrice, Integer amount) {
    }
    public LotteryRequestDto() {
    }
    public Integer getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(Integer ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}