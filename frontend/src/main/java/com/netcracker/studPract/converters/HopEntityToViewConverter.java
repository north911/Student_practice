package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.devschool.dev4.studPract.service.UsersService;
import com.netcracker.studPract.beans.HopViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HopEntityToViewConverter implements HopConverter {

    @Autowired
    UsersService usersService;

    @Override
    public List<HopViewModel> convert(List<UsersEntity> usersEntities) {
        List<HopViewModel> hopViewModelList = new ArrayList<>();
        //HopEntityToViewConverter hopEntityToViewConverter = new HopEntityToViewConverter();


        for (UsersEntity usersEntity : usersEntities) {
            HopViewModel hopViewModel = new HopViewModel();
            hopViewModel.setFirstName(usersEntity.getFirstName());
            hopViewModel.setLastName(usersEntity.getLastName());
            hopViewModel.setIdHead(Integer.toString(usersEntity.getIdUsers()));
            hopViewModelList.add(hopViewModel);
        }

        return hopViewModelList;
    }

}
