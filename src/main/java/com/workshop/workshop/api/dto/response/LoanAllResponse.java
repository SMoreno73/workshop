package com.workshop.workshop.api.dto.response;

import com.workshop.workshop.api.dto.response.basic.BookResponse;
import com.workshop.workshop.api.dto.response.basic.LoanResponse;
import com.workshop.workshop.api.dto.response.basic.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanAllResponse extends LoanResponse {
    private UserResponse userId;

    private BookResponse bookId;
}
