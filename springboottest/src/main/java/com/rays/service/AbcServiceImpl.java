package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AbcDAOInt;
import com.rays.dto.AbcDTO;


@Service
@Transactional
public class AbcServiceImpl extends BaseServiceImpl<AbcDTO, AbcDAOInt> implements AbcServiceInt{

}
