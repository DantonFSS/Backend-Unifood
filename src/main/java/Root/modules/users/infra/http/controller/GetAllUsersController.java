package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.response.UserResponseDto;
import Root.modules.users.domain.dtos.mappers.UserMapper;
import Root.modules.users.domain.services.GetAllUsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Users", description = "Manage Users - Create, Delete, Read and Update any user.")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class GetAllUsersController {

    private final GetAllUsersService uServ;

    @Operation(summary = "Return a list of paginated users", description = "Resource that return a list of users",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Users returned successfully",
                            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class))))
            })
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> execute(){
        List<UserModel> users = uServ.execute();
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.mappingToUserReponseList(users));

    }
}
