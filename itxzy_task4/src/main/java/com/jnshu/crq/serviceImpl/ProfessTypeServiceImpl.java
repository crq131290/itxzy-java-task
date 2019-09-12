package com.jnshu.crq.serviceImpl;

import com.jnshu.crq.mapper.ProfessTypeMapper;
import com.jnshu.crq.model.ProfessType;
import com.jnshu.crq.service.ProfessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessTypeServiceImpl implements ProfessTypeService {
    @Autowired
    private ProfessTypeMapper professTypeMapper;

    @Override
    public List<ProfessType> getProfessTypeList() {
        return professTypeMapper.getProfessTypeList();
    }
}
