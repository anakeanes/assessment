package com.kbtg.bootcamp.posttest.users;

import com.fasterxml.jackson.annotation.JsonProperty;

class UsersGetResponseDto {
    @JsonProperty("id")
    private String ticketId;

    public UsersGetResponseDto(String lottery) {
    }

    public String getTicketId() {
        return ticketId;
    }


}