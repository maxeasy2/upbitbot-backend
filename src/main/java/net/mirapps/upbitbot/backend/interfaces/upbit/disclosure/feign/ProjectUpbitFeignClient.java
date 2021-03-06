package net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.feign;

import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ProjectUpbitFeignClient", url = "${interfaces.project-upbit.url}")
public interface ProjectUpbitFeignClient {

    @GetMapping("/api/v1/disclosure?region=kr&per_page={page}")
    DisclosureDto getDisclosureInfo(@PathVariable int page);
}
