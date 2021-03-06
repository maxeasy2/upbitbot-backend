package net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDataDto;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDataPostDto;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDto;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.feign.ProjectUpbitFeignClient;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.mapper.DisclosureMapper;
import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.service.DisclosureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class DisclosureServiceImpl implements DisclosureService {

    private final ProjectUpbitFeignClient projectUpbitFeignClient;

    private final DisclosureMapper disclosureMapper;

    @Override
    public DisclosureDto getDisclosureInfo() {
        DisclosureDto disclosureDto = projectUpbitFeignClient.getDisclosureInfo(10);
        DisclosureDataDto disclosureDataDto = disclosureDto.getData();
        List<DisclosureDataPostDto> disclosureDataPostDtoList = disclosureDataDto.getPosts();
        LocalDateTime localDateTime = LocalDateTime.now();
        List<DisclosureDataPostDto> filterList = new ArrayList<>();

        for (DisclosureDataPostDto post : disclosureDataPostDtoList) {
            OffsetDateTime offsetDateTime = OffsetDateTime.parse(post.getStartDate());
            if (localDateTime.isBefore(offsetDateTime.toLocalDateTime())) {
                filterList.add(post);
            }
        }

        if (filterList.size() == 0) {
            disclosureDataDto.setPosts(filterList);
            return disclosureDto;
        }

        List<DisclosureDataPostDto> insertList = new ArrayList<>();
        for (DisclosureDataPostDto post : filterList) {
            if (disclosureMapper.selectDisclosureCount(post.getId()) == 0) {
                if (disclosureMapper.insertDisclosure(post) > 0) {
                    insertList.add(post);
                }
            }
        }

        disclosureDataDto.setPosts(insertList);
        return disclosureDto;
    }
}
