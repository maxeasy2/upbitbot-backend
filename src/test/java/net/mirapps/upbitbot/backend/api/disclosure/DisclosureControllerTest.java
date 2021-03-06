package net.mirapps.upbitbot.backend.api.disclosure;

import net.mirapps.upbitbot.backend.interfaces.notification.NotificationService;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.service.DisclosureService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DisclosureController.class)
class DisclosureControllerTest {

    @MockBean
    private DisclosureService disclosureService;

    @MockBean
    private NotificationService notificationService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void notifyDisclosure() throws Exception {
        mockMvc.perform(get("/api/v1/notification/disclosure")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}