package dev.batugokce.customerservice.customer.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class ChangePasswordDTO {
    @NotBlank
    @Schema(description = "username for the customer account", example = "jack123", required = true)
    String username;

    @NotBlank
    @Schema(description = "old password of the customer", example = "qA1?c5nCQ", required = true)
    String oldPassword;

    @NotBlank
    @Schema(description = "new password for the customer", example = "dA1?1XnCQ", required = true)
    String newPassword;
}
