package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.ProfessMapper;
import com.jnshu.crq.model.Profess;
import com.jnshu.crq.service.ProfessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessServiceImpl implements ProfessService {

    @Autowired
    private ProfessMapper professMapper;

    @Override
    public List<Profess> getProfessList() {
        return professMapper.getProfessList();
    }
}
