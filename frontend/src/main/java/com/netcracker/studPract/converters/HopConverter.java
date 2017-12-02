package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.studPract.beans.HopViewModel;

import java.util.List;

public interface HopConverter {

    List<HopViewModel> convert(List<UsersEntity> usersEntities);
}
