package com.mercadopreso.cart.gateways.dto;

import com.mercadopreso.cart.domain.Item;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddItemsRequestDto {

    @NotEmpty()
    private List<@Valid Item> itemIdList;

    @NotBlank()
    private String userId;
}
