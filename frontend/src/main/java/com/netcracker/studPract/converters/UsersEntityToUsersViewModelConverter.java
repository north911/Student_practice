package com.netcracker.studPract.converters;

import com.netcracker.devschool.dev4.studPract.entity.UsersEntity;
import com.netcracker.studPract.beans.UsersViewModel;
import org.springframework.core.convert.converter.Converter;

public class UsersEntityToUsersViewModelConverter  implements Converter<UsersEntity, UsersViewModel> {

    @Override
    public UsersViewModel convert(UsersEntity usersEntity) {
        UsersViewModel usersViewModel = new UsersViewModel();
        usersViewModel.seteMail(usersEntity.geteMail());
        usersViewModel.setFirstName(usersEntity.getFirstName());
        usersViewModel.setLastName(usersEntity.getLastName());

        return usersViewModel;
    }
}
