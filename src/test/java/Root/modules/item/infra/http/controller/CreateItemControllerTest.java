package Root.modules.item.infra.http.controller;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.domain.dtos.request.CreateItemDto;
import Root.modules.items.domain.services.CreateItemService;
import Root.modules.items.infra.http.controller.CreateItemController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreateItemController.class)
public class CreateItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateItemService createItemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRegisterItem() throws Exception {
        CreateItemDto itemDto = new CreateItemDto();
        itemDto.setName("Ovo");
        itemDto.setPrice(30.00);
        itemDto.setDescription("This is an old recipe of my grandpa");
        itemDto.setUrl("https://vitarella.com.br/wp-content/uploads/2020/12/08_LASANHA_FINAL-1-min.jpg");

        ItemModel mockedItem = new ItemModel();
        mockedItem.setId(UUID.randomUUID());
        mockedItem.setName(itemDto.getName());
        mockedItem.setPrice(itemDto.getPrice());
        mockedItem.setDescription(itemDto.getDescription());
        mockedItem.setUrl(itemDto.getUrl());
        Mockito.when(createItemService.saveItem(Mockito.any(ItemModel.class))).thenReturn(mockedItem);

        mockMvc.perform(post("/api/v1/items/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(itemDto)))
                .andExpect(status().isCreated());
    }
}
