package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Customer;
import com.VooTreeVeeVuu.entity.Partner;
import com.VooTreeVeeVuu.repository.PartnerRepository;
import com.VooTreeVeeVuu.services.PartnerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerServImp implements PartnerServ {
    @Autowired
    PartnerRepository partnerRepository;


}

