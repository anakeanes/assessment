package com.kbtg.bootcamp.posttest.lottery;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
class LotteryResponseDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ticket;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> tickets;


    public LotteryResponseDto(List<String> tickets) {
        this.tickets = tickets;
    }

    public LotteryResponseDto(String ticket) {
        this.ticket = ticket;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}