package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.XyzDAOInt;
import com.rays.dto.XyzDTO;


@Service
@Transactional
public class XyzServiceImpl extends BaseServiceImpl<XyzDTO, XyzDAOInt> implements XyzServiceInt{

}
