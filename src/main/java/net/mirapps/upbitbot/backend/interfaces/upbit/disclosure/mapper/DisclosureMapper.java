package net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.mapper;

import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDataPostDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DisclosureMapper {
    int selectDisclosureCount(int id);

    int insertDisclosure(DisclosureDataPostDto dto);

    List<String> selectMarketList(String assets);
}
