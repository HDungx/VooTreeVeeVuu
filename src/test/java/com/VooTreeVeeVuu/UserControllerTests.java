    package com.VooTreeVeeVuu;

    import com.VooTreeVeeVuu.controller.UserController;
    import com.VooTreeVeeVuu.domain.utils.Gender;
    import com.VooTreeVeeVuu.dto.UserDTO;
    import com.VooTreeVeeVuu.usecase.UserUseCase.GetAllUser.GetAllUserImpl;
    import com.VooTreeVeeVuu.usecase.UserUseCase.GetUser.GetUserImpl;
    import com.VooTreeVeeVuu.usecase.UserUseCase.UpdateUser.UpdateUserImpl;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.Mockito;
    import org.mockito.MockitoAnnotations;
    import org.springframework.http.MediaType;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
    import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
    import org.springframework.test.web.servlet.setup.MockMvcBuilders;

    import java.util.Optional;

    import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

    public class UserControllerTests {
        @Mock
        private MockMvc mockMvc;

        @InjectMocks
        private UserController userController;

        @Mock
        private GetAllUserImpl getAllUserUseCase;

        @Mock
        private GetUserImpl getUserUseCase;

        @Mock
        private UpdateUserImpl updateUserUseCase;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        }


        @Test
        public void testGetAllUsers() throws Exception {
        }
        @Test
        public void testGetUserById() throws Exception {


            Long userId = 1L;
            UserDTO userDTO = new UserDTO(userId, "John","Doe",  "1990-01-01",Gender.MALE,null);

            // Mock service to return the user by id
            Mockito.when(getUserUseCase.getUserById(userId)).thenReturn(userDTO);

            // Send request to GET /api/users/{id} and expect the user in response
            mockMvc.perform(MockMvcRequestBuilders.get("/api/users/" + userId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(userId))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.dob").value("1990-01-01"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("MALE"))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.account").value(""))
                    .andDo(print());
        }

        @Test
        public void testUpdateUser() throws Exception {
            Long userId = 1L;
            UserDTO userDTO = new UserDTO(userId, "John","Doe",  "1990-01-01",Gender.MALE,null);

            // Mock service to return updated user
            Mockito.when(updateUserUseCase.updateUser(userId, userDTO)).thenReturn(Optional.of(userDTO));

            // JSON representation of the userDTO to be sent in the request body
            String userJson = "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"dob\":\"1990-01-01\",\"gender\":\"MALE\"}";

            // Send request to PUT /api/users/update/{id} with user data and expect the updated user in response
            mockMvc.perform(MockMvcRequestBuilders.put("/api/users/update/" + userId)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(userJson))
                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(userId))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.dob").value("1990-01-01"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("MALE"))
                    .andDo(print());
        }

    }
