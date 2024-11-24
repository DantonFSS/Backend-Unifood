package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.request.CreateUserDto;
import Root.modules.users.domain.dtos.response.CreateUserResponseDto;
import Root.modules.users.domain.dtos.mappers.UserMapper;
import Root.modules.users.domain.dtos.response.UserResponseDto;
import Root.modules.users.domain.services.InsertUserService;
import Root.shared.common.utils.exceptions.httpex.ApplicationError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Users", description = "Manage Users - Create, Delete, Read and Update any user.")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class CreateUserController {

    private final InsertUserService uServ;

    @Operation(
            summary = "Create a new user",
            description = "Resource for create a new user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Data for creating a user",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Exemplo de Requisição",
                                    value = """
                    {
                        "cpf": "123.456.789-00",
                        "name": "Joao Silva",
                        "email": "joao.silva@email.com",
                        "phone": "(11) 98765-4321"
                    }
                    """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "User create successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid field inserted.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
                    @ApiResponse(responseCode = "400", description = "Cpf already used",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
            })
    @PostMapping("/create")
    public ResponseEntity<CreateUserResponseDto> registerUser(@Valid @RequestBody CreateUserDto userDTO) {
        UserModel userToCreate = uServ.saveUser(UserMapper.mappingToUserEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.mappingToUserResponse(userToCreate));
    }
}
