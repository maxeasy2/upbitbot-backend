package net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.mapper;

import net.mirapps.upbitbot.backend.interfaces.upbit.disclosure.dto.DisclosureDataPostDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DisclosureMapper {
    int selectDisclosureCount(int id);

    int insertDisclosure(DisclosureDataPostDto dto);
}
