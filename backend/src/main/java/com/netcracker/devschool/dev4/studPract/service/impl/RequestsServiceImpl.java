package com.netcracker.devschool.dev4.studPract.service.impl;

import com.netcracker.devschool.dev4.studPract.entity.RequestsEntity;
import com.netcracker.devschool.dev4.studPract.repository.RequestsRepository;
import com.netcracker.devschool.dev4.studPract.service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RequestsServiceImpl implements RequestsService{

@Autowired
    RequestsRepository requestsRepository;

    @Override
    public RequestsEntity save(RequestsEntity requestsEntity) {
            if(requestsEntity.getCompanyName().length() > 2 && requestsEntity.getDateFrom()!=null
                    && requestsEntity.getDateTo().getTime() > requestsEntity.getDateFrom().getTime()&&
                    requestsEntity.getIdFaculty()!= 0 && requestsEntity.getIdSpec()!=0&&
                    requestsEntity.getMinAvg() >= 4 && requestsEntity.getMinAvg() <=10 &&
                    requestsEntity.getQuantity() > 0)
        return requestsRepository.save(requestsEntity);
            else
                return null;
    }

    @Override
    public void deleteRequestById(int id) {

        requestsRepository.delete(id);

    }

    @Override
    public List<RequestsEntity> findAllRequests() {
        return (List<RequestsEntity>)requestsRepository.findAll();
    }

    @Override
    public List<RequestsEntity> findRequestByName(String name) {
        return null;
    }
}
