package com.nathanlcr.MarketplaceDublin.service.mapper;

import com.nathanlcr.MarketplaceDublin.entity.User;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserDto;
import com.nathanlcr.MarketplaceDublin.service.Dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper extends EntityMapper<UserResponseDto, User>{
}
