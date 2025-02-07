package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.VehicleDAOInt;
import com.rays.dto.VehicleDTO;


@Service
@Transactional
public class VehicleServiceImpl extends BaseServiceImpl<VehicleDTO, VehicleDAOInt> implements VehicleServiceInt{

}
