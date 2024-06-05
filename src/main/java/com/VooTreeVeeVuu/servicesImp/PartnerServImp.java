package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.domain.repository.PartnerRepository;
import com.VooTreeVeeVuu.services.PartnerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerServImp implements PartnerServ {
    @Autowired
    PartnerRepository partnerRepository;


}

