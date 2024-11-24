package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.response.UserResponseDto;
import Root.modules.users.domain.services.FindUserByName;
import Root.shared.common.utils.exceptions.httpex.ApplicationError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Users", description = "Manage Users - Create, Delete, Read and Update any user.")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class FindUserByNameController {

    private final FindUserByName uServ;

    @Operation(summary = "Find a user", description = "Resource for find a user by name",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User returned successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid field inserted.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class)))
            })
    @GetMapping("/{name}")
    public ResponseEntity<UserModel> findByName(@PathVariable @Valid String name) {
        UserModel user = uServ.searchForName(name);
        return ResponseEntity.ok(user);
    }
}
