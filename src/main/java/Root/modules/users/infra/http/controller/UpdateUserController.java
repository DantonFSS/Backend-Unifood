package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.response.UserResponseDto;
import Root.modules.users.domain.services.UpdateUserService;
import Root.shared.common.utils.exceptions.httpex.ApplicationError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Users", description = "Manage Users - Create, Delete, Read and Update any user.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UpdateUserController {

    private final UpdateUserService uServ;

    @Operation(summary = "Update a existent user", description = "Resource that can update a existent user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User updated successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid id",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
                    @ApiResponse(responseCode = "400", description = "Cpf already used",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class)))
            })
    @PutMapping("/update/{cpf}")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel, @PathVariable UUID id) {
        UserModel savedUser = uServ.update(id, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
