package net.mirapps.upbitbot.backend.api.disclosure;

import lombok.RequiredArgsConstructor;
import net.mirapps.upbitbot.backend.api.common.dto.ResponseDto;
import net.mirapps.upbitbot.backend.interfaces.notification.NotificationService;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDataPostDto;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDto;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.service.DisclosureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DisclosureController {

    private final DisclosureService disclosureService;

    private final NotificationService notificationService;

    private static final String disclosureTitle = "[업비트 공시봇 수집]";

    @Value("${interfaces.upbit-web.exchange}")
    private String upbitWebExchange;

    @GetMapping("/api/v1/notification/disclosure")
    public ResponseEntity<ResponseDto> notifyDisclosure() throws Exception {
        final DisclosureDto disclosureInfo = disclosureService.getDisclosureInfo();
        boolean msgSend = false;
        if (disclosureInfo != null && disclosureInfo.isSuccess() && disclosureInfo.getData() != null) {
            List<DisclosureDataPostDto> posts = disclosureInfo.getData().getPosts();
            if (posts != null && posts.size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(disclosureTitle).append("\n");
                for (DisclosureDataPostDto disclosureDataPostDto : posts) {
                    List<String> marketNameList = disclosureDataPostDto.getMarketNameList();
                    sb.append(disclosureDataPostDto.getAssets());
                    String marketFirst = "";
                    if (marketNameList != null && marketNameList.size() > 0){
                        sb.append("(").append(
                                String.join(",", marketNameList)
                                .replaceAll("-" + disclosureDataPostDto.getAssets(), "")).append(")");
                        marketFirst = marketNameList.get(0);
                    }

                    sb.append(" : ").append(disclosureDataPostDto.getText()).append("\n");

                    if (!"".equals(marketFirst)) {
                        sb.append(upbitWebExchange).append(marketFirst).append("\n");
                    }

                    sb.append("\n");
                }
                notificationService.send(sb.toString());
                msgSend = true;
            }
        }

        ResponseDto responseDto = new ResponseDto();
        if (msgSend) {
            responseDto.setMessage("send");
            return ResponseEntity.ok().body(responseDto);
        } else {
            responseDto.setMessage("nodata");
            return ResponseEntity.ok().body(responseDto);
        }
    }
}
