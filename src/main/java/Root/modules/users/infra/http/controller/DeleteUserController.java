package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.response.UserResponseDto;
import Root.modules.users.domain.services.DeleteUserService;
import Root.shared.common.utils.exceptions.httpex.ApplicationError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Users", description = "Manage Users - Create, Delete, Read and Update any user.")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class DeleteUserController {

    private final DeleteUserService uServ;

    @Operation(summary = "Delete a user", description = "Resource for delete a new user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User deleted successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid field inserted.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserModel> delete(@PathVariable UUID id) {
        uServ.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
