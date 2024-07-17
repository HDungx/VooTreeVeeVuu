package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.config.VNPayConfig;
import com.VooTreeVeeVuu.controller.PaymentController;
import com.VooTreeVeeVuu.domain.entity.Booking;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import com.VooTreeVeeVuu.services.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class PaymentControllerTests {

    @Mock
    private PaymentService paymentService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    public void testSaveCreatePayment() throws Exception {
        // Mock dữ liệu đầu vào
        String amount = "1000";
        String bankCode = "VCB";
        String language = "vn";
        Long bookingId = 1L;
        Long userId = 1L;
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        // Mock kết quả trả về từ service
        Map<String, String> expectedResponse = new HashMap<>();
        expectedResponse.put("code", "00");
        expectedResponse.put("data", "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?vnp_Amount=100000&vnp_BankCode=VCB&vnp_Command=pay&vnp_CreateDate=20240716193824&vnp_CurrCode=VND&vnp_ExpireDate=20240716195324&vnp_IpAddr=127.0.0.1&vnp_Locale=vn&vnp_OrderInfo=Thanh+toan+don+hang%3A45824161&vnp_OrderType=other&vnp_ReturnUrl=http%3A%2F%2Flocalhost%3A3000%2Fpayment%2Fpayment-complete&vnp_TmnCode=HEBHXO7Q&vnp_TxnRef=45824161&vnp_Version=2.1.0&vnp_SecureHash=cfb3f86b7c672974a9ffc356e0a8e2abc763ee5d892b0666d10d60398bc5665b9f420abd9c7b616f76515b7f3c6fd519b8f9d2b092ceeffaafda352d3d2247b6");
        expectedResponse.put("message", "success");

        Mockito.when(paymentService.createPayment(amount, bankCode, language, bookingId, userId, request))
                .thenReturn(expectedResponse);

        // Chuẩn bị request body
        String requestBody = String.format(
                "amount=%s&bankCode=%s&language=%s&bookingId=%d&userId=%d",
                amount, bankCode, language, bookingId, userId
        );

        // Gửi yêu cầu POST tới endpoint /create và in ra JSON response để kiểm tra
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/payment/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        // In ra JSON response
        String jsonResponse = ((MvcResult) result).getResponse().getContentAsString();
        System.out.println("JSON Response: " + jsonResponse);

        // Kiểm tra các giá trị trong JSON response
        mockMvc.perform(MockMvcRequestBuilders.post("/api/payment/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?vnp_Amount=100000&vnp_BankCode=VCB&vnp_Command=pay&vnp_CreateDate=20240716193824&vnp_CurrCode=VND&vnp_ExpireDate=20240716195324&vnp_IpAddr=127.0.0.1&vnp_Locale=vn&vnp_OrderInfo=Thanh+toan+don+hang%3A45824161&vnp_OrderType=other&vnp_ReturnUrl=http%3A%2F%2Flocalhost%3A3000%2Fpayment%2Fpayment-complete&vnp_TmnCode=HEBHXO7Q&vnp_TxnRef=45824161&vnp_Version=2.1.0&vnp_SecureHash=cfb3f86b7c672974a9ffc356e0a8e2abc763ee5d892b0666d10d60398bc5665b9f420abd9c7b616f76515b7f3c6fd519b8f9d2b092ceeffaafda352d3d2247b6"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("success"))
                .andDo(print());
    }


    @Test
    public void testCreatePayment() throws Exception {
        // Mock dữ liệu đầu vào
        String amount = "1000";
        Long bookingId = 1L;
        Long userId = 1L;
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        // Mock dữ liệu cho các thực thể liên quan
        Booking booking = new Booking(); // Khởi tạo với dữ liệu cần thiết
        User user = new User(); // Khởi tạo với dữ liệu cần thiết

        // Giả lập hành vi của các phương thức service
        Mockito.when(paymentService.updateBookingStatus(bookingId)).thenReturn(booking);
        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Giả lập hành vi của phương thức tạo random number
        String vnp_TxnRef = "12345678";
        VNPayConfig vnPayConfigMock = Mockito.mock(VNPayConfig.class);
        Mockito.when(vnPayConfigMock.getRandomNumber(8)).thenReturn(vnp_TxnRef);

        // Giả lập hành vi của phương thức savePayment
        long amountValue = Integer.parseInt(amount) * 100L;
        Date createDate = new Date();
        Mockito.doNothing().when(paymentService).savePayment(vnp_TxnRef, amountValue, createDate, booking, user);

        // Chuẩn bị request body
        String requestBody = String.format(
                "amount=%s&bookingId=%d&userId=%d",
                amount, bookingId, userId
        );

        // Gửi yêu cầu POST tới endpoint /save-payment và in ra JSON response để kiểm tra
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/payment/save-payment")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        // In ra JSON response
        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println("JSON Response: " + jsonResponse);

        // Kiểm tra các giá trị trong JSON response
        mockMvc.perform(MockMvcRequestBuilders.post("/api/payment/save-payment")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("success"))
                .andDo(print());
    }
}
